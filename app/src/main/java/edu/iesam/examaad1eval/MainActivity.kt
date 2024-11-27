// MainActivity.kt
package edu.iesam.examaad1eval

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.data.local.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.data.local.SharedPreferences
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var ex1Repository: Ex1Repository
    private lateinit var usersTextView: TextView
    private lateinit var productsTextView: TextView
    private lateinit var serviceTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersTextView = findViewById(R.id.usersTextView)
        productsTextView = findViewById(R.id.productsTextView)
        serviceTextView = findViewById(R.id.servicesTextView)


        val sharedPreferences = SharedPreferences(this)
        val mockEx1RemoteDataSource = MockEx1RemoteDataSource()
        ex1Repository = Ex1Repository(sharedPreferences, mockEx1RemoteDataSource)

        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        val users = ex1Repository.getUsers()
        val usersText = users.joinToString(separator = "\n") { user ->
            "User: ${user.name} ${user.surname}"
        }
        usersTextView.text = usersText


        val products = ex1Repository.getItems()
        val productsText = products.joinToString(separator = "\n") { item ->
            "Product: ${item.name} - Price: ${item.price}"
        }
        productsTextView.text = productsText


        val service = ex1Repository.getServices()
        val servicesText = service.joinToString(separator = "\n") { service ->
            "Service: ${service.name}"
        }

        serviceTextView.text = servicesText


    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        // Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            // llamar a Room
        }
    }
}