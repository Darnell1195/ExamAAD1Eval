package edu.iesam.examaad1eval.features.ex2.data.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Game(
    @PrimaryKey val id: String,
    val title: String
)

@Entity
data class Player(
    @PrimaryKey val id: String,
    val name: String,
    val gameId: String // Foreign key to Game
)

data class GameWithPlayers(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "id",
        entityColumn = "gameId"
    )
    val players: List<Player>
)