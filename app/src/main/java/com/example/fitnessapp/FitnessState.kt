
package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import java.util.Locale


class FitnessState : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var running :Boolean = false
    private var totalSteps = 0f
    private  var ispause :Boolean =false
    private var previousTotalSteps = 0f
    private  var steplengthinmeter = 0.762f
    private lateinit var reset: Button
    private var maxstep = 25000
    private  lateinit var  progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_state)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            createrequestpermission()
        }

        loadData()


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        reset = findViewById(R.id.reset_button)

         progressBar = findViewById(R.id.progress_bar)

        reset.setOnClickListener {
            resetSteps()
        }

    }



    override fun onResume() {
        super.onResume()
        running = true

        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


        if (stepSensor == null) {
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }
    override fun onPause() {
        super.onPause()
        running = false
        sensorManager?.unregisterListener(this)
        Toast.makeText(this, "Event pause", Toast.LENGTH_SHORT).show()
    }

    override fun onSensorChanged(event: SensorEvent?) {

        val tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        val distance = findViewById<TextView>(R.id.tv_goal)


        if (running) {
            totalSteps = event!!.values[0]

            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()

            tv_stepsTaken.text = ("$currentSteps")
            progressBar.progress = currentSteps
            progressBar.max = maxstep
            progressBar.progressBackgroundTintList =ColorStateList.valueOf(Color.GREEN)

//            progressBar.progressTintList = ColorStateList.valueOf(Color.RED)

            var distanceinkm = currentSteps * steplengthinmeter/1000
            distance.text =
                String.format(Locale.getDefault() , "Distance : %.2f km " , distanceinkm)

        }
    }

//    fun resetSteps() {
//        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
//        tv_stepsTaken.setOnClickListener {
//            // This will give a toast message if the user want to reset the steps
//            Toast.makeText(this, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
//        }
//
//        tv_stepsTaken.setOnLongClickListener {
//
//            previousTotalSteps = totalSteps
//
//            // When the user will click long tap on the screen,
//            // the steps will be reset to 0
//            tv_stepsTaken.text = 0.toString()
//
//            // This will save the data
//            saveData()
//
//            true
//        }
//    }

    @SuppressLint("SetTextI18n")
    fun resetSteps() {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        var distance = findViewById<TextView>(R.id.tv_goal)

        previousTotalSteps = totalSteps
        tv_stepsTaken.text = 0.toString()
        distance.text = "Distance : 0.00 km"
        progressBar.progress = 0
        saveData()
    }

    private fun saveData() {

        // Shared Preferences will allow us to save
        // and retrieve data in the form of key,value pair.
        // In this function we will save data
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }

    private fun loadData() {

        // In this function we will retrieve data
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1", 0f)

        // Log.d is used for debugging purposes
        Log.d("MainActivity", "$savedNumber")
        previousTotalSteps = savedNumber
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // We do not have to write anything in this function for this app
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun createrequestpermission(){
        if (ActivityCompat.checkSelfPermission(this ,android.Manifest.permission.ACTIVITY_RECOGNITION)
            !=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this , arrayOf(android.Manifest.permission.ACTIVITY_RECOGNITION) ,13 )
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==13){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACTIVITY_RECOGNITION),
                    13
                )
            }
        }


    }
}