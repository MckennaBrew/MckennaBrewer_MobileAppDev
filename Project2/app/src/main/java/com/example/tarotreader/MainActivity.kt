package com.example.tarotreader

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.RadioButton
import android.app.Activity
import android.view.View
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var myCards = Cards();

    private val REQUEST_CODE = 1

    private var selectedTopic = ""
    private var selectedType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var initialTypeId = radioGroupType.checkedRadioButtonId
        var initialTopicId = radioGroupTopic.checkedRadioButtonId

        readButton.setOnClickListener {

            initialTypeId = radioGroupType.checkedRadioButtonId
            initialTopicId = radioGroupTopic.checkedRadioButtonId

            if (initialTypeId == -1 || initialTopicId == -1){
                val tarotSnackbar = Snackbar.make(root_layout, "Please select both a reading type and topic!", Snackbar.LENGTH_SHORT)
                tarotSnackbar.show()
            }
            else {
                selectedType = findViewById<RadioButton>(initialTypeId).text.toString()
                selectedTopic = findViewById<RadioButton>(initialTopicId).text.toString()

                myCards.suggestCards(selectedType, selectedTopic)

                Log.i( "reading type", myCards.readType.toString());
                Log.i( "reading topic", myCards.readTopic.toString());


                // create intent

                val intent = Intent(this, ReadingActivity::class.java)
                intent.putExtra("readType", myCards.readType)
                intent.putExtra("readTopic", myCards.readTopic)

                startActivity(intent)
            }
        }
    }

}