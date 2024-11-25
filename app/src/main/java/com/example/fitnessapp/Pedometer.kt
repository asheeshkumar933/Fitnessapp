package com.example.fitnessapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Pedometer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedometer)

        val bottom = findViewById<BottomNavigationView>(R.id.bottomnavigationview)

        replacewithfragment(Home())

        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home-> replacewithfragment(Home())
                R.id.setting ->replacewithfragment(Settingfragment())
                else -> {
                    Toast.makeText(this , "Failed" ,Toast.LENGTH_SHORT).show()
                }
            }
             true
        }

    }

    @SuppressLint("CommitTransaction")
    private fun replacewithfragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmetntransaction = fragmentManager.beginTransaction()
        fragmetntransaction.replace(R.id.framelayout , fragment)

        fragmetntransaction.commit()
    }
}