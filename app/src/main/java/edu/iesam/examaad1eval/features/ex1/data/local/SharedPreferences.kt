// SharedPreferences.kt
package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class SharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("db-Exam", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getUsers(): List<User> {
        val json = sharedPreferences.getString("users", null)
        return if (json != null) {
            gson.fromJson(json, Array<User>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun saveUsers(users: List<User>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(users)
        editor.putString("users", json)
        editor.apply()

        users.forEach { user ->
            println("User: ${user.name} ${user.surname}")
        }
    }

    fun getItem(): List<Item> {
        val json = sharedPreferences.getString("items", null)
        return if (json != null) {
            gson.fromJson(json, Array<Item>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun saveItems(items: List<Item>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(items)
        editor.putString("items", json)
        editor.apply()

        items.forEach { item ->
            println("Item: ${item.name} - Price: ${item.price}")
        }
    }

    fun getServices(): List<Services> {
        val json = sharedPreferences.getString("services", null)
        return if (json != null) {
            gson.fromJson(json, Array<Services>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun saveServices(services: List<Services>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(services)
        editor.putString("services", json)
        editor.apply()

        services.forEach { service ->
            println("Service: ${service.name}")
        }
    }
}