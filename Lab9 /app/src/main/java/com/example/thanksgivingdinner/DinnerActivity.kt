package com.example.thanksgivingdinner

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dinner.*
import kotlinx.android.synthetic.main.content_dinner.*

class DinnerActivity : AppCompatActivity() {

    private var dessertName : String? = null
    private var dessertURL : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner)
        setSupportActionBar(findViewById(R.id.toolbar))

        dessertName = intent.getStringExtra("dessertName")
        dessertURL = intent.getStringExtra("dessertURL")

        dessertName?.let { Log.i("name received", it) };
        dessertURL?.let { Log.i("url received", it) };

        dessertName?.let { dessertTextView.text = "You should use this recipe: $dessertName" }


        fab.setOnClickListener {
           loadWebSite()
        }
    }

    private fun loadWebSite(){
        //create intent

        var intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = dessertURL?.let { Uri.parse(dessertURL) }

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }


    override fun onBackPressed() {
       val data = Intent()
        data.putExtra("feedback", feedbackEditText.text.toString())
        setResult(Activity.RESULT_OK, data)
        super.onBackPressed()
        finish()
    }
}