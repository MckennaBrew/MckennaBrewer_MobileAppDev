//
//  ViewController.swift
//  BudgetFly
//
//  Created by Mckenna Brewer on 10/5/20.
//  Copyright © 2020 Mckenna Brewer. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet weak var moneyAvail: UITextField!
    
    @IBOutlet weak var exspenseLabel: UILabel!
    @IBOutlet weak var savingsLabel: UILabel!
    
    @IBOutlet weak var budgetType: UISegmentedControl!

    @IBOutlet weak var rentDue: UITextField!
    @IBOutlet weak var groceriesDue: UITextField!
    @IBOutlet weak var billsDue: UITextField!
    @IBOutlet weak var funDue: UITextField!
    
    
    
    @IBAction func updateSeg(_ sender: UISegmentedControl) {
        updateTotals()
    }
    
    
    func textToFloat (_ textField: UITextField) -> Float {
        var temp:Float
       
        if textField.text!.isEmpty {
            temp = 0.0
        }
        else {
            temp = Float(textField.text!)!
        }
        
        return temp
        
    }
    
    
    func updateTotals() {
        
        let rent : Float = textToFloat(rentDue)
        let groceries : Float = textToFloat(groceriesDue)
        let bills : Float = textToFloat(billsDue)
        let fun : Float = textToFloat(funDue)
        
        var moneyAv:Float
        
        if moneyAvail.text!.isEmpty{
            let alert = UIAlertController(title: "Warning", message: "You need to enter some amount of money.", preferredStyle: UIAlertController.Style.alert)
            
            let cancelAction  = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil )
            alert.addAction(cancelAction)
            
            let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.moneyAvail.text = "1"
                self.updateTotals() })
            
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
            
            moneyAv = 0.0
        }
        else {
            moneyAv = Float(moneyAvail.text!)!
        }
        
        
        
        var exspenses : Float = 0.0
        var savings : Float = 0.0
        
        
        // so enter money you have
        // budget is for the next week or month(4 weeks)
        // week wont change amounts
        // month will take amounts and multiple them by 4
        // subtract amount from money available
        
        
        if budgetType.selectedSegmentIndex == 0 {
            exspenses = (rent/4) + groceries + bills + fun
            savings = moneyAv - exspenses
            
        }
        else if budgetType.selectedSegmentIndex == 1{
            exspenses = rent + (groceries*4) + (bills*4) + (fun*4)
            savings = moneyAv - exspenses
    
        }
        
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle = NumberFormatter.Style.currency
        
        exspenseLabel.text = currencyFormatter.string(from: NSNumber(value: exspenses))
        savingsLabel.text = currencyFormatter.string(from: NSNumber(value: savings))
        
    }
    
    
    
    
    @IBAction func shareBudget(_ sender: UIBarButtonItem) {
        // need to first create image of screen via 'screenshot'
        
        
        
        let bounds = UIScreen.main.bounds
        UIGraphicsBeginImageContextWithOptions(bounds.size, true, 0.0)
        self.view.drawHierarchy(in: bounds, afterScreenUpdates: false)
        let img = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        
        // now we want to share our screenshot
        
        let activityViewController = UIActivityViewController(activityItems: [img!], applicationActivities: nil)
        activityViewController.popoverPresentationController?.sourceView = self.view
        self.present(activityViewController, animated: true, completion: nil)
        
        
        /* code created frome example here:  https://stackoverflow.com/questions/35931946/basic-example-for-sharing-text-or-image-with-uiactivityviewcontroller-in-swift
        */
        
        
    }
    
    
    
    @IBAction func dismissKeyboardTap(sender: AnyObject) {
           view.endEditing(true)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
           textField.resignFirstResponder()
           return true   // remember func has to return
    }
     
    func textFieldDidEndEditing(_ textField: UITextField) {
          updateTotals()
    }
    
    override func viewDidLoad() {
        
        moneyAvail.delegate = self
        rentDue.delegate = self
        groceriesDue.delegate = self
        billsDue.delegate = self
        funDue.delegate = self
        
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

