package ru.mapublish.chessclock.utils

data class GameTimer(
    val timeStageOne: Int = 0,
    val movesStageOne: Int = 0,
    val timeStageTwo: Int = 0,
    val movesStageTwo: Int = 0,
    val timeStageThree: Int = 0,
    val movesStageThree: Int = 0,
    val delay: Int = 0,
    val increment: Int = 0
)