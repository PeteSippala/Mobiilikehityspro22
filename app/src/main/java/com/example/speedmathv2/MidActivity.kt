package com.example.speedmathv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.speedmathv2.databinding.ActivityEasyBinding
import com.example.speedmathv2.databinding.ActivityMidBinding


class MidActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMidBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMidBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plus.setOnClickListener {
            val calInt = Intent(
                this@MidActivity,
                MidGameActivity::class.java
            )

            calInt.putExtra("cals", "+")
            startActivity(calInt)
        }
        binding.miinus.setOnClickListener {
            val calInt = Intent(
                this@MidActivity,
                MidGameActivity::class.java
            )

            calInt.putExtra("cals", "-")
            startActivity(calInt)
        }
        binding.kerto.setOnClickListener {
            val calInt = Intent(
                this@MidActivity,
                MidGameActivity::class.java
            )

            calInt.putExtra("cals", "*")
            startActivity(calInt)
        }
    }
}