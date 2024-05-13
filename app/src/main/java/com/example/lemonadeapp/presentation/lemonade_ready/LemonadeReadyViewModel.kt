package com.example.lemonadeapp.presentation.lemonade_ready

import com.example.lemonadeapp.data.StringCache

class LemonadeReadyViewModel(
    private val repository: LemonadeReadyRepository,
) {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

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