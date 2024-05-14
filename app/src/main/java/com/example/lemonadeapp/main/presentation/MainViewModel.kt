package com.example.lemonadeapp.main.presentation

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.main.data.MainRepository

class MainViewModel(
    private val repository: MainRepository,
) : ViewModel() {

    fun init(firstRun: Boolean): Screen {
        return if (firstRun) repository.lastSavedScreen() else Screen.Empty
    }
}
