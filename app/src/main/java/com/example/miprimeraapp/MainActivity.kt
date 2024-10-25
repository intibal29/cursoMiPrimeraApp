package com.example.miprimeraapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    lateinit var btnbutton:Button //variable button
    lateinit var etText: EditText 
    lateinit var rvText: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       iniUi()
    }

    private fun iniUi() {
        initView()//instanciar los valores
        initListeners()
    }
    //listener
    private fun initListeners() {
       btnbutton.setOnClickListener(){
           addbutoon()
       }
    }

    private fun addbutoon() {
       val taskToAdd: String = etText.text.toString()
    }


    private fun initView() {
        btnbutton = findViewById(R.id.button)// esto hace que te busque la vista por id 
        etText = findViewById(R.id.etTarea)
        rvText = findViewById(R.id.rvT)
        rvText = findViewById(R.id.rvT)
    }
}