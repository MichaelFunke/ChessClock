package ru.mapublish.chessclock.utils

data class GameTimer(
    val timeStageOne: Long = 0,
    val movesStageOne: Int = 0,
    val timeStageTwo: Long = 0,
    val movesStageTwo: Int = 0,
    val timeStageThree: Long = 0,
    val delay: Long = 0,
    val increment: Long = 0
)