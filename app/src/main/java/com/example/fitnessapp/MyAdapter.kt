package com.example.fitnessapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var joggingArticleArrayList :ArrayList<JoggingArticle> , var context: Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var myListener:OnItemClickeListener

    interface OnItemClickeListener{
        fun onItemclick(position: Int)
    }

    fun setItemClickListener(listener: OnItemClickeListener){
        myListener = listener
    }


    class MyViewHolder(itemView: View ,listener: OnItemClickeListener): RecyclerView.ViewHolder(itemView){
      val himage = itemView.findViewById<ShapeableImageView>(R.id.articleImage)
        val heading = itemView.findViewById<TextView>(R.id.headingtTitle)

        init {
            itemView.setOnClickListener {
                listener.onItemclick(adapterPosition)
            }
        }

    }
  // to reate new view instacne
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachrowproduct ,parent , false)
      return  MyViewHolder(itemView ,myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentitem = joggingArticleArrayList[position]
        holder.heading.text = currentitem.ArticleHeading
        holder.himage.setImageResource(currentitem.ArticleImage)

    }
 // how many item present in array list
    override fun getItemCount(): Int {
        return joggingArticleArrayList.size
    }

}