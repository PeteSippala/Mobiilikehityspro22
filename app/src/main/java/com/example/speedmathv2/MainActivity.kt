package com.example.speedmathv2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val EasyButton: Button = findViewById(R.id.buttonEasy)
        EasyButton.setOnClickListener{
            val intent = Intent(this, EasyActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Helppo valittu", Toast.LENGTH_SHORT).show()
        }
        val MidButton: Button = findViewById(R.id.buttonMid)
        MidButton.setOnClickListener{
            val intent = Intent(this, MidActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Keskivaikea valittu", Toast.LENGTH_SHORT).show()
        }
        val HardButton: Button = findViewById(R.id.buttonHard)
        HardButton.setOnClickListener{
            val intent = Intent(this, HardActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Vaikea valittu", Toast.LENGTH_SHORT).show()
        }
        val hardcorebutton: Button = findViewById(R.id.buHardcore)
            hardcorebutton.setOnClickListener{
                val intent = Intent(this, HardcoreActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Hardcore valittu!", Toast.LENGTH_SHORT).show()
        }
    }
}