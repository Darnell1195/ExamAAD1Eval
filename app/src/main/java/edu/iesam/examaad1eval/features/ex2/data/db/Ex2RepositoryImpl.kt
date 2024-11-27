package edu.iesam.examaad1eval.features.ex2.data.db

class Ex2RepositoryImpl(private val gameDao: GameDao) : Ex2Repository {
    override suspend fun getGames(): List<Game> {
        return gameDao.getAllGames().map { gameWithPlayers ->
            Game(
                id = gameWithPlayers.id,
                name = gameWithPlayers.name,

                )
        }
    }
}