package com.example.lemonadeapp.presentation.finish_game

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.data.StringCache
import com.example.lemonadeapp.presentation.new_game.NewGameScreen

class FinishGameViewModel(
    private val repository: FinishGameRepository,
) : ViewModel() {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

interface FinishGameRepository {

    fun saveLastScreen()

    class Base(
        private val lastScreen: StringCache,
    ) : FinishGameRepository {

        override fun saveLastScreen() {
            NewGameScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }
    }
}