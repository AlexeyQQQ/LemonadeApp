package com.example.lemonadeapp.finish_game.presentation

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.finish_game.data.FinishGameRepository

class FinishGameViewModel(
    private val repository: FinishGameRepository,
) : ViewModel() {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

