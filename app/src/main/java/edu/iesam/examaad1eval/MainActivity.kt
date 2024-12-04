package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.iesam.examaad1eval.app.converters.DataBaseProvider
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.DbEx2LocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    private fun executeExercise2() {
        lifecycleScope.launch {
            val ex2DataRepository = createEx2DataRepository()
            val games = withContext(Dispatchers.IO) { ex2DataRepository.getAllGames() }
            withContext(Dispatchers.IO) { ex2DataRepository.saveAllGames(games) }

            val players = withContext(Dispatchers.IO) { ex2DataRepository.getAllPlayers() }
            withContext(Dispatchers.IO) { ex2DataRepository.saveAllPlayers(players) }
        }
    }

    private fun createEx2DataRepository(): Ex2DataRepository {
        val db = DataBaseProvider.provideDb(this)
        val localDataSource = DbEx2LocalDataSource(db.gameDao(), db.playerDao())
        val remoteDataSource = MockEx2RemoteDataSource()
        return Ex2DataRepository(remoteDataSource, localDataSource)
    }
}