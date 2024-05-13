package com.example.lemonadeapp.presentation.finish_game

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.presentation.main.Screen

object FinishGameScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return FinishGameFragment()
    }
}