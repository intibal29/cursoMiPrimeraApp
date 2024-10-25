package com.example.miprimeraapp

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    lateinit var btnbutton:Button //variable button
    lateinit var etText: EditText 
    lateinit var rvText: RecyclerView
    var tasks = mutableListOf<String>()

    lateinit var adapter:TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       iniUi()

    }

    private fun iniUi() {
        initView()//instanciar los valores
        initListeners()
        initRecycleview()
    }

    private fun initRecycleview() {
        //configurar el recile view
        rvText.layoutManager=LinearLayoutManager(this)
        adapter = TaskAdapter(tasks){deleteTasks(it)}
        rvText.adapter=adapter


    }
fun deleteTasks(position: Int){
    tasks.removeAt(position)
    adapter.notifyDataSetChanged()
}
    //listener
    private fun initListeners() {
       btnbutton.setOnClickListener(){
           addTAsk()
       }
    }

    private fun addTAsk() {
       val taskToAdd:String = etText.text.toString()
        tasks.add(taskToAdd) //añadir tareas
        adapter.notifyDataSetChanged()
        //limpiaar
        etText.setText("")

    }


    private fun initView() {
        btnbutton = findViewById(R.id.button)// esto hace que te busque la vista por id 
        etText = findViewById(R.id.etTarea)
        rvText = findViewById(R.id.rvT)
        rvText = findViewById(R.id.rvT)
    }
}