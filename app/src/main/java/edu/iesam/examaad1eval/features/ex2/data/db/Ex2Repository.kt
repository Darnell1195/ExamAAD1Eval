package edu.iesam.examaad1eval.features.ex2.data.db

interface Ex2Repository {
    suspend fun getGames(): List<Game>
}