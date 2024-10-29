package com.example.miprimeraapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * ViewHolder que representa un ítem en la lista de tareas del RecyclerView.
 * Esta clase es responsable de manejar las vistas de cada tarea y de gestionar la interacción del usuario.
 *
 * @param view La vista inflada que representa un ítem de tarea.
 */
class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Inicializa las vistas específicas del ítem de tarea
    private val tvTask: TextView = view.findViewById(R.id.textView) // Vista de texto que muestra la tarea
    private val imageView: ImageView = view.findViewById(R.id.imageView) // Vista de imagen para la interacción (por ejemplo, eliminar tarea)

    /**
     * Asocia los datos de la tarea con las vistas del ViewHolder.
     * También configura un listener para el ImageView, que permite manejar la interacción del usuario.
     *
     * @param task La tarea que se va a mostrar en la vista.
     * @param onImageView Función que se ejecuta al hacer clic en el ImageView.
     */
    fun render(task: String, onImageView: (Int) -> Unit) {
        tvTask.text = task // Asigna el texto de la tarea al TextView
        imageView.setOnClickListener { onImageView(adapterPosition) } // Configura el listener para manejar el clic en la imagen
    }
}
