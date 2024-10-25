package com.example.miprimeraapp

import android.view.View;
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// recive una vista
 class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view){
   private val tvTask:TextView=view.findViewById(R.id.textView)
   private val imageView:ImageView=view.findViewById(R.id.imageView)

 fun render(task:String,onImageView: (Int)->Unit){
   tvTask.text=task
   imageView.setOnClickListener{onImageView(adapterPosition)}//te devuelve la posicion
 }

}