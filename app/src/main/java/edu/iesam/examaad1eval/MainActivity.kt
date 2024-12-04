package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.app.converters.DbProvider
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.DbEx2LocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        // Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        GlobalScope.launch {
            val db = DbEx2LocalDataSource(
                DbProvider.provideDb(this@MainActivity).gameDao(),
                DbProvider.provideDb(this@MainActivity).playerDao()
            )
            val ex2DataRepository = Ex2DataRepository(MockEx2RemoteDataSource(), db)
            val games = ex2DataRepository.getAllGames()
            ex2DataRepository.saveAllGames(games)

            val players = ex2DataRepository.getAllPlayers()
            ex2DataRepository.saveAllPlayers(players)
        }
    }
}