package com.example.lemonadeapp.squeezing.data

import com.example.lemonadeapp.core.data.IntCache
import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.load.data.CacheDataSource
import com.example.lemonadeapp.squeezing.presentation.SqueezingScreen

interface SqueezingRepository {

    fun increment()

    fun isMax(): Boolean

    fun reset()

    fun saveLastScreen()

    fun requiredClicks(): Int

    class Base(
        private val counterOfClicks: IntCache,
        private val lastScreen: StringCache,
        private val cacheDataSource: CacheDataSource,
    ) : SqueezingRepository {

        override fun increment() {
            val current = counterOfClicks.read()
            val new = current + 1
            counterOfClicks.save(new)
        }

        override fun isMax(): Boolean {
            return counterOfClicks.read() == requiredClicks()
        }

        override fun reset() {
            counterOfClicks.save(0)
        }

        override fun saveLastScreen() {
            SqueezingScreen::class.java.canonicalName?.let { lastScreen.save(it) }
        }

        override fun requiredClicks(): Int = cacheDataSource.read()
    }
}
