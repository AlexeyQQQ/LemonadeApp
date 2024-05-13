package com.example.lemonadeapp.presentation.new_game

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.ManageViewModels
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
        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(NewGameViewModel::class.java)

        viewModel.saveLastScreen()
        manageViewModels.clear(NewGameViewModel::class.java)
    }
}

interface NewGameNavigation {
    fun navigateFromNewGame()
}
