package com.example.lemonadeapp.new_game.presentation

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.new_game.data.NewGameRepository

class NewGameViewModel(
    private val repository: NewGameRepository,
) : ViewModel() {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

