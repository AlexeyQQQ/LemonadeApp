package com.example.lemonadeapp.core.views.action

import androidx.annotation.StringRes
import com.example.lemonadeapp.R
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun update(button: UpdateActionButton)
    abstract class Abstract(
        private val enabled: Boolean = true,
        @StringRes private val resId: Int,
    ) : ActionButtonUiState {

        override fun update(button: UpdateActionButton) {
            button.updateEnabled(enabled)
            button.updateText(resId)
        }
    }

    object NewGame : Abstract(resId = R.string.select_lemon)

    object StartSqueezing : Abstract(enabled = false, resId = R.string.squeeze_lemon)

    object FinishSqueezing : Abstract(resId = R.string.squeeze_lemon)

    object LemonadeIsReady : Abstract(resId = R.string.drink)

    object FinishGame : Abstract(resId = R.string.start_again)
}
