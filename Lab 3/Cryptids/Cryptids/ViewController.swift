//
//  ViewController.swift
//  Cryptids
//
//  Created by Mckenna Brewer on 9/19/20.
//  Copyright © 2020 Mckenna Brewer. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var mainImage: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var fontSizeSlider: UISlider!
    
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBOutlet weak var colorSwitch: UISwitch!
    
    
    
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0{
            mainImage.image = UIImage(named: "sasquatch")
            titleLabel.text = "Sasquatch"
        }
        else if imageControl.selectedSegmentIndex == 1{
            mainImage.image = UIImage(named: "mothman")
            titleLabel.text = "Mothman"
        }
        else if imageControl.selectedSegmentIndex == 2{
            mainImage.image = UIImage(named: "jerseyDevil")
            titleLabel.text = "Jersey Devil"
        }
    }
    
    func updateCaps(){
        if capitalSwitch.isOn{
            titleLabel.text = titleLabel.text?.uppercased()
        }
        else {
            titleLabel.text = titleLabel.text?.lowercased()
        }
    }
    
    func updateFontColor(){
        if colorSwitch.isOn{
            titleLabel.textColor = UIColor.green
        }
        else {
            titleLabel.textColor = UIColor.red
        }
    }
    
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
        updateCaps()
        updateFontColor()
    }
    
    
    @IBAction func updateFont(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func updateColor(_ sender: UISwitch) {
        updateFontColor()
    }
    
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        
        let fontSize = sender.value  // float
        
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        
        let fontSizeCGFloat = CGFloat(fontSize)
        
        titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

}

