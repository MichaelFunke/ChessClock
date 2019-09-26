package ru.mapublish.chessclock.screens

import android.os.CountDownTimer
import android.os.Handler
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ru.mapublish.chessclock.utils.Actions.ONE_SECOND
import ru.mapublish.chessclock.utils.GameTimer

class GameViewModel(private val gameTimer: GameTimer) : ViewModel() {

    private val delay: Long
    private val increment: Long

    private val _upperTime = MutableLiveData<Long>()
    val upperTime: LiveData<Long>
        get() = _upperTime

    private val _lowerTime = MutableLiveData<Long>()
    val lowerTime: LiveData<Long>
        get() = _lowerTime

    val upperMoves = MutableLiveData<Int>()
    val lowerMoves = MutableLiveData<Int>()

    val upperTimeString = Transformations.map(upperTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    val lowerTimeString = Transformations.map(lowerTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    private val upperTimer: CountDownTimer
    private val lowerTimer: CountDownTimer

    init {
        //other stages added when the time or moves elapsed
        _upperTime.value = gameTimer.timeStageOne
        _lowerTime.value = gameTimer.timeStageOne

        upperMoves.value = gameTimer.movesStageOne
        lowerMoves.value = gameTimer.movesStageOne

        delay = gameTimer.delay
        increment = gameTimer.increment


        upperTimer = object : CountDownTimer(upperTime.value!!.toLong(), ONE_SECOND) {
            override fun onFinish() {

            }

            override fun onTick(millisUntilFinished: Long) {
                _upperTime.value = _upperTime.value!!.toLong() / ONE_SECOND
            }
        }


        lowerTimer = object : CountDownTimer(upperTime.value!!.toLong(), ONE_SECOND) {
            override fun onFinish() {

            }

            override fun onTick(millisUntilFinished: Long) {
                _lowerTime.value = _upperTime.value!!.toLong() / ONE_SECOND
            }
        }
    }

    fun upperTimerPressed() {
        //if delay compensation > 0
        Handler().postDelayed({
            lowerTimer.start()
        }, delay)
    }

    fun lowerTimerPressed() {
        //if delay compensation > 0
        Handler().postDelayed({
            upperTimer.start()
        }, delay)
    }

}