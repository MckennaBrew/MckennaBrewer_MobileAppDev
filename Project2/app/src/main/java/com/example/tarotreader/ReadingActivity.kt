package com.example.tarotreader

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_reading.*

class ReadingActivity : AppCompatActivity() {

    private var readingType : Int? = null
    private var readingTopic: Int? = null
    // private var birthDate: String? = null

    //private val shuffleArray = IntArray(22){it * 1} // 0 - 21, for each of 22 tarot cards

    var cardTitle: String = " "
    var cardDesc: String = " "

    var cardTitle2: String = " "
    var cardDesc2: String = " "

    var cardTitle3: String = " "
    var cardDesc3: String = " "

    var shareString: String = " "

    val cardDrawables = arrayOf(R.drawable.world , R.drawable.wheeloffortune,
            R.drawable.tower, R.drawable.temperance, R.drawable.sun, R.drawable.strength, R.drawable.star,
            R.drawable.moon, R.drawable.magician, R.drawable.lovers, R.drawable.justice, R.drawable.judgement,
            R.drawable.highpriestess, R.drawable.hierophant, R.drawable.hermit, R.drawable.hangedman,
            R.drawable.fool, R.drawable.empress, R.drawable.emperor, R.drawable.devil, R.drawable.death, R.drawable.chariot)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)
        setSupportActionBar(findViewById(R.id.toolbar))

        readingType = intent.getIntExtra ("readType", 0)
        readingTopic = intent.getIntExtra("readTopic", 0)

        readingType?.let { Log.i("type received", it.toString()) };
        readingTopic?.let { Log.i("topic received", it.toString()) };

        var cardImage1: ImageView = findViewById(R.id.imageView)
        var cardImage2: ImageView = findViewById(R.id.imageView2)
        var cardImage3: ImageView = findViewById(R.id.imageView3)

        when (readingType) {
            1 -> {   // 1 card reading
                val cardShuffle = (0..21).shuffled().take(1).toSet()

                cardTitle = resources.getStringArray(R.array.cardTitles)[cardShuffle.elementAt(0)]

                when (readingTopic) {
                    1 -> { // love
                        cardDesc = resources.getStringArray(R.array.cardsLove)[cardShuffle.elementAt(0)]
                    }
                    2 -> { // career
                        cardDesc = resources.getStringArray(R.array.cardsCareer)[cardShuffle.elementAt(0)]
                    }
                    3 -> { //daily
                        cardDesc = resources.getStringArray(R.array.cardsDaily)[cardShuffle.elementAt(0)]
                    }
                }

                cardTitle?.let {cardMessageT.text = "First Card: $cardTitle "}
                cardDesc?.let{cardMessageD.text = "$cardDesc"}

                cardImage1.setImageResource(cardDrawables[cardShuffle.elementAt(0)])

                shareString = "$cardTitle - $cardDesc "

            }
            2 -> {  // 2 card reading
                val cardShuffle2 = (0..21).shuffled().take(2).toSet()

                cardTitle = resources.getStringArray(R.array.cardTitles)[cardShuffle2.elementAt(0)]
                cardTitle2 = resources.getStringArray(R.array.cardTitles)[cardShuffle2.elementAt(1)]

                when (readingTopic) {
                    1 -> { // love
                        cardDesc = resources.getStringArray(R.array.cardsLove)[cardShuffle2.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsLove)[cardShuffle2.elementAt(1)]
                    }
                    2 -> { // career
                        cardDesc = resources.getStringArray(R.array.cardsCareer)[cardShuffle2.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsCareer)[cardShuffle2.elementAt(1)]
                    }
                    3 -> { //daily
                        cardDesc = resources.getStringArray(R.array.cardsDaily)[cardShuffle2.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsDaily)[cardShuffle2.elementAt(1)]
                    }
                }

                cardTitle?.let {cardMessageT.text = "First Card: $cardTitle "}
                cardDesc?.let{cardMessageD.text = "$cardDesc"}

                cardTitle2?.let {cardMessageT2.text = "Second Card: $cardTitle2 "}
                cardDesc2?.let{cardMessageD2.text = "$cardDesc2"}

                cardImage1.setImageResource(cardDrawables[cardShuffle2.elementAt(0)])
                cardImage2.setImageResource(cardDrawables[cardShuffle2.elementAt(1)])

                shareString = "$cardTitle - $cardDesc $cardTitle2 - $cardDesc2"


            }
            3 -> { // 3 card reading
                val cardShuffle3 = (0..21).shuffled().take(3).toSet()

                cardTitle = resources.getStringArray(R.array.cardTitles)[cardShuffle3.elementAt(0)]
                cardTitle2 = resources.getStringArray(R.array.cardTitles)[cardShuffle3.elementAt(1)]
                cardTitle3 = resources.getStringArray(R.array.cardTitles)[cardShuffle3.elementAt(2)]

                when (readingTopic) {
                    1 -> { // love
                        cardDesc = resources.getStringArray(R.array.cardsLove)[cardShuffle3.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsLove)[cardShuffle3.elementAt(1)]
                        cardDesc3 = resources.getStringArray(R.array.cardsLove)[cardShuffle3.elementAt(2)]
                    }
                    2 -> { // career
                        cardDesc = resources.getStringArray(R.array.cardsCareer)[cardShuffle3.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsCareer)[cardShuffle3.elementAt(1)]
                        cardDesc3 = resources.getStringArray(R.array.cardsCareer)[cardShuffle3.elementAt(2)]
                    }
                    3 -> { //daily
                        cardDesc = resources.getStringArray(R.array.cardsDaily)[cardShuffle3.elementAt(0)]
                        cardDesc2 = resources.getStringArray(R.array.cardsDaily)[cardShuffle3.elementAt(1)]
                        cardDesc3 = resources.getStringArray(R.array.cardsDaily)[cardShuffle3.elementAt(2)]
                    }
                }

                cardTitle?.let {cardMessageT.text = "First Card: $cardTitle "}
                cardDesc?.let{cardMessageD.text = "$cardDesc"}

                cardTitle2?.let {cardMessageT2.text = "Second Card: $cardTitle2 "}
                cardDesc2?.let{cardMessageD2.text = "$cardDesc2"}

                cardTitle3?.let {cardMessageT3.text = "Third Card: $cardTitle3 "}
                cardDesc3?.let{cardMessageD3.text = "$cardDesc3"}

                cardImage1.setImageResource(cardDrawables[cardShuffle3.elementAt(0)])
                cardImage2.setImageResource(cardDrawables[cardShuffle3.elementAt(1)])
                cardImage3.setImageResource(cardDrawables[cardShuffle3.elementAt(2)])

                shareString = "$cardTitle - $cardDesc $cardTitle2 - $cardDesc2 $cardTitle3 - $cardDesc3"

            }
        }


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            shareReading()
        }
    }



    private fun shareReading(){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareString)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

        // NOTE
        // I used this link as a guide for this snippet of code that implements the share functionality of my app
        // https://developer.android.com/training/sharing/send.html#using-android-system-sharesheet
    }

}