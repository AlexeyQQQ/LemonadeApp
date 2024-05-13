package com.example.lemonadeapp.presentation.main

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.data.StringCache

class MainViewModel(
    private val repository: MainRepository,
) : ViewModel() {

    fun init(firstRun: Boolean): Screen {
        return if (firstRun)
            repository.lastSavedScreen()
        else
            Screen.Empty
    }
}

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