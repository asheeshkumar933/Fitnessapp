package com.example.fitnessapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class FitnessTrackerBmi : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_tracker_bmi)


        val height = findViewById<EditText>(R.id.et)
        val weight = findViewById<EditText>(R.id.et1)
        val btncalculate = findViewById<Button>(R.id.button)
        val showtext  = findViewById<TextView>(R.id.textView)
        val health = findViewById<TextView>(R.id.textView1)


        // validate the all inputField



        btncalculate.setOnClickListener {
            if (TextUtils.isEmpty(height.text.toString())){
                height.error =" NUll not Allow"
            }else if (TextUtils.isEmpty(weight.text.toString())) {
                weight.error = "Null not Allow"
            }
            else {
                val h: Float = (height.text.toString() ).toFloat()/100
                val w: Float = (weight.text.toString()).toFloat()
                val r = (w.div((h.times(h))))

                if (r in 18.0..25.0) {
                    showtext.text = "Your BMI : $r"
                    health.text = "you are a healthy guy"
                } else {
                    showtext.text = "Your BMI : $r"
                    health.text = "Not healthy guy , lose your weight"
                }
            }





        }
    }
}


