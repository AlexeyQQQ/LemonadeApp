package com.example.lemonadeapp.presentation.new_game

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.presentation.main.Screen

object NewGameScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return NewGameFragment()
    }
}