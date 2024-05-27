package com.example.lemonadeapp.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.R
import com.example.lemonadeapp.core.di.ManageViewModels
import com.example.lemonadeapp.finish_game.presentation.FinishGameNavigation
import com.example.lemonadeapp.finish_game.presentation.FinishGameScreen
import com.example.lemonadeapp.lemonade_ready.presentation.LemonadeReadyNavigation
import com.example.lemonadeapp.lemonade_ready.presentation.LemonadeReadyScreen
import com.example.lemonadeapp.load.presentation.LoadNavigation
import com.example.lemonadeapp.load.presentation.LoadScreen
import com.example.lemonadeapp.new_game.presentation.NewGameNavigation
import com.example.lemonadeapp.new_game.presentation.NewGameScreen
import com.example.lemonadeapp.squeezing.presentation.SqueezingNavigation
import com.example.lemonadeapp.squeezing.presentation.SqueezingScreen

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
    FinishGameNavigation,
    LoadNavigation {

    fun navigate(screen: Screen)

    override fun navigateFromNewGame() {
        navigate(LoadScreen)
    }

    override fun navigateFromLoad() {
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