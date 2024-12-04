package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<Player> {
        val listType = object : TypeToken<List<Player>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Player>): String = gson.toJson(list)
}