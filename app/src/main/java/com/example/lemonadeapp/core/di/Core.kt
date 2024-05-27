package com.example.lemonadeapp.core.di

import android.content.Context
import com.example.lemonadeapp.R
import com.example.lemonadeapp.core.data.IntCache
import com.example.lemonadeapp.core.data.IntPermanentStorage
import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.core.data.StringPermanentStorage
import com.example.lemonadeapp.new_game.presentation.NewGameScreen

class Core(context: Context) {

    var runUiTest: Boolean = false

    val counterOfClicks: IntCache
    val requiredClicks: IntCache
    val mockCurrentIndex: IntCache
    val lastScreen: StringCache

    init {

        val sharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

        val intPermanentStorage = IntPermanentStorage.Base(sharedPreferences)
        val stringPermanentStorage = StringPermanentStorage.Base(sharedPreferences)

        counterOfClicks = IntCache.Base(intPermanentStorage, COUNTER_KEY, 0)
        requiredClicks = IntCache.Base(intPermanentStorage, REQUIRED_CLICKS_KEY, 10)
        mockCurrentIndex = IntCache.Base(intPermanentStorage, MOCK_CURRENT_INDEX_KEY, 0)
        lastScreen =
            StringCache.Base(
                stringPermanentStorage,
                LAST_SCREEN_KEY,
                NewGameScreen::class.java.canonicalName!!
            )
    }

    companion object {
        private const val COUNTER_KEY = "counter_key"
        private const val REQUIRED_CLICKS_KEY = "required_clicks_key"
        private const val MOCK_CURRENT_INDEX_KEY = "mock_current_index_key"
        private const val LAST_SCREEN_KEY = "last_screen_key"
    }
}