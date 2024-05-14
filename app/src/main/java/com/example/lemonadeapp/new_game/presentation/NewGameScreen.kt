package com.example.lemonadeapp.new_game.presentation

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.main.presentation.Screen

object NewGameScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return NewGameFragment()
    }
}