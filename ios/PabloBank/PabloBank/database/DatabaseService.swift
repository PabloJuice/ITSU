
import UIKit
import Realm
import RealmSwift

protocol DatabaseService {
    func findAll() -> Array<User>
    //func getObjects<T: DatabaseObject>(of type: T.Type) -> [T]
    func save(_ object: User)
    func update(_ object: User)
    func delete(_ object: User)
    func deleteAll()
    func getIfExists(_ object: User) -> Bool
}


class UserService{
    
    private let realm = try! Realm()
    
    func findAll() -> Array<User> {
        let objects = realm.objects(User.self)
        return Array<User>(objects)
    }
    
    func save(_ object: User) {
        if (getIfExists(object) == nil) {
            try! realm.write {
                realm.add(object)
            }
        }else{
            var user = getIfExists(object)
            try! realm.write {
                user!.password = object.password
                user!.balance = object.balance
                user!.cardNumber = object.cardNumber
                user!.paymentHistory.removeAll()
                for payment in object.paymentHistory{
                    user!.doPayment(payment: payment)
                }
            }
        }
    }
    func delete(_ object: User) {
        let objects = findAll()
                    .compactMap{User(value: $0)}
                    .filter {!object.equals(object: $0) }
                
        deleteAll()
        try? realm.write{
            objects.forEach{realm.add($0)}
        }
    }
//    func getObjects<T>(of type: T.Type) -> [T] where T : DatabaseObject {
//        let objects = realm.objects(type)
//        return Array(objects)
//    }
    
    func update(_ object: User) {
        let users = findAll()
            .compactMap{User(value: $0)}
            .filter {object.login != $0.login }
        deleteAll()
        for user in users{
            save(user)
        }
        save(object)
    }
    func deleteAll() {
        try? realm.write{
            realm.deleteAll()
        }
    }
//    func checkIfExists(_ object: User) -> Bool {
//        return findAll()
//            .compactMap{User(value: $0)}
//            .filter {object.login == $0.login }
//            .count > 0
//    }
    
    func checkCredentials(_ object: User) -> Bool{
        return getIfExists(object) != nil ? findAll()
            .compactMap{User(value: $0)}
            .filter {object.login == $0.login && object.password == $0.password}
            .count > 0 : false
    }
    
    func getIfExists(_ object: User) -> User? {
        return findAll()
            .compactMap{User(value: $0)}
            .filter {object.login == $0.login }.first
    }
    
    func update(_ changes: () -> ()) {
        try? realm.write {
            changes()
        }
    }
    
}
