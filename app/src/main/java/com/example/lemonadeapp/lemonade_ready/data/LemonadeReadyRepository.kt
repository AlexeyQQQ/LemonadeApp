package com.example.lemonadeapp.lemonade_ready.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.lemonade_ready.presentation.LemonadeReadyScreen

interface LemonadeReadyRepository {

    fun saveLastScreen()

    class Base(
        private val lastScreen: StringCache,
    ) : LemonadeReadyRepository {

        override fun saveLastScreen() {
            LemonadeReadyScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }
    }
}