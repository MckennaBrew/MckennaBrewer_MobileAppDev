//
//  ViewController.swift
//  SpookyCalculator
//
//  Created by Mckenna Brewer on 10/3/20.
//  Copyright © 2020 Mckenna Brewer. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    
    @IBOutlet weak var skeletonLabel: UILabel!
    @IBOutlet weak var skeletonStepper: UIStepper!
    
    @IBOutlet weak var pumpkinLabel: UILabel!
    @IBOutlet weak var pumpkinStepper: UIStepper!
    
    @IBOutlet weak var decoBudget: UITextField!
    
    @IBOutlet weak var spookyRating: UILabel!
    @IBOutlet weak var spookyScore: UILabel!
    
    
    @IBAction func updateSkeletons(_ sender: UIStepper) {
        if skeletonStepper.value == 1{
            skeletonLabel.text = "1 Skeleton"
        }
        else {
            skeletonLabel.text = String(format: "%.0f", skeletonStepper.value) + " Skeletons"
        }
        
        updateScores()
    }
    
    @IBAction func updatePumpkins(_ sender: UIStepper) {
        if pumpkinStepper.value == 1{
            pumpkinLabel.text = "1 Pumpkin"
        }
        else {
            pumpkinLabel.text = String(format: "%.0f", pumpkinStepper.value) + " Pumpkins"
        }
        
        updateScores()
    }
    
    func updateScores() {
        var budget:Float // deco budget
        
        if decoBudget.text!.isEmpty{
            budget = 0.0
        }
        else {
            budget = Float(decoBudget.text!)!
        }
        
        let pumpkins = pumpkinStepper.value
        let skeletons = skeletonStepper.value
        
        let pScore = pumpkins * (1/8)
        let sScore = skeletons * (1/8)
                 
        var score : Float = 0.0
                 
                 // score is out of 10, pumpkins and skeletons are both worth at most 5pts
                 // Added together creates the final score
                 // max value for both = 40   40/5 = 1/8
        
        if pumpkins > 0 && skeletons > 0 {
            score = Float(sScore) + Float(pScore)
        
        }
        else {
            let alert = UIAlertController(title: "Warning", message: "Not even close to spooky! You need more pumpkins & skeletons.", preferredStyle: UIAlertController.Style.alert)
            
            let cancelAction  = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil )
            
            alert.addAction(cancelAction)
            
            let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.pumpkinStepper.value = 1
                self.pumpkinLabel.text? = "1 Pumpkin"
                self.skeletonStepper.value = 1
                self.skeletonLabel.text? = "1 Skeleton"
                self.updateScores() })
            
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        
        
        if score > 7 &&  budget > 80.0 {
            spookyScore.text = String(score)
            spookyRating.text = "SPOOKTACULAR!!!"
        }
        else if score > 3 && budget > 30.0{
            spookyScore.text = String(score)
            spookyRating.text = "Spookish!"
        }
        else {
            spookyScore.text = String(score)
            spookyRating.text = "Not very spooky :("
        }
        
    }
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
          textField.resignFirstResponder()
          return true   // remember func has to return
    }
    
    @IBAction func dismissKeyboardTap(sender: AnyObject) {
        view.endEditing(true)
    }
      
    func textFieldDidEndEditing(_ textField: UITextField) {
          updateScores()
    }
    

    override func viewDidLoad() {
        decoBudget.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

