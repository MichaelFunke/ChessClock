package ru.mapublish.chessclock.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.mapublish.chessclock.R
import ru.mapublish.chessclock.databinding.FragmentGameBinding
import ru.mapublish.chessclock.utils.GameTimer

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        viewModelFactory = GameViewModelFactory(GameTimer(10000))
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GameViewModel::class.java)

        return binding.root
    }
}