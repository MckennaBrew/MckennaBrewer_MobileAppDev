//
//  ViewController.swift
//  Pride&Prejudice
//
//  Created by Mckenna Brewer on 9/4/20.
//  Copyright © 2020 Mckenna Brewer. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artImage: UIImageView!
    
    @IBOutlet weak var quoteText: UILabel!
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1{
            artImage.image = UIImage(named: "Darcy1")
            quoteText.text = "I have faults enough, but they are not, I hope, of understanding. My temper I dare not vouch for."
        }
        else if sender.tag == 2{
            artImage.image = UIImage(named: "Liz1")
            quoteText.text = "Think only of the past as its remembrance gives you pleasure."
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

