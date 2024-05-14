package com.example.lemonadeapp.lemonade_ready.presentation

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.main.presentation.Screen

object LemonadeReadyScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return LemonadeReadyFragment()
    }
}