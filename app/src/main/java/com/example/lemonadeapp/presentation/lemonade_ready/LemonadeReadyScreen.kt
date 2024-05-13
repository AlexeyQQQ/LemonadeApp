package com.example.lemonadeapp.presentation.lemonade_ready

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.presentation.main.Screen

object LemonadeReadyScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return LemonadeReadyFragment()
    }
}