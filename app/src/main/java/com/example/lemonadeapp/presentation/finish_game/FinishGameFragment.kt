package com.example.lemonadeapp.presentation.finish_game

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.new_game.NewGameFragment

class FinishGameFragment : AbstractFragment(
    imageResId = R.drawable.ic_glass,
    buttonTextResId = R.string.start_again,
    hintTextResId = R.string.hint_start_again,
) {

    override fun nextFragment(): Fragment = NewGameFragment()
}