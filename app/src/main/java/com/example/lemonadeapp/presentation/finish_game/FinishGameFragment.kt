package com.example.lemonadeapp.presentation.finish_game

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.ManageViewModels
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
        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(FinishGameViewModel::class.java)

        viewModel.saveLastScreen()
        manageViewModels.clear(FinishGameViewModel::class.java)
    }
}

interface FinishGameNavigation {
    fun navigateFromFinishGame()
}