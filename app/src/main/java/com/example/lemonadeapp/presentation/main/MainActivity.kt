package com.example.lemonadeapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.ManageViewModels
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.finish_game.FinishGameNavigation
import com.example.lemonadeapp.presentation.finish_game.FinishGameScreen
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyNavigation
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyScreen
import com.example.lemonadeapp.presentation.new_game.NewGameNavigation
import com.example.lemonadeapp.presentation.new_game.NewGameScreen
import com.example.lemonadeapp.presentation.squeezing.SqueezingNavigation
import com.example.lemonadeapp.presentation.squeezing.SqueezingScreen

class MainActivity : AppCompatActivity(), Navigation, ManageViewModels {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = viewModel(MainViewModel::class.java)

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)
    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }

    override fun clear(clazz: Class<out ViewModel>) {
        (application as ManageViewModels).clear(clazz)
    }

    override fun <T : ViewModel> viewModel(clazz: Class<T>): T {
        return (application as ManageViewModels).viewModel(clazz)
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