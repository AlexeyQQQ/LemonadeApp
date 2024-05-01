package com.example.lemonadeapp.TextUi

import androidx.annotation.StringRes
import com.example.lemonadeapp.R

interface TextUiState {

    fun update(textView: UpdateTextView)

    abstract class Abstract(
        @StringRes private val resId: Int
    ) : TextUiState {

        override fun update(textView: UpdateTextView) {
            textView.updateText(resId)
        }
    }

    object NewGame : Abstract(R.string.hint_select_lemon)

    object StartSqueezing : Abstract(R.string.hint_start_squeezing)

    object FinishSqueezing : Abstract(R.string.hint_start_squeezing)

    object LemonadeIsReady : Abstract(R.string.hint_drink)

    object FinishGame : Abstract(R.string.hint_start_again)
}
