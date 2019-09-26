package ru.mapublish.chessclock.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mapublish.chessclock.utils.GameTimer
import java.lang.IllegalArgumentException

class GrameViewModelFactory(private val gameTimer: GameTimer) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(gameTimer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}