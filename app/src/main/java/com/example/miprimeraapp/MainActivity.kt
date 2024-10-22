package com.example.miprimeraapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    //si se quiere iniciar una variable mas tarde es con lateinit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        test("hola")
    }
    //funcion con parametro de entrada y que devuelve un string
    fun test(saludo:String="adios" ): String{
        val nombre:String="juan" //definimos tipo
        val example=8.1; // sin definir tipo
       return "hola$nombre"// esto es igual que hola+nombre
        //val list:List<String> = listof("1","2") // listas mutables y no mutables
       // val list2:MutableList<String> = mutaleListOf("1","2") // listas mutables
          //  list2.add("hola")
    }
    fun test2(saludo:String="adios" ): String = "hola$nombre" // nesta funcion hace lo mismo que la de arriba
        val nombre:String="juan" //definimos tipo

}