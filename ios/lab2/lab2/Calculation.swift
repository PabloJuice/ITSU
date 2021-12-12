import Foundation

enum Calculation : Character, CaseIterable{

    case plus = "+";
    case minus = "-";
    case multiply = "*";
    case divide = "/";
    case percent = "%";
    
    static func returnAll() -> String{
        return "+-*/%="
    }
    
    func action(numOne: Double, numTwo: Double) -> String{
        switch self {
        case .plus:
            if numTwo == 0 {
                //numTwo = numOne
            }
            return String(Int(numOne + numTwo))
        case .minus:
            return String(Int(numOne - numTwo))
        case .multiply:
            return String(Int(numOne * numTwo))
        case .divide:
            return String(numOne / numTwo)
        case .percent:
            return String((numOne / 100) * numTwo)
        }
    }
}
