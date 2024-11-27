package edu.iesam.examaad1eval.features.ex2.domain

import edu.iesam.examaad1eval.features.ex2.data.db.Game
import edu.iesam.examaad1eval.features.ex2.data.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.db.GameWithPlayers

class GameRepositoryImpl(private val gameDao: GameDao) : GameRepository {
    override suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    override suspend fun getAllGames(): List<GameWithPlayers> {
        return gameDao.getAllGames()
    }
}