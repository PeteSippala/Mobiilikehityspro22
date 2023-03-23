package com.example.speedmathv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random
import kotlin.math.round

class EasyGameActivity : AppCompatActivity() {

    var AikaTextView :TextView? = null
    var QuestionTextText :TextView? = null
    var PisteTextView :TextView? = null
    var AlertTextView :TextView? = null
    var lopputulosTextView :TextView? = null
    var button0 :Button? = null
    var button1 :Button? = null
    var button2 :Button? = null
    var button3 :Button? = null
    var countDownTimer :CountDownTimer? = null
    var random :Random = Random
    var a = 0.0
    var b = 0.0

    var indexOfCorrectAnswer = 0
    var answers = ArrayList<Double>()
    var points = 0
    var totalQuestions = 0
    var cals = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_game)
        val calInt = intent.getStringExtra("cals")
        cals = calInt!!
        AikaTextView = findViewById(R.id.AikaTextView)
        QuestionTextText = findViewById(R.id.QuestionTextText)
        PisteTextView = findViewById(R.id.PisteTextView)
        AlertTextView = findViewById(R.id.AlertTextView)

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        start()


    }

    fun NextQuestion(cal:String){
        a = random.nextDouble(10.0)
        b = random.nextDouble(10.0)
        val RA: Double = String.format("%.1f",a).toDouble()
        val RB: Double = String.format("%.1f",b).toDouble()
        QuestionTextText!!.text="$RA $cal $RB"
        indexOfCorrectAnswer = random.nextInt(4)

        answers.clear()

        for (i in 0..3){
            if (indexOfCorrectAnswer == i){

                when(cal){
                    "+"->{answers.add(a+b)}
                    "-"->{answers.add(a-b)}
                    "*"->{answers.add(a*b)}
                    "÷"->{
                        try {
                            answers.add(a/b)
                        }
                        catch (e:java.lang.Exception){
                            e.printStackTrace()
                        }
                    }

                }
            }
            else{
                var wrongAnswer = random.nextDouble(20.0)
                try{
                    while(
                        wrongAnswer == a+b
                        || wrongAnswer == a-b
                        || wrongAnswer == a*b
                        || wrongAnswer == a/b
                    ){
                        wrongAnswer =random.nextDouble(20.0)
                    }
                    answers.add(wrongAnswer)
                }
                catch (e:Exception){
                    e.printStackTrace()
                }

            }


        }

        try {
            button0!!.text = "${answers[0]}"
            button1!!.text = "${answers[1]}"
            button2!!.text = "${answers[2]}"
            button3!!.text = "${answers[3]}"

        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun optionselect(view:View?){
        totalQuestions++
        if (indexOfCorrectAnswer.toString() == view!!.tag.toString()){

            points++
            AlertTextView!!.text = "Correct"
        }
        else{
            AlertTextView!!.text = "Wrong"
        }
        PisteTextView!!.text = "$points/$totalQuestions"
        NextQuestion(cals)
    }
    fun PlayAgain(view:View?){
        points = 0
        totalQuestions = 0
        PisteTextView!!.text = "$points/$totalQuestions"
        countDownTimer!!.start()
    }

    private fun start() {
        NextQuestion(cals)
        countDownTimer = object :CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
                AikaTextView!!.text = (p0 / 1000).toString()+"s"
            }

            override fun onFinish() {
                AikaTextView!!.text = "Aika Loppui!"
                openDilog()
            }
        }.start()
    }

    private fun openDilog() {
        val inflate = LayoutInflater.from(this)
        val winDialog = inflate.inflate(R.layout.activity_tulos,null)
        lopputulosTextView = winDialog.findViewById(R.id.lopputulosTextView)
        val buttonPlayAgain = winDialog.findViewById<Button>(R.id.ButtonPlayAgain)
        val buttonBack = winDialog.findViewById<Button>(R.id.ButtonBack)
        val dialog = AlertDialog.Builder(this)
        dialog.setCancelable(false)
        dialog.setView(winDialog)
        lopputulosTextView!!.text ="$points/$totalQuestions"
        buttonPlayAgain.setOnClickListener { PlayAgain(it) }
        buttonBack.setOnClickListener{ onBackPressedDispatcher.onBackPressed() }
        val showDialog = dialog.create()
        showDialog.show()
    }
}