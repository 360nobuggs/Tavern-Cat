package com.example.taverncat2020

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlin.concurrent.thread
import kotlin.system.exitProcess


class Cardactivity : AppCompatActivity() {
    private var indice=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.card_screen)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        var players= arrayListOf<String>()

        val bundle_main = intent.extras
        if (bundle_main!=null)
        {
            players = bundle_main.getStringArrayList("Jogadores") as ArrayList<String>
        }

        val Mode= arrayOf(1, 2)
        val cardcreator= Cards(players, Mode)
        var lista_cartas : ArrayList<Card> = cardcreator.generate()


            val topCard= findViewById<FrameLayout>(R.id.topCard)
        val bottomCard= findViewById<FrameLayout>(R.id.bottomCard)
        val bottomtext= findViewById<TextView>(R.id.textView)
        val toptext= findViewById<TextView>(R.id.textView2)
        val bottomtit= findViewById<TextView>(R.id.textView4)
        val toptit= findViewById<TextView>(R.id.textView3)
        val viewModel = ViewModelProviders
                .of(this)
                .get(SwipeRightViewModel::class.java)

        viewModel
                .modelStream
                .observe(this, Observer {
                    bindCard(
                        it,
                        topCard,
                        bottomCard,
                        bottomtext,
                        toptext,
                        bottomtit,
                        toptit,
                        lista_cartas
                    )
                })
        val motionLayout= findViewById<MotionLayout>(R.id.motionLayout)

        motionLayout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenPass,
                    R.id.offScreenLike -> {
                        //faz a transição da carta de cima
                        toptit.maxLines = 1
                        motionLayout.setTransition(R.id.rest, R.id.like)
                        motionLayout.progress = 0f//reset de posição
                        viewModel.swipe()//função de alteração de dados
                       if(toptext.text=="The end")
                       {
                           thread{ Thread.sleep(20)
                           exitProcess(0)}
                       }
                    }
                }
            }

        })
       }
var flag = false
    override fun onResume() {
        super.onResume()
        if(!flag){
            /*
            var top=findViewById<LinearLayout>(R.id.linear_top)
            var bottom=findViewById<LinearLayout>(R.id.linear_bottom)
            top.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            var height = top.getMeasuredHeight();
            var width = top.getMeasuredWidth()
            val params: ViewGroup.LayoutParams = top.getLayoutParams()
            params.width = width
            top.requestLayout()
            val param: ViewGroup.LayoutParams = bottom.getLayoutParams()
            param.width = width
            bottom.requestLayout()
            flag= true*/

            var bottom=findViewById<TextView>(R.id.textView)
            val top= findViewById<TextView>(R.id.textView2)
            bottom.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            var height = bottom.getMeasuredHeight();
            var width = bottom.getMeasuredWidth()
            Log.d("DEBUG", "width" + " " + height + " " + width)
            //val param: ViewGroup.LayoutParams = ViewGroup.LayoutParams(width, height)
            val params: ViewGroup.LayoutParams = bottom.getLayoutParams()
            params.width = width
            bottom.requestLayout()
            val params_t: ViewGroup.LayoutParams = top.getLayoutParams()
            params_t.width = width
            top.requestLayout()
            flag=true


        }


        //bottom.layoutParams=param
    }
    private fun limit(){
        var t_bottom=findViewById<TextView>(R.id.textView3)
        val t_top= findViewById<TextView>(R.id.textView4)
        t_bottom.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        var width = t_bottom.getMeasuredWidth()
        val pt:ViewGroup.LayoutParams = t_bottom.getLayoutParams()
        pt.width = width
        t_bottom.requestLayout()
        val pb:ViewGroup.LayoutParams = t_top.getLayoutParams()
        pb.width = width
        t_bottom.maxLines=1
        t_top.requestLayout()
    }
    private fun bindCard(
        model: SwipeRightModel,
        topCard: FrameLayout,
        bottomCard: FrameLayout,
        desc_b: TextView,
        desc_t: TextView,
        tit_b: TextView,
        tit_t: TextView,
        cards: ArrayList<Card>
    ) {
        //var part1= arrayOf("banana banana banana banana banananaanananana banana banana. Banana banana banana banana ", "laranja", "pera pera vperaperaperapera peraperaperapera", "uva", "kiwi", "marmelo", "ananas")
        //quando terminam as cartas volta á inicial
        //atualiza o texto da carta de cima
        var image_bot=findViewById<ImageView>(R.id.imageView)
        var image_top=findViewById<ImageView>(R.id.imageView2)
        tit_t.setText(tit_b.text)
        tit_t.setTextColor(tit_b.currentTextColor)
        desc_t.setText(desc_b.text)
        image_top.setImageDrawable(image_bot.getDrawable())
        //val layout= findViewById<LinearLayout>(R.id.linear_top)
        //Log.d("WIDTH","width"+layout.measuredWidth.toString())
        //Log.d("HEIGHT","width"+layout.measuredHeight.toString())
        //topCard.setBackgroundColor(model.top.backgroundColor)
        if(indice>=cards.size)
        {
            //end the game
            desc_b.setText("The end")

        }
        else
        {
        thread{
            Thread.sleep(15)
            //runOnUiThread{bottomCard.setBackgroundColor(model.bottom.backgroundColor)}
            runOnUiThread { desc_b.setText(cards.get(indice).get_des())}
            runOnUiThread {indice++}
            when(cards.get(indice).get_type())
            {
                1 -> {
                    runOnUiThread { tit_b.setText("Drink") }
                    tit_b.setTextColor(Color.parseColor("#0492C2"))
                    runOnUiThread { image_bot.setImageResource(R.drawable.beer) }
                }
                2 -> {
                    runOnUiThread { tit_b.setText("Vote") }
                    runOnUiThread { image_bot.setImageResource(R.drawable.vote) }
                    tit_b.setTextColor(Color.parseColor("#A1045A"))
                }
                3 -> {
                    runOnUiThread { tit_b.setText("Power Up") }
                    runOnUiThread { image_bot.setImageResource(R.drawable.power) }
                    tit_b.setTextColor(Color.parseColor("#45CB18"))
                }
                4 -> {
                    runOnUiThread { tit_b.setText("Challange") }
                    runOnUiThread { image_bot.setImageResource(R.drawable.challange) }
                    tit_b.setTextColor(Color.parseColor("#FCE205"))
                }
            }}
            }

        }

        //atualiza o texto da carta de baixo
        //bottomCard.setBackgroundColor(model.bottom.backgroundColor)

    }
