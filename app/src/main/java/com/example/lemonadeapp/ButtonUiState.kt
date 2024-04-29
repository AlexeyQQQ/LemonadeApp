package com.example.lemonadeapp

import android.widget.Button
import androidx.annotation.StringRes

interface ButtonUiState {

    fun update(button: Button)

    abstract class Abstract(
        private val isEnabled: Boolean = true,
        @StringRes private val resId: Int,
    ) : ButtonUiState {

        override fun update(button: Button) {
            button.isEnabled = isEnabled
            button.setText(resId)
        }
    }

    object NewGame : Abstract(resId = R.string.select_lemon)

    object StartSqueezing : Abstract(isEnabled = false, resId = R.string.squeeze_lemon)

    object FinishSqueezing : Abstract(resId = R.string.squeeze_lemon)

    object LemonadeIsReady : Abstract(resId = R.string.drink)

    object FinishGame : Abstract(resId = R.string.start_again)

}
