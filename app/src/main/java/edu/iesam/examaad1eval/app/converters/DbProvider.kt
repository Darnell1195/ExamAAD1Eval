package edu.iesam.examaad1eval.app.converters

import android.content.Context
import androidx.room.Room
import edu.iesam.examaad1eval.app.DataBaseExamen

object DbProvider {
    fun provideDb(context: Context): DataBaseExamen = Room.databaseBuilder(
        context,
        DataBaseExamen::class.java,
        "examenDb-db"
    ).fallbackToDestructiveMigration().build()
}