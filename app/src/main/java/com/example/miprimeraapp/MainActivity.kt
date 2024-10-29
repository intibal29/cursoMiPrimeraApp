package com.example.miprimeraapp

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraapp.TasksApplication.Companion.prefs

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    // variable button
    lateinit var btnbutton: Button
    lateinit var etText: EditText
    lateinit var rvText: RecyclerView
    var tasks = mutableListOf<String>() // Lista mutable que guarda las tareas

    lateinit var adapter: TaskAdapter

    /**
     * Método que se ejecuta al crear la actividad. Configura la interfaz y llama al método para inicializar la UI.
     * @param savedInstanceState contiene el estado previamente guardado de la actividad, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Activa la funcionalidad de "Edge to Edge" para mejor visualización
        setContentView(R.layout.activity_main)
        iniUi() // Llama al método que inicializa la interfaz
    }

    /**
     * Método de inicialización de la interfaz de usuario.
     * Configura las vistas, listeners y RecyclerView para la lista de tareas.
     */
    private fun iniUi() {
        initView() // instanciar los valores de las vistas (botón, campo de texto, etc.)
        initListeners() // establece los listeners para las interacciones de usuario
        initRecycleview() // configura el RecyclerView para mostrar las tareas
    }

    /**
     * Configura el RecyclerView para la visualización de la lista de tareas.
     * Carga las tareas almacenadas y establece el layout y el adaptador.
     * Además, añade funcionalidad de deslizar para eliminar una tarea.
     */
    private fun initRecycleview() {
        tasks = prefs.getTasks() // Cargar las tareas guardadas
        rvText.layoutManager = LinearLayoutManager(this) // Configurar el layout en modo lista
        adapter = TaskAdapter(tasks) { deleteTasks(it) } // Configura el adaptador y define acción al eliminar
        rvText.adapter = adapter

        // Configuración de Swipe to Delete para eliminar tareas al deslizar
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                deleteTasks(viewHolder.adapterPosition) // Llama al método para eliminar la tarea en la posición desliz
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvText) // Asigna el helper al RecyclerView
    }

    /**
     * Elimina una tarea de la lista en la posición dada y actualiza la vista.
     * @param position posición de la tarea en la lista.
     */
    fun deleteTasks(position: Int) {
        tasks.removeAt(position) // Elimina la tarea de la lista
        adapter.notifyDataSetChanged() // Notifica al adaptador para actualizar la vista
        prefs.saveTasks(tasks) // Guarda la lista actualizada en las preferencias
    }

    /**
     * Configura el listener para el botón de agregar tarea.
     * Al hacer clic en el botón, llama al método para añadir la tarea.
     */
    private fun initListeners() {
        btnbutton.setOnClickListener {
            addTAsk()
        }
    }

    /**
     * Agrega una nueva tarea a la lista de tareas y actualiza la vista.
     * Limpia el campo de texto después de añadir la tarea.
     */
    private fun addTAsk() {
        val taskToAdd: String = etText.text.toString()
        tasks.add(taskToAdd) // añadir tareas
        prefs.saveTasks(tasks) // sustituir la lista de tareas con la nueva en las preferencias
        adapter.notifyDataSetChanged() // Actualiza el adaptador para reflejar el cambio
        etText.setText("") // limpia el campo de texto
    }

    /**
     * Inicializa las vistas principales de la actividad, como el botón, el campo de texto y el RecyclerView.
     * Configura las vistas para ser usadas en otros métodos de la actividad.
     */
    private fun initView() {
        btnbutton = findViewById(R.id.button) // esto hace que te busque la vista por id
        etText = findViewById(R.id.etTarea)
        rvText = findViewById(R.id.rvT)
    }
}
