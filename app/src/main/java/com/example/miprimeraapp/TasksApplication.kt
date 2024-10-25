package com.example.miprimeraapp

import android.app.Application

class TasksApplication :Application(){
    companion object{
        lateinit var prefs:Preferences
    }
      override fun onCreate(){
          super.onCreate()
           prefs = Preferences (baseContext)
      }
}