package com.example.lemonadeapp.new_game.presentation

import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.R
import com.example.lemonadeapp.core.AbstractFragment
import com.example.lemonadeapp.core.di.ManageViewModels

class NewGameFragment : AbstractFragment(
    imageResId = R.drawable.ic_tree,
    buttonTextResId = R.string.select_lemon,
    hintResId = R.string.hint_select_lemon,
) {

    override fun navigation(activity: FragmentActivity) {
        (activity as NewGameNavigation).navigateFromNewGame()
    }

    override fun saveLastScreen(activity: FragmentActivity) {
        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(NewGameViewModel::class.java)

        viewModel.saveLastScreen()
        manageViewModels.clear(NewGameViewModel::class.java)
    }
}

interface NewGameNavigation {
    fun navigateFromNewGame()
}