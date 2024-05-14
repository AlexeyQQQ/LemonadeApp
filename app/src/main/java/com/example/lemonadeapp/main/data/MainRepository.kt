package com.example.lemonadeapp.main.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.main.presentation.Screen

interface MainRepository {

    fun lastSavedScreen(): Screen

    class Base(
        private val lastScreen: StringCache,
    ) : MainRepository {

        override fun lastSavedScreen(): Screen {
            val className = lastScreen.read()
            return Class.forName(className).getDeclaredConstructor().newInstance() as Screen
        }
    }
}