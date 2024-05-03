package com.example.lemonadeapp.views.action

import androidx.annotation.StringRes
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.Actions
import com.example.lemonadeapp.presentation.UiState
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun update(button: UpdateActionButton)

    fun handleAction(viewModel: Actions): UiState

    abstract class Abstract(
        private val enabled: Boolean = true,
        @StringRes private val resId: Int,
    ) : ActionButtonUiState {

        override fun update(button: UpdateActionButton) {
            button.updateEnabled(enabled)
            button.updateText(resId)
        }
    }

    object NewGame : Abstract(resId = R.string.select_lemon) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.startSqueezing()
        }
    }

    object StartSqueezing : Abstract(enabled = false, resId = R.string.squeeze_lemon) {
        override fun handleAction(viewModel: Actions): UiState = throw IllegalStateException("")
    }

    object FinishSqueezing : Abstract(resId = R.string.squeeze_lemon) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.lemonadeIsReady()
        }
    }

    object LemonadeIsReady : Abstract(resId = R.string.drink) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.finishGame()
        }
    }

    object FinishGame : Abstract(resId = R.string.start_again) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.newGame()
        }
    }
}
