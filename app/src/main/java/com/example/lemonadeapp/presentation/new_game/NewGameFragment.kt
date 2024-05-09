package com.example.lemonadeapp.presentation.new_game

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.squeezing.SqueezingFragment

class NewGameFragment : AbstractFragment(
    imageResId = R.drawable.ic_tree,
    buttonTextResId = R.string.select_lemon,
    hintTextResId = R.string.hint_select_lemon,
) {

    override fun nextFragment(): Fragment = SqueezingFragment()
}
