package com.example.astrologer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun giveZodiac(view: View){

        // edit text
        val editDate = findViewById<EditText>(R.id.editTextName)
        val enterBDate: String =  editDate.text.toString()
        val birthDate: Float = enterBDate.toFloat()


        // message + image

        // text view
        val signText = findViewById<TextView>(R.id.textMessage)

        val imageSign = findViewById<ImageView>(R.id.imageView)
        imageSign.setImageResource(R.drawable.zodiac)

        if (birthDate >= 1.22 && birthDate <= 2.20 )
        {
            signText.setText("You are an Aquarius! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.aquarius)
        }
        else if (birthDate >= 2.21 && birthDate <= 3.19)
        {
            signText.setText("You are a Pisces! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.pisces)
        }
        else if (birthDate >= 3.20 && birthDate <= 4.20)
        {
            signText.setText("You are an Aries! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.aries)
        }
        else if (birthDate >= 4.21 && birthDate <= 5.21)
        {
            signText.setText("You are a Taurus! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.taurus)
        }
        else if (birthDate >= 5.22 && birthDate <= 6.22)
        {
            signText.setText("You are a Gemini! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.gemini)
        }
        else if (birthDate >= 6.23 && birthDate <= 7.22)
        {
            signText.setText("You are a Cancer! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.cancer)
        }
        else if (birthDate >= 7.23 && birthDate <= 8.22)
        {
            signText.setText("You are a Leo! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.leo)
        }
        else if (birthDate >= 8.23 && birthDate <= 9.22)
        {
            signText.setText("You are a Virgo! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.virgo)
        }
        else if (birthDate >= 9.23 && birthDate <= 10.22)
        {
            signText.setText("You are a Libra! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.libra)
        }
        else if (birthDate >= 10.23 && birthDate <= 11.22)
        {
            signText.setText("You are a Scorpio! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.scorpio)
        }
        else if (birthDate >= 11.23 && birthDate <= 12.22)
        {
            signText.setText("You are a Sagittarius! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.sagittarius)
        }
        else
        {
            signText.setText("You are a Capricorn! Born  " + birthDate)
            imageSign.setImageResource(R.drawable.capricorn)
        }

    }


}