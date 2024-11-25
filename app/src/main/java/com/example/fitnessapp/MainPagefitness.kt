package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.fitnessapp.databinding.ActivityMainBinding

class MainPagefitness : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_pagefitness)

        val fitnessbmicard  = findViewById<CardView>(R.id.fitnessTrackerbmi)
        val fitnessState = findViewById<CardView>(R.id.fitnessstate)
        val jogging = findViewById<CardView>(R.id.joggingcard)
        val yoga = findViewById<CardView>(R.id.yogacard)

        fitnessbmicard.setOnClickListener {
            val i1 = Intent(this , FitnessTrackerBmi::class.java)
            startActivity(i1)
        }
        fitnessState.setOnClickListener {
            val intent = Intent(this , FitnessState::class.java )
            startActivity(intent)
        }
        jogging.setOnClickListener {
            val joggingintent = Intent(this , JoggingActivity::class.java)
            startActivity(joggingintent)
        }
        yoga.setOnClickListener {
            val yogaintent = Intent(Intent.ACTION_VIEW)
                yogaintent.data = Uri.parse("https://www.alomoves.com/class-finder?styles=yoga&order=date&")
            startActivity(yogaintent)
            Toast.makeText(this , "Welcome to Yoga page " ,Toast.LENGTH_SHORT).show()

        }

    }
}