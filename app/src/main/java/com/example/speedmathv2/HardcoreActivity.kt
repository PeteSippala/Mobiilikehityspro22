package com.example.speedmathv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.speedmathv2.databinding.ActivityEasyBinding
import com.example.speedmathv2.databinding.ActivityHardBinding
import com.example.speedmathv2.databinding.ActivityHardcoreBinding


class HardcoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHardcoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHardcoreBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plus.setOnClickListener {
            val calInt = Intent(
                this@HardcoreActivity,
                HardcoreGameActivity::class.java
            )

            calInt.putExtra("cals", "+")
            startActivity(calInt)
        }
        binding.miinus.setOnClickListener {
            val calInt = Intent(
                this@HardcoreActivity,
                HardcoreGameActivity::class.java
            )

            calInt.putExtra("cals", "-")
            startActivity(calInt)
        }
        binding.kerto.setOnClickListener {
            val calInt = Intent(
                this@HardcoreActivity,
                HardcoreGameActivity::class.java
            )

            calInt.putExtra("cals", "*")
            startActivity(calInt)
        }
        binding.jako.setOnClickListener {
            val calInt = Intent(
                this@HardcoreActivity,
                HardcoreGameActivity::class.java
            )

            calInt.putExtra("cals", "÷")
            startActivity(calInt)
        }
    }
}