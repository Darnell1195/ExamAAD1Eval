package edu.iesam.examaad1eval.features.ex2.domain

import edu.iesam.examaad1eval.features.ex2.data.db.Player
import edu.iesam.examaad1eval.features.ex2.data.db.PlayerDao

class PlayerRepositoryImpl(private val playerDao: PlayerDao) : PlayerRepository {
    override suspend fun insertPlayer(player: Player) {
        playerDao.insertPlayer(player)
    }

    override suspend fun getPlayersForGame(gameId: String): List<Player> {
        return playerDao.getPlayersForGame(gameId)
    }
}