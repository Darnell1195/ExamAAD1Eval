package edu.iesam.examaad1eval.features.ex2.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM Game")
    suspend fun getAllGames(): List<GameWithPlayers>
}