package com.example.lemonadeapp.lemonade_ready.presentation

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.lemonade_ready.data.LemonadeReadyRepository

class LemonadeReadyViewModel(
    private val repository: LemonadeReadyRepository,
) : ViewModel() {

    fun saveLastScreen() {
        repository.saveLastScreen()
    }
}

