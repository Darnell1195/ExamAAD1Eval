package edu.iesam.examaad1eval.features.ex2.data.remote

import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

class MockEx2RemoteDataSource {

    fun getGames(): List<Game> {
        return listOf(
            Game("1", "world of warcraft", getPlayers()),
            Game("2", "mario kart 8", getPlayers()),
            Game("3", "mortal combat 1", getPlayers())
        )
    }

    fun getPlayers(): List<Player> {
        return listOf(
            Player("1", "Darnell"),
            Player("2", "Darlin"),
            Player("3", "Darmin")
        ).shuffled()
    }
}