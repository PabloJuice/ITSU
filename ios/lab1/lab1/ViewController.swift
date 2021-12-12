import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    let operators = ["-", "+", "/", "*"]
    let numbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    @IBOutlet weak var TextLabel: UILabel!
    @IBOutlet weak var ResultLabel: UILabel!
    
    @IBAction func KeyInput(_ sender: UIButton) {
        if TextLabel.text! == "0" || sender.titleLabel?.text == ""{
            TextLabel.text = sender.titleLabel?.text ?? ""
        }
        else{
            TextLabel.text = TextLabel.text! + (sender.titleLabel?.text ?? "")
        }
    }
    
    @IBAction func Cleat(_ sender: UIButton) {
        TextLabel.text?.removeAll()
        TextLabel.text = "0"
    }
    
    @IBAction func Delete(_ sender: UIButton) {
        TextLabel.text?.removeLast()
    }
    
    @IBAction func PlusMinus(_ sender: UIButton) {
        if !operators.contains(String(TextLabel.text!.last ?? " ")){
            TextLabel.text! += sender.titleLabel?.text ?? ""
        }
    }
    
    @IBAction func Calculate(_ sender: UIButton) {
        var result : Int = 0
        var action : String = "+"
        var resultNumbers = [" "]
        for n in TextLabel.text!{
            if !numbers.contains(String(n)){
                resultNumbers = TextLabel.text!.components(separatedBy: String(n))
                action = String(n)
            }
        }

        for n in resultNumbers{
            switch action {
            case "+":
                result += Int(n) ?? 0
            case "-":
                result -= Int(n) ?? 0
            case "*":
                result *= Int(n) ?? 1
            case "/":
                result /= Int(n) ?? 1
            default:
                break
            }
        }
        ResultLabel.text = String(result)
}
}
