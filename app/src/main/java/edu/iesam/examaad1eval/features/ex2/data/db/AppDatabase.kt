// app/src/main/java/edu/iesam/examaad1eval/features/ex2/data/AppDatabase.kt
package edu.iesam.examaad1eval.features.ex2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.features.ex2.data.db.Game
import edu.iesam.examaad1eval.features.ex2.data.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.db.Player
import edu.iesam.examaad1eval.features.ex2.data.db.PlayerDao

@Database(entities = [Game::class, Player::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao
}