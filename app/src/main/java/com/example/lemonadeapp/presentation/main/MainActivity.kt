package com.example.lemonadeapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.finish_game.FinishGameNavigation
import com.example.lemonadeapp.presentation.finish_game.FinishGameScreen
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyNavigation
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyScreen
import com.example.lemonadeapp.presentation.new_game.NewGameNavigation
import com.example.lemonadeapp.presentation.new_game.NewGameScreen
import com.example.lemonadeapp.presentation.squeezing.SqueezingNavigation
import com.example.lemonadeapp.presentation.squeezing.SqueezingScreen

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as LemonadeApp).mainViewModel

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)
    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }
}

interface Navigation : NewGameNavigation,
    SqueezingNavigation,
    LemonadeReadyNavigation,
    FinishGameNavigation {

    fun navigate(screen: Screen)

    override fun navigateFromNewGame() {
        navigate(SqueezingScreen)
    }

    override fun navigateFromSqueezing() {
        navigate(LemonadeReadyScreen)
    }

    override fun navigateFromLemonadeReady() {
        navigate(FinishGameScreen)
    }

    override fun navigateFromFinishGame() {
        navigate(NewGameScreen)
    }
}

interface Screen {

    fun show(containerId: Int, fragmentManager: FragmentManager)

    object Empty : Screen {

        override fun show(containerId: Int, fragmentManager: FragmentManager) = Unit
    }

    abstract class Replace : Screen {

        abstract fun fragment(): Fragment

        override fun show(containerId: Int, fragmentManager: FragmentManager) {
            fragmentManager.beginTransaction()
                .replace(R.id.container, fragment())
                .commit()
        }
    }
}