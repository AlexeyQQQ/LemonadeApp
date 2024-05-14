package com.example.lemonadeapp.finish_game.presentation

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.main.presentation.Screen

object FinishGameScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return FinishGameFragment()
    }
}