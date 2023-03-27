package com.example.speedmathv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.speedmathv2.databinding.ActivityEasyBinding


class EasyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEasyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEasyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plus.setOnClickListener{
            val calInt = Intent(this@EasyActivity,
                EasyGameActivity::class.java)

            calInt.putExtra("cals","+")
            startActivity(calInt)
        }
        binding.miinus.setOnClickListener{
            val calInt = Intent(this@EasyActivity,
                EasyGameActivity::class.java)

            calInt.putExtra("cals","-")
            startActivity(calInt)
        }
    }
}