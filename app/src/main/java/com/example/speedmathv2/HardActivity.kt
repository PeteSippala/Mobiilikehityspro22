package com.example.speedmathv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.speedmathv2.databinding.ActivityEasyBinding
import com.example.speedmathv2.databinding.ActivityHardBinding


class HardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //valitaan plus laskut
        binding.plus.setOnClickListener {
            val calInt = Intent(
                this@HardActivity,
                HardGameActivity::class.java
            )

            calInt.putExtra("cals", "+")
            startActivity(calInt)
        }
        //valitaan miinus
        binding.miinus.setOnClickListener {
            val calInt = Intent(
                this@HardActivity,
                HardGameActivity::class.java
            )

            calInt.putExtra("cals", "-")
            startActivity(calInt)
        }
        //valitaan kerto
        binding.kerto.setOnClickListener {
            val calInt = Intent(
                this@HardActivity,
                HardGameActivity::class.java
            )

            calInt.putExtra("cals", "*")
            startActivity(calInt)
        }
        //valitaan jako
        binding.jako.setOnClickListener {
            val calInt = Intent(
                this@HardActivity,
                HardGameActivity::class.java
            )

            calInt.putExtra("cals", "÷")
            startActivity(calInt)
        }
    }
}