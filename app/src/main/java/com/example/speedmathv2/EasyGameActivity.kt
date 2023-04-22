package com.example.speedmathv2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import kotlin.random.Random
import kotlin.math.round

class EasyGameActivity : AppCompatActivity() {

    // Luodaan ja alustetaan muuttujat
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
    var a = 0
    var b = 0
    var indexOfCorrectAnswer = 0
    var answers = ArrayList<Int>()
    var points = 0
    var totalQuestions = 0
    var cals = ""
    private lateinit var mediaPlayer: MediaPlayer
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
    // Luodaan lasku toimitus, kaksi satunnaista numeroa +,-,*
    // samalla luodaan myös 4 vastausta, joista 1 on oikein.

    fun NextQuestion(cal:String){
        a = random.nextInt(50)
        b = random.nextInt(50)
        QuestionTextText!!.text="$a $cal $b"
        indexOfCorrectAnswer = random.nextInt(4)

        answers.clear()

        for (i in 0..3){
            if (indexOfCorrectAnswer == i){

                when(cal){
                    "+"->{answers.add(a+b) }
                    "-"->{answers.add(a-b) }
                }
            }
            else{
                var wrongAnswer = random.nextInt(100)
                try{
                    while(
                        wrongAnswer == a+b
                        || wrongAnswer == a-b
                    ){
                        wrongAnswer =random.nextInt(100)
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
    // Funktio, kun vastaus on oikein tai väärin
    fun optionselect(view:View?){
        totalQuestions++
        if (indexOfCorrectAnswer.toString() == view!!.tag.toString()){
            points++
            AlertTextView!!.text = "Correct"
            // VAstaus oikein, saat pisteen

        }
        else{
            points--
            AlertTextView!!.text = "Wrong"
            // VAstaus väärin, menetät pisteen
        }
        PisteTextView!!.text = "$points"
        NextQuestion(cals)
    }
    // Funktio aloittaa pelin uudelleen, alustaen pisteet ja ajan
    fun PlayAgain(view:View?){
        points = 0
        totalQuestions = 0
        PisteTextView!!.text = "$points"
        countDownTimer!!.start()
    }

    // Funtio joka aloittaa pelin
    private fun start() {
        NextQuestion(cals)
        countDownTimer = object :CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
                AikaTextView!!.text = (p0 / 1000).toString()+"s"
            }

            override fun onFinish() {
                AikaTextView!!.text = "Aika Loppui!"
                openDialog()
            }
        }.start()
    }
    // funktio kun peli loppuu, avaa activity_tulos

    private fun openDialog() {
        val inflate = LayoutInflater.from(this)
        val winDialog = inflate.inflate(R.layout.activity_tulos,null)
        lopputulosTextView = winDialog.findViewById(R.id.lopputulosTextView)
        val buttonPlayAgain = winDialog.findViewById<Button>(R.id.ButtonPlayAgain)
        val buttonBack = winDialog.findViewById<Button>(R.id.ButtonBack)
        val dialog = AlertDialog.Builder(this)
        dialog.setCancelable(false)
        dialog.setView(winDialog)
        lopputulosTextView!!.text ="$points"
        // jos pisteitä alle 10, alkaa soimaan sirkusmusiikki
        if (points < 10) {
            if (!this::mediaPlayer.isInitialized) {
                mediaPlayer = MediaPlayer.create(this, R.raw.circus)
            }
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
        }
        // jos pisteitä yli 10, alkaa soimaan gigachad
        if (points > 10) {
            if (!this::mediaPlayer.isInitialized) {
                mediaPlayer = MediaPlayer.create(this, R.raw.gigachad)
            }
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
        }
        val showDialog = dialog.create()
        showDialog.show()
        buttonPlayAgain.setOnClickListener { PlayAgain(it)
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
        showDialog.cancel()}
        buttonBack.setOnClickListener{ onBackPressedDispatcher.onBackPressed()
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}