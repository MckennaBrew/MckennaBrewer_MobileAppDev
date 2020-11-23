package com.example.thanksgivingdinner

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.app.Activity
import android.text.Editable
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_dinner.*

class MainActivity : AppCompatActivity() {
    private var myDessert = Dessert();
    private var selectedLocationPosition = 0
    private val REQUEST_CODE = 1

    var dinnerMessage : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // event listener
        dessertButton.setOnClickListener{
            selectedLocationPosition = spinner.selectedItemPosition
            myDessert.suggestDessert(selectedLocationPosition)
            Log.i("recipe suggested", myDessert.name)
            Log.i("url suggested", myDessert.url)

            //create intent
            val intent = Intent(this, DinnerActivity::class.java)
            intent.putExtra("dessertName", myDessert.name)
            intent.putExtra("dessertURL", myDessert.url)

            //startActivity(intent)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("dinnerMessage", dinnerMessage)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dinnerMessage = savedInstanceState.getString("dinnerMessage", "")
        updateUI()
    }

    fun createDinner(view: View){
        var meat : CharSequence = ""
        var sidesList = ""  // string
        var sauceList = ""

        val meatId = radioGroup.checkedRadioButtonId

        if(meatId == -1){
            val meatSnackbar = Snackbar.make(root_layout, "Please select a protein", Snackbar.LENGTH_SHORT)
            meatSnackbar.show()
        }
        else {
            meat = findViewById<RadioButton>(meatId).text

            if (checkBox1.isChecked) {
                sidesList += " " + checkBox1.text + ","
            }
            if (checkBox2.isChecked) {
                sidesList += " " + checkBox2.text + ","
            }
            if (checkBox3.isChecked) {
                sidesList += " " + checkBox3.text + ","
            }
            if (checkBox4.isChecked) {
                sidesList += " " + checkBox4.text + ","
            }
            if (checkBox5.isChecked) {
                sidesList += " a" + checkBox5.text + ","
            }
            if (checkBox6.isChecked) {
                sidesList += " " + checkBox6.text + ","
            }


            if (sidesList.isNotEmpty()) {
                sidesList = "with" + sidesList
            }

            // spinner
            val dessert : String = " " + spinner.selectedItem

            //switches
            if (switch1.isChecked){
                sauceList += switch1.text
            }
            if (switch2.isChecked){
               sauceList += " and " + switch2.text
            }

            dinnerMessage = "For dinner you want $meat with $sidesList topped with $sauceList. For dessert you want$dessert."

            updateUI()
        }
    }

    fun updateUI(){
        messageTextView.text = dinnerMessage
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            reviewTextView.setText(data?.let { data.getStringExtra("feedback") })
        }
    }


}