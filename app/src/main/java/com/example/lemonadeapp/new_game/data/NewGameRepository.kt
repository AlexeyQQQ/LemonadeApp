package com.example.lemonadeapp.new_game.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.new_game.presentation.NewGameScreen

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