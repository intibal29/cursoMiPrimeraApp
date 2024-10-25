package com.example.miprimeraapp

import android.view.View;
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// recive una vista
 class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view){
   private val tvTask:TextView=view.findViewById(R.id.textView)

 fun render(task:String){
   tvTask.text=task
 }
    //
}//