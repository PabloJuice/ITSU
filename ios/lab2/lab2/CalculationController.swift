import UIKit
import Foundation

class CalculationController{
    private var line : UILabel!
    
    init(label : UILabel?){
        self.line = label!
    }
    
    func input(inp : Character){
        if checkZero() == false {
            if inp.isNumber {
                line.text! += String(inp)
            }
            else if inp == "D" {
                if line.text!.count > 1 {
                    deleteLast()
                }
                else{
                    clearLine()
                }
            }
            else if inp == "C"	 {
                clearLine()
            }
            else{
                if checkAction() == false {
                    line.text! += String(inp)
                }
            }
        }
        else{
            if inp.isNumber {
                line.text! = String(inp)
            }
        }
        
        
        //line.text = String(inp)
    }
    func calculate() {
        var num1 : String = ""
        var num2 : String = ""
        var action : Character = "+"
        
        var status:Bool = false
        
        for char:Character in line.text! {
            if char.isNumber{
                if !status {
                    num1 += String(char)
                }
                else{
                    num2 += String(char)
                }
            }else{
                action = char
                status = true
            }
        }
        if status {
            line.text! = Calculation.init(rawValue: action)!.action(numOne: Double(num1)!, numTwo: num2 != "" ? Double(num2)! : Double(0))
        }
        else{
            line.text! = num1
        }
        
    }
    func deleteLast(){
        line.text!.removeLast()
    }
    func clearLine() {
        line.text! = "0"
    }
    func checkZero() -> Bool {
        return line.text! == "0"
    }
    func checkAction() -> Bool{
        for char:Character in Calculation.returnAll() {
            if line.text!.contains(char) {
                return true
            }
        }
        return false
    }
    
    
}
