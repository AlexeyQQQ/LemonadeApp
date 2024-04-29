package com.example.lemonadeapp

import com.example.lemonadeapp.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)

    fun handleAction(viewModel: Actions): UiState

    abstract class Abstract(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : UiState {

        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                picture.update(pictureImageButton)
                button.update(actionButton)
                text.update(hintTextView)
            }
        }

    }

    data class NewGame(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text) {

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.startSqueezing()
        }
    }

    data class StartSqueezing(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text) {

        override fun handleAction(viewModel: Actions): UiState = throw IllegalStateException("")
    }

    data class FinishSqueezing(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text) {

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.lemonadeIsReady()
        }
    }

    data class LemonadeIsReady(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.finishGame()
        }
    }

    data class FinishGame(
        private val picture: PictureUiState,
        private val button: ButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text) {

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.newGame()
        }
    }
}
