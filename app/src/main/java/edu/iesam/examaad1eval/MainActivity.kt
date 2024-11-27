package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.features.ex2.data.AppDatabase
import edu.iesam.examaad1eval.features.ex2.data.db.Game
import edu.iesam.examaad1eval.features.ex2.data.db.Player
import edu.iesam.examaad1eval.features.ex2.domain.GameRepositoryImpl
import edu.iesam.examaad1eval.features.ex2.domain.PlayerRepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var gameRepository: GameRepositoryImpl
    private lateinit var playerRepository: PlayerRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "AppDatabase"
        ).build()

        gameRepository = GameRepositoryImpl(db.gameDao())
        playerRepository = PlayerRepositoryImpl(db.playerDao())

        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        // Implementación del ejercicio 1
    }

    private fun executeExercise2() {
        GlobalScope.launch {
            // Ejemplo de inserción de datos
            val game = Game("1", "LOL")
            gameRepository.insertGame(game)

            val player = Player("1", "Juan", "1")
            playerRepository.insertPlayer(player)
        }
    }
}