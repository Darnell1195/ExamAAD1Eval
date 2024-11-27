package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.data.local.SharedPreferences
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1Repository(
    val sharedPreferences: SharedPreferences,
    val mockEx1RemoteDataSource: MockEx1RemoteDataSource
) {
    fun getUsers(): List<User> {
        return sharedPreferences.getUsers().ifEmpty {
            mockEx1RemoteDataSource.getUsers().also { sharedPreferences.saveUsers(it) }
        }
    }

    fun getItems(): List<Item>{
        return sharedPreferences.getItem().ifEmpty {
            mockEx1RemoteDataSource.getItems().also { sharedPreferences.saveItems(it) }
        }
    }

    fun getServices(): List<Services> {
        return sharedPreferences.getServices().ifEmpty {
            mockEx1RemoteDataSource.getServices().also { sharedPreferences.saveServices(it) }
        }
    }

}

