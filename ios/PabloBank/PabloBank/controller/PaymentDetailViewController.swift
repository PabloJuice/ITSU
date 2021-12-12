import UIKit


class PaymentDetailViewController: UIViewController {

    @IBOutlet weak var paymentInfo: UILabel!
    @IBOutlet weak var paymentDate: UILabel!
    @IBOutlet weak var paymentAction: UILabel!
    @IBOutlet weak var paymentAmount: UILabel!
    @IBOutlet weak var paymentId: UILabel!
    @IBOutlet weak var paymentNote: UITextField!
    
    @IBOutlet weak var btnbtn: UIButton!
    var payment : Payment!
    var historyTable : UITableView!
    var user : User!
    var userService : UserService!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        paymentInfo.text = payment.info
        paymentDate.text = "12:55 00.00.2020"
        paymentAction.text = payment.action
        paymentAmount.text = String(payment.amount)
        paymentNote.text = payment.note
        paymentId.text = payment.id
    }
    
    @IBAction func editPaymentNote(_ sender: UITextField) {
//        user.paymentHistory.compactMap{Payment(value: $0)}
//            .filter {self.payment.id == $0.id }.first!.note = sender.text ?? ""
//        userService.save(user)
        
        userService.update {
            payment.note = sender.text ?? ""
        }
        
        print(userService.getIfExists(user)!.paymentHistory)
        historyTable.reloadData()
        

    }
    
}

