package com.example.lemonadeapp.presentation.new_game

import com.example.lemonadeapp.data.StringCache

class NewGameViewModel(
    private val repository: NewGameRepository,
) {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

interface NewGameRepository {

    fun saveLastScreen()

    class Base(
        private val lastScreen: StringCache,
    ) : NewGameRepository {

        override fun saveLastScreen() {
            NewGameScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }
    }
}