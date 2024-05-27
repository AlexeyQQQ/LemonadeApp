package com.example.lemonadeapp.load.presentation

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.main.presentation.Screen

object LoadScreen : Screen.Replace() {

    override fun fragment(): Fragment = LoadFragment()
}
