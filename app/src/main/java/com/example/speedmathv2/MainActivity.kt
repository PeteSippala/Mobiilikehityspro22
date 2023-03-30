package com.example.speedmathv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
        private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth= FirebaseAuth.getInstance()
        findViewById<Button>(R.id.buttonSignOut).setOnClickListener{
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }

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
    }
}