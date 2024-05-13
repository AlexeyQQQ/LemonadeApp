package com.example.lemonadeapp.presentation.lemonade_ready

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.finish_game.FinishGameFragment


class LemonadeReadyFragment : AbstractFragment(
    imageResId = R.drawable.ic_lemonade,
    buttonTextResId = R.string.drink,
    hintResId = R.string.hint_drink,
) {

    override fun nextFragment(): Fragment = FinishGameFragment()

    override fun navigation(activity: FragmentActivity) {
        (activity as LemonadeReadyNavigation).navigateFromLemonadeReady()
    }

    override fun saveLastScreen(activity: FragmentActivity) {
        val viewModel = (activity.application as LemonadeApp).lemonadeReadyViewModel
        viewModel.saveLastScreen()
    }
}

interface LemonadeReadyNavigation {
    fun navigateFromLemonadeReady()
}