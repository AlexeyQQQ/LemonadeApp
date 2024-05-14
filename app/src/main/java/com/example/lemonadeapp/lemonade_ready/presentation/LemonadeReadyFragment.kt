package com.example.lemonadeapp.lemonade_ready.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.R
import com.example.lemonadeapp.core.AbstractFragment
import com.example.lemonadeapp.core.di.ManageViewModels
import com.example.lemonadeapp.finish_game.presentation.FinishGameFragment


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
        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(LemonadeReadyViewModel::class.java)

        viewModel.saveLastScreen()
        manageViewModels.clear(LemonadeReadyViewModel::class.java)
    }
}

interface LemonadeReadyNavigation {
    fun navigateFromLemonadeReady()
}