package com.example.lemonadeapp.squeezing.presentation

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.main.presentation.Screen

object SqueezingScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return SqueezingFragment()
    }
}