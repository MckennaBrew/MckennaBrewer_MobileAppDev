package com.example.icecreamsundae

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var message: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message",  "")
        updateUI()
    }

    fun makeSundae(view: View){
        var scoops: String = ""
        var toppingList = ""
        var extras = ""
        var price: Double = 0.0

        val scoopId = radioGroup.checkedRadioButtonId

        if(scoopId == -1){
            val scoopSnackBar = Snackbar.make(rootlLayout, "Please select number of scoops!", Snackbar.LENGTH_SHORT)
            scoopSnackBar.show()
        }
        else {
            scoops = findViewById<RadioButton>(scoopId).text.toString()

            if (scoops == "1 scoop"){
                price += 1.0
             }
            else if(scoops == "2 scoops") {
                price += 2.0
            }
            else {
                price += 3.0
            }

            // dry toppings
            if (checkBox1.isChecked){
                toppingList+= " " + checkBox1.text + ","
                price += 0.15
            }
            if (checkBox2.isChecked){
                toppingList+= " " + checkBox2.text + ","
                price += 0.15
            }
            if (checkBox3.isChecked){
                toppingList+= " " + checkBox3.text + ","
                price += 0.15
            }
            if (checkBox4.isChecked){
                toppingList+= " " + checkBox4.text + ","
                price += 0.15
            }

            // sauces
            if (checkBox5.isChecked){
                toppingList+= " " + checkBox5.text + ","
                price += 0.50
            }
            if (checkBox6.isChecked){
                toppingList+= " " + checkBox6.text + ","
                price += 0.50
            }
            if (checkBox7.isChecked){
                toppingList+= " " + checkBox7.text + ","
                price += 0.50
            }

            if(toppingList.isNotEmpty()){
                toppingList = "with" + toppingList
            }


            val flavor =  " " + spinner.selectedItem + " flavor,"

            // switches
            if(switch1.isChecked) {
                extras+= switch1.text
                price += 0.05
            }
            if (switch2.isChecked){
                extras+= " with a " + switch2.text + " on top"
                price += 0.05
            }


            val finalPrice = String.format("%.2f", price)

            message = "You want $scoops, $flavor $toppingList and $extras. Your total will be $$finalPrice dollars."

            updateUI()


        }

    }

    fun updateUI(){
        messageTextView.text = message
    }



}

