// app/src/main/java/edu/iesam/examaad1eval/features/ex2/data/GameDao.kt
package edu.iesam.examaad1eval.features.ex2.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: Game)

    @Transaction
    @Query("SELECT * FROM Game")
    suspend fun getAllGames(): List<GameWithPlayers>
}