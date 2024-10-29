package com.example.miprimeraapp

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

/**
 * Clase Preferences para gestionar el almacenamiento de la lista de tareas en las preferencias compartidas.
 * Permite guardar y recuperar la lista de tareas de manera persistente, manteniendo el orden de las mismas.
 *
 * @param context Contexto necesario para obtener el acceso a SharedPreferences.
 */
class Preferences(context: Context) {

    companion object {
        const val PREFS_NAME = "myDatabase" // Nombre del archivo de SharedPreferences
        const val TASKS = "tasks_value" // Clave para almacenar la lista de tareas
    }

    // Objeto SharedPreferences para acceder al almacenamiento
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    /**
     * Guarda la lista de tareas en formato JSON en SharedPreferences.
     * Utiliza un JSONArray para preservar el orden de las tareas en la lista.
     *
     * @param tasks Lista de tareas a guardar.
     */
    fun saveTasks(tasks: List<String>) {
        val jsonArray = JSONArray(tasks) // Convierte la lista de tareas en un JSONArray
        prefs.edit().putString(TASKS, jsonArray.toString()).apply() // Guarda el JSONArray como una cadena de texto en SharedPreferences
    }

    /**
     * Recupera la lista de tareas almacenada en SharedPreferences.
     * Convierte el JSON almacenado en una lista mutable de Strings y la retorna.
     * Si no existen tareas guardadas, devuelve una lista vacía.
     *
     * @return MutableList de tareas recuperadas.
     */
    fun getTasks(): MutableList<String> {
        val tasksJson = prefs.getString(TASKS, "[]") // Obtiene la cadena JSON almacenada o un arreglo vacío si no hay datos
        val jsonArray = JSONArray(tasksJson) // Convierte la cadena JSON en un JSONArray
        val tasks = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            tasks.add(jsonArray.getString(i)) // Añade cada elemento del JSONArray a la lista de tareas
        }
        return tasks // Devuelve la lista de tareas en formato mutable
    }
}
