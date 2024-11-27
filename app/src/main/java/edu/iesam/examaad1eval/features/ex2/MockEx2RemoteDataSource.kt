package edu.iesam.examaad1eval.features.ex2

import edu.iesam.examaad1eval.features.ex2.data.db.Game
import edu.iesam.examaad1eval.features.ex2.data.db.Player

class MockEx2RemoteDataSource {

    fun getGames(): List<Game> {
        return listOf(
            Game("1", "Day of Tentacle"),
            Game("2", "Monkey Island"),
            Game("4", "Comandos 1"),
            Game("5", "Comandos 2"),
            Game("6", "Comandos 3"),
            Game("7", "Comandos 4"),
            Game("8", "Comandos 5")
        ).shuffled()
    }

    private fun getPlayers(): List<Player> {
        return listOf(
            Player("1", "Juan", "1"),
            Player("2", "Pepe", "2")
        ).shuffled()
    }
}