package com.example.speedmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speedmath.databinding.ActivityPeliBinding



class PeliActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPeliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeliBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.plus.setOnClickListener{
           val calInt = Intent(this@PeliActivity,
               MainActivity::class.java)

           calInt.putExtra("cals","+")
           startActivity(calInt)
       }
        binding.miinus.setOnClickListener{
            val calInt = Intent(this@PeliActivity,
                MainActivity::class.java)

            calInt.putExtra("cals","-")
            startActivity(calInt)
        }
        binding.kerto.setOnClickListener{
            val calInt = Intent(this@PeliActivity,
                MainActivity::class.java)

            calInt.putExtra("cals","*")
            startActivity(calInt)
        }
        binding.jako.setOnClickListener{
            val calInt = Intent(this@PeliActivity,
                MainActivity::class.java)

            calInt.putExtra("cals","÷")
            startActivity(calInt)
        }
    }
}