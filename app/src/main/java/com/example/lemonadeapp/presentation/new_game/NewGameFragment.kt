package com.example.lemonadeapp.presentation.new_game

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.squeezing.SqueezingFragment

class NewGameFragment : AbstractFragment(
    imageResId = R.drawable.ic_tree,
    buttonTextResId = R.string.select_lemon,
    hintResId = R.string.hint_select_lemon,
) {

    override fun nextFragment(): Fragment = SqueezingFragment()

    override fun navigation(activity: FragmentActivity) {
        (activity as NewGameNavigation).navigateFromNewGame()
    }

    override fun saveLastScreen(activity: FragmentActivity) {
        val viewModel = (activity.application as LemonadeApp).newGameViewModel
        viewModel.saveLastScreen()
    }
}

interface NewGameNavigation {
    fun navigateFromNewGame()
}
