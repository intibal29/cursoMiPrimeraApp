package com.example.miprimeraapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para gestionar la visualización de la lista de tareas en un RecyclerView.
 * Proporciona la funcionalidad para enlazar las tareas a las vistas del RecyclerView.
 *
 * @param tasks Lista de tareas a mostrar.
 * @param onItemImge Función que se ejecuta cuando se interactúa con el icono de cada tarea.
 */
class TaskAdapter(val tasks: List<String>, val onItemImge: (Int) -> Unit) : RecyclerView.Adapter<TaskViewHolder>() {

    /**
     * Crea un nuevo ViewHolder para un elemento de la lista de tareas.
     * Este método es llamado por el RecyclerView cuando necesita un nuevo ViewHolder.
     *
     * @param parent El ViewGroup al que se adjuntará el nuevo ViewHolder.
     * @param viewType Tipo de vista del nuevo ViewHolder.
     * @return Un nuevo TaskViewHolder que contiene la vista del elemento.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context) // Obtiene un LayoutInflater para inflar la vista
        return TaskViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false)) // Crea y devuelve un nuevo TaskViewHolder
    }

    /**
     * Asocia los datos del elemento en la posición especificada con el ViewHolder.
     * Este método es llamado por el RecyclerView para mostrar los datos en el ViewHolder.
     *
     * @param holder El ViewHolder al que se le asociarán los datos.
     * @param position La posición del elemento en la lista.
     */
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position], onItemImge) // Llama al método render del ViewHolder para mostrar la tarea
    }

    /**
     * Retorna la cantidad total de elementos en la lista de tareas.
     * Este método es llamado por el RecyclerView para determinar el tamaño de la lista.
     *
     * @return Número total de tareas en la lista.
     */
    override fun getItemCount() = tasks.size // Retorna el tamaño de la lista de tareas
}
