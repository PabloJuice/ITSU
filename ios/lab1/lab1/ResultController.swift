import UIKit

class ResultController: UIViewController {
    

    @IBOutlet weak var RatingLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func rateUs(_ sender: UISlider) {
        RatingLabel.text = sender.value < 50 ? "Sorry for that" : "thanks"
    }
    
}
