package com.example.lemonadeapp.data

import com.example.lemonadeapp.presentation.squeezing.SqueezingScreen

interface SqueezingRepository {

    fun increment()

    fun isMax(): Boolean

    fun reset()

    fun saveLastScreen()

    class Base(
        private val counterOfClicks: IntCache,
        private val lastScreen: StringCache,
    ) : SqueezingRepository {

        override fun increment() {
            val current = counterOfClicks.read()
            val new = current + 1
            counterOfClicks.save(new)
        }

        override fun isMax(): Boolean {
            return counterOfClicks.read() == 5
        }

        override fun reset() {
            counterOfClicks.save(0)
        }

        override fun saveLastScreen() {
            SqueezingScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }
    }
}
