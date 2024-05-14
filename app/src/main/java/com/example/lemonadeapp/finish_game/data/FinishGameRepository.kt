package com.example.lemonadeapp.finish_game.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.new_game.presentation.NewGameScreen

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