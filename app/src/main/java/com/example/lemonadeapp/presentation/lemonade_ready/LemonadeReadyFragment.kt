package com.example.lemonadeapp.presentation.lemonade_ready

import androidx.fragment.app.Fragment
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.AbstractFragment
import com.example.lemonadeapp.presentation.finish_game.FinishGameFragment


class LemonadeReadyFragment : AbstractFragment(
    imageResId = R.drawable.ic_lemonade,
    buttonTextResId = R.string.drink,
    hintTextResId = R.string.hint_drink,
) {

    override fun nextFragment(): Fragment = FinishGameFragment()
}