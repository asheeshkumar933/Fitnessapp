package com.example.fitnessapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView

class JoggingArticleDetailActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogging_article_detail)

        val heading = intent.getStringExtra("heading")
        val articlecontent = intent.getStringExtra("content")
        val articleimage = intent.getIntExtra("imageid" ,R.drawable.j2)



        var headingtv = findViewById<TextView>(R.id.textViewheadig)
        var contenttv = findViewById<TextView>(R.id.textViewcontent)
        var imagetv = findViewById<ImageView>(R.id.imageViewimage)

        headingtv.text = heading
        contenttv.text = articlecontent
        imagetv.setImageResource(articleimage)

//        val fstring =  SpannableString(articlecontent )
//        val fbold = StyleSpan(Typeface.BOLD)
//        val fcolor = ForegroundColorSpan(Color.RED)
//        fstring.setSpan(fbold ,400 ,800 , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        fstring.setSpan(fcolor,400 ,800 , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        contenttv.text = fstring
//        contenttv.text = fstring


    }




}