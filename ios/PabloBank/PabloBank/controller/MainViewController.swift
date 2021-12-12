//
//  MainViewController.swift
//  PabloBank
//
//  Created by abb on 08.04.2021.
//

import UIKit
import Realm
import RealmSwift

class MainViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UISearchResultsUpdating, UISearchBarDelegate{

    
    private let userService: UserService = UserService()
    var user : User = User()
    
    @IBOutlet weak var historyTable: UITableView!
    @IBOutlet weak var cardUserName: UILabel!
    
    @IBOutlet weak var cardBalance: UILabel!
    @IBOutlet weak var cardNumber: UILabel!
    
    @IBOutlet weak var searchContainer: UIView!
    let searchController = UISearchController()
    
    var filteredPayments : Array<Payment>!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        user = userService.getIfExists(user) ?? user
        cardUserName.text = user.login
        cardBalance.text = String(user.balance) + " UAH"
        cardNumber.text = user.cardNumber
        historyTable.delegate = self
        historyTable.dataSource = self
        initSearchController()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if searchController.isActive {
            return filteredPayments.count
        }
        return user.paymentHistory.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let customCell = tableView.dequeueReusableCell(withIdentifier: PaymentTableViewCell.identifier, for: indexPath) as! PaymentTableViewCell
        customCell.configure(payment: user.paymentHistory[indexPath.row])

        return customCell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.performSegue(withIdentifier: "showPaymentDetail", sender: self)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "showPaymentDetail" {
            let indexPath = self.historyTable.indexPathForSelectedRow!
            let tableViewDetail = segue.destination as? PaymentDetailViewController
            let selectedPayment = user.paymentHistory[indexPath.row]
            tableViewDetail!.payment = selectedPayment//.clone()
            tableViewDetail!.user = user//.clone()
            tableViewDetail!.userService = userService
            tableViewDetail!.historyTable = historyTable
            self.historyTable.deselectRow(at: indexPath, animated: true)
            print(selectedPayment)
            
        }
    }
    
    func initSearchController(){
        searchController.loadViewIfNeeded()
        searchController.searchResultsUpdater = self
        searchController.obscuresBackgroundDuringPresentation = false
        searchController.searchBar.heightAnchor.constraint(equalToConstant: 10).isActive = true
        searchController.searchBar.heightAnchor.constraint(equalToConstant: 10).isActive = false
        searchController.searchBar.sizeToFit()
        searchController.searchBar.enablesReturnKeyAutomatically = false
        searchController.searchBar.returnKeyType = UIReturnKeyType.done
        searchController.hidesNavigationBarDuringPresentation = false
        
        definesPresentationContext = true
        searchController.searchBar.scopeButtonTitles = ["All", "+", "-"]
        searchController.searchBar.delegate = self
        //historyTable.addSubview(searchController.searchBar)
        searchContainer.addSubview(searchController.searchBar)
    }
    
    func updateSearchResults(for searchController: UISearchController) {
        let searchBar = searchController.searchBar
        let scopeButton = searchBar.scopeButtonTitles![searchBar.selectedScopeButtonIndex]
        let searchText = searchBar.text!
        
        filterForSearchTextAndScopeButton(searchText: searchText, scopeButton: scopeButton)
    }
    func filterForSearchTextAndScopeButton(searchText: String, scopeButton: String = "All"){
        filteredPayments = Array(user.paymentHistory).filter{
            payment in
            let scopeMatch = (scopeButton == "All" || scopeButton == payment.action)
            if (searchController.searchBar.text != ""){
                let searchTextMatch = (payment.info.lowercased().contains(searchText.lowercased()))
                return scopeMatch && searchTextMatch
            }
            else{
                return scopeMatch
            }
        }
        historyTable.reloadData()
    }

    

}
