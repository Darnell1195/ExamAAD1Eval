package edu.iesam.examaad1eval.features.ex2.domain

import edu.iesam.examaad1eval.features.ex2.data.db.Player


interface PlayerRepository {
    suspend fun insertPlayer(player: Player)
    suspend fun getPlayersForGame(gameId: String): List<Player>
}