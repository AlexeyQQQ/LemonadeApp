package com.example.lemonadeapp.presentation.finish_game

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.new_game.NewGameFragment

class FinishGameFragment : AbstractFragment(
    imageResId = R.drawable.ic_glass,
    buttonTextResId = R.string.start_again,
    hintResId = R.string.hint_start_again,
) {

    override fun nextFragment(): Fragment = NewGameFragment()

    override fun navigation(activity: FragmentActivity) {
        (activity as FinishGameNavigation).navigateFromFinishGame()
    }

    override fun saveLastScreen(activity: FragmentActivity) {
        val viewModel = (activity.application as LemonadeApp).finishGameViewModel
        viewModel.saveLastScreen()
    }
}

interface FinishGameNavigation {
    fun navigateFromFinishGame()
}