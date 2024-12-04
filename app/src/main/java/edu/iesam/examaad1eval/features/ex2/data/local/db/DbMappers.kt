package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

fun GameEntity.toDomain(): Game = Game(id, title, player)

fun Game.toEntity(): GameEntity = GameEntity(id, title, player)

fun PlayerEntity.toDomain(): Player = Player(id, name)

fun Player.toEntity(): PlayerEntity = PlayerEntity(id, name)