import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var resultLabel: UILabel!
    
    var calcController:CalculationController!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        calcController = CalculationController(label: resultLabel)
    }
    
    @IBAction func keyInput(_ sender: UIButton) {
        calcController.input(inp: Character(extendedGraphemeClusterLiteral: (sender.titleLabel?.text?.first)!))

    }
    @IBAction func calculateResult(_ sender: UIButton) {
        calcController.calculate()
    }
    
    
    
    
//    let operators = ["-", "+", "/", "*"]
//    let numbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
//
//
//
//    @IBAction func KeyInput(_ sender: UIButton) {
//        if resultLabel.text! == "0" || sender.titleLabel?.text == ""{
//            resultLabel.text = sender.titleLabel?.text ?? ""
//        }
//        else{
//            resultLabel.text = resultLabel.text! + (sender.titleLabel?.text ?? "")
//        }
//    }
//
//    @IBAction func Cleat(_ sender: UIButton) {
//        resultLabel.text?.removeAll()
//        resultLabel.text = "0"
//    }
//
//    @IBAction func Delete(_ sender: UIButton) {
//        resultLabel.text?.removeLast()
//    }
//
//    @IBAction func PlusMinus(_ sender: UIButton) {
//        if !operators.contains(String(resultLabel.text!.last ?? " ")){
//            resultLabel.text! += sender.titleLabel?.text ?? ""
//        }
//    }
//
//    @IBAction func Calculate(_ sender: UIButton) {
//        var result : Int = 0
//        var action : String = "+"
//        var resultNumbers = [" "]
//        for n in resultLabel.text!{
//            if !numbers.contains(String(n)){
//                resultNumbers = resultLabel.text!.components(separatedBy: String(n))
//                action = String(n)
//            }
//        }
//
//        for n in resultNumbers{
//            switch action {
//            case "+":
//                result += Int(n) ?? 0
//            case "-":
//                result -= Int(n) ?? 0
//            case "*":
//                result *= Int(n) ?? 1
//            case "/":
//                result /= Int(n) ?? 1
//            default:
//                break
//            }
//        }
//        ResultLabel.text = String(result)
//}
}

