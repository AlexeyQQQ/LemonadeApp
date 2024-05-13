package com.example.lemonadeapp.presentation.squeezing

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.presentation.main.Screen

object SqueezingScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return SqueezingFragment()
    }
}