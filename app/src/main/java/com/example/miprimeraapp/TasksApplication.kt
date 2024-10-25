package com.example.miprimeraapp

import android.app.Application

/**
 * Clase personalizada para la aplicación que extiende de Application.
 * Se utiliza para inicializar objetos que deben tener un ciclo de vida igual al de la aplicación,
 * como las preferencias compartidas.
 */
class TasksApplication : Application() {

    companion object {
        // Variable estática que permite acceder a las preferencias compartidas desde cualquier parte de la aplicación
        lateinit var prefs: Preferences
    }

    /**
     * Método que se llama cuando la aplicación es creada.
     * Se utiliza para inicializar las preferencias compartidas al inicio de la aplicación.
     */
    override fun onCreate() {
        super.onCreate() // Llama al método onCreate de la superclase
        prefs = Preferences(baseContext) // Inicializa el objeto Preferences
    }
}
