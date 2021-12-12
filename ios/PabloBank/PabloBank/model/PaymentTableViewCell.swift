//
//  PaymentTableViewCell.swift
//  PabloBank
//
//  Created by abb on 05.05.2021.
//

import UIKit

class PaymentTableViewCell: UITableViewCell {
    
    @IBOutlet weak var paymentInfo: UILabel!
    @IBOutlet weak var paymentDate: UILabel!
    @IBOutlet weak var paymentQuantity: UILabel!
    @IBOutlet weak var paymentAction: UILabel!
    
    static let identifier = "PaymentTableViewCellID"
    
    static func nib() -> UINib{
        return UINib(nibName: identifier, bundle: nil)
    }
    
    public func configure(payment: Payment){
        paymentInfo.text = payment.info
        //paymentDate.text = DateFormatter().string(from:payment.date)
        paymentDate.text = "12:55 00.00.2020"
        paymentQuantity.text = String(payment.amount)
        paymentAction.text = payment.action
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
