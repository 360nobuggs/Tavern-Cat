package com.example.taverncat2020
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.first_screen)
        Addplayer()
        /*
        val cardModel =
            CardModel("TinderSwipe", "Description for card.", "http://example.com/example.png")
        val cardAdapter = SimpleCardStackAdapter(this)
        cardAdapter.add(cardModel)*/
        // val cardContainer = findViewById<View>(R.id.cardContainer) as CardContainer
        //cardContainer.adapter = cardAdapter
    }

    fun Addplayer() {
        val addplayer = findViewById<Button>(R.id.button2);
        val start = findViewById<Button>(R.id.button)
        val scroller = findViewById<ScrollView>(R.id.scroll);
        val newplayers = arrayOf<EditText>(
            findViewById(R.id.editTextTextPersonName4),
            findViewById(R.id.editTextTextPersonName5),
            findViewById(R.id.editTextTextPersonName6),
            findViewById(R.id.editTextTextPersonName7),
            findViewById(R.id.editTextTextPersonNam8),
            findViewById(R.id.editTextTextPersonNam9),
            findViewById(R.id.editTextTextPersonNam10),
            findViewById(R.id.editTextTextPersonNam11),
            findViewById(R.id.editTextTextPersonNam12),
            findViewById(R.id.editTextTextPersonNam13),
            findViewById(R.id.editTextTextPersonNam14),
            findViewById(R.id.editTextTextPersonNam15),
            findViewById(R.id.editTextTextPersonNam16),
            findViewById(R.id.editTextTextPersonNam17),
            findViewById(R.id.editTextTextPersonNam18),
            findViewById(R.id.editTextTextPersonNam19),
            findViewById(R.id.editTextTextPersonNam20)
        )
        var index = 0
        addplayer.setOnClickListener {
            if (index < 17) {
                newplayers.get(index).visibility = View.VISIBLE
                index++
                scroller.post { scroller.fullScroll(View.FOCUS_DOWN) }
            }
            else
            {
                val mySnackbar= Snackbar.make(
                    findViewById(R.id.layout_first),
                    "Maximum player limit reached.",
                    1500
                )
                mySnackbar.show()
            }
        }

        start.setOnClickListener()
        {
            var players = arrayListOf<String>(
                findViewById<EditText>(R.id.editTextTextPersonName1).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName2).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName3).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName4).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName5).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName6).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonName7).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam8).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam9).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam10).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam11).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam12).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam13).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam14).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam15).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam16).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam17).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam18).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam19).text.toString(),
                findViewById<EditText>(R.id.editTextTextPersonNam20).text.toString()
            )
            var max_size = 0
            for (i in 0 until players.size) {
                players.set(i,players.get(i).capitalize(Locale.ROOT))
                if (players.get(i).length > max_size) {
                    max_size = players.get(i).length
                } }

            if(max_size!=0)
            {
               players = players.filter{ it != "" } as ArrayList<String>


                val b = Bundle()
                b.putStringArrayList(
                    "Jogadores",
                    players
                )
                val intent1 = Intent(this@MainActivity, Cardactivity::class.java)
                //intent1.putExtra("Jogadores", players)
                intent1.putExtras(b)
                startActivity(intent1)
            }
            else
            {
                val mySnackbar= Snackbar.make(
                    findViewById(R.id.layout_first),
                    "Please add player's names.",
                    1500
                )
                mySnackbar.show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        //Log.i(TAG,"onstart")
    }

    override fun onResume() {
        super.onResume()

        //Log.i(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        //Log.i(TAG,"onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Log.i(TAG,"ondestroy")
    }



}
