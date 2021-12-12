import UIKit
import Realm
import RealmSwift


protocol DatabaseObject: Object {}

@objcMembers
class User: Object, DatabaseObject{
    	
    
    dynamic var login : String = ""
    dynamic var password : String = ""
    dynamic var balance : Double = 0
    dynamic var cardNumber : String = ""
    
    let paymentHistory = List<Payment>()
    
    convenience init(login: String, password: String) {
        self.init()
        self.login = login
        self.password = password
        self.cardNumber = generateCard()
    }
    
    func doPayment(payment: Payment) {
        self.balance = payment.changeBalance(balance: balance)
        self.paymentHistory.append(payment)
    }
    
    func equals(object: User) -> Bool {
        return self.login == object.login && self.password == object.password
    }
    func isValid() -> Bool{
        let loginSample =  "^[A-Zaa-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$"
        let passwordSample = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$"
        return self.login.matches(loginSample) && self.password.matches(passwordSample)
    }
    
    func generateCard() -> String {
        var result : String = "5168"
        for _ in 0...2 {
            var current:String = ""
            repeat {
                current = String(format:"%04d", arc4random_uniform(10000))
            } while Set<Character>(current).count < 4
            result += (" " + current)
        }
        return result
    }
    func clone() -> User {
        var result = User(login: self.login, password: self.password)
        result.balance = self.balance
        result.cardNumber = self.cardNumber
        for payment in self.paymentHistory{
            result.doPayment(payment: payment)
        }
        return result
    }
}

@objcMembers
class Payment : RealmSwiftObject{
    dynamic var action : String = "+"
    dynamic var amount : Double = 0
    dynamic var info : String = ""
    dynamic var id : String!
    dynamic var note : String = ""
    dynamic var date : Date!
    
    convenience init(action: String, amount: Double, info: String) {
        self.init()
        self.action = action
        self.amount = amount
        self.info = info
        self.id = generateId()
        self.date = Date.init()
    }
    func changeBalance(balance: Double) -> Double {
        if self.action == "+" {
            return balance + amount
        }
        else{
            return balance - amount
        }
    }
    func generateId() -> String {
        let letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return String((0..<16).map{ _ in letters.randomElement()! })
    }
    func clone() -> Payment {
        var result : Payment = Payment(action: self.action, amount: self.amount, info: self.info)
        result.id = self.id
        result.note = self.note
        result.date = self.date
        return result
    }
}
