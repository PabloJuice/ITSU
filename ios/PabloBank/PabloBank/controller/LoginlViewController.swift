//
//  ViewController.swift
//  PabloBank
//
//  Created by abb on 08.04.2021.
//

import UIKit
import Realm
import RealmSwift


class LoginViewController: UIViewController {
    private let userService: UserService = UserService()

    @IBOutlet weak var messageField: UILabel!
    
    @IBOutlet weak var loginField: UITextField!
    
    @IBOutlet weak var passwordField: UITextField!
    
    var user: User = User()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        userService.deleteAll()
        var admin : User = User(login: "admin@gmail.com", password: "Admin1234")
        admin.doPayment(payment: Payment(action: "+", amount: 3500.0, info: "Zarplata"))
        admin.doPayment(payment: Payment(action: "-", amount: 15.0, info: "Transport fare"))
        admin.doPayment(payment: Payment(action: "-", amount: 300.0, info: "Shopping"))
        admin.doPayment(payment: Payment(action: "-", amount: 15.0, info: "Transport fare"))
        admin.doPayment(payment: Payment(action: "-", amount: 200.0, info: "Shopping"))
        admin.doPayment(payment: Payment(action: "-", amount: 15.0, info: "Transport fare"))
        admin.doPayment(payment: Payment(action: "-", amount: 150.0, info: "Shopping"))
        admin.doPayment(payment: Payment(action: "+", amount: 150.0, info: "Shopping Refund"))
        admin.doPayment(payment: Payment(action: "-", amount: 15.0, info: "Transport fare"))
        userService.save(admin)
        print(admin.paymentHistory)
        print(admin.paymentHistory[0])
        // Do any additional setup after loading the view.
    }

    @IBAction func loginAction(_ sender: UIButton) {
        user = User(login: loginField.text!, password: passwordField.text!)
            
        if user.isValid(){
            if userService.checkCredentials(user) {
                user = userService.getIfExists(user)!
                print(user.paymentHistory)
                print(user.paymentHistory[0])
                self.performSegue(withIdentifier: .user, sender: nil)
            }else{
                showErrorAlert(message: "login failed")
            }
        }else{
            showErrorAlert(message: "check creditals")
        }
            
        print(userService.findAll())
        //print(userService.getIfExists(user))
        

    }
    @IBAction func registerAction(_ sender: UIButton) {
        if !(userService.getIfExists(User(login: loginField.text!, password: passwordField.text!)) != nil) && User(login: loginField.text!, password: passwordField.text!).isValid()  {
            userService.save(User(login: loginField.text!, password: passwordField.text!))
        }else{
            showErrorAlert(message: "registration failed")
        }
        
    }
    
    func showErrorAlert(message : String) {
        let alert = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Ok", style: .cancel, handler: {action in print("error")}))
        self.present(alert, animated: true, completion: nil)
    }
    
}
extension LoginViewController: SegueHandlerType{
    enum SegueIdentifier: String {
        case user = "MainViewControllerSegue"
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segueIdentifier(for: segue){
            case .user:
                let destination = segue.destination as! MainViewController
                destination.user = user
        }
    }
}

