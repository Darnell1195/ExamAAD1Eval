package edu.iesam.examaad1eval.features.ex2.domain

import edu.iesam.examaad1eval.features.ex2.data.db.Game
import edu.iesam.examaad1eval.features.ex2.data.db.GameWithPlayers

interface GameRepository {
    suspend fun insertGame(game: Game)
    suspend fun getAllGames(): List<GameWithPlayers>
}