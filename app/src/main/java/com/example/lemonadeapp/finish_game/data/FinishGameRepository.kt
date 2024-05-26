package com.example.lemonadeapp.finish_game.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.finish_game.presentation.FinishGameScreen

interface FinishGameRepository {

    fun saveLastScreen()

    class Base(
        private val lastScreen: StringCache,
    ) : FinishGameRepository {

        override fun saveLastScreen() {
            FinishGameScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }
    }
}