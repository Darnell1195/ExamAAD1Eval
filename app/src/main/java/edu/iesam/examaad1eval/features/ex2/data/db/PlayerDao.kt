package edu.iesam.examaad1eval.features.ex2.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayerDao {
    @Insert
    suspend fun insertPlayer(player: Player)

    @Query("SELECT * FROM Player WHERE gameId = :gameId")
    suspend fun getPlayersForGame(gameId: String): List<Player>
}