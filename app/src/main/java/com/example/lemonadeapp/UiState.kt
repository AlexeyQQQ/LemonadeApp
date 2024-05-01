package com.example.lemonadeapp

import com.example.lemonadeapp.ActionButtonUi.ActionButtonUiState
import com.example.lemonadeapp.PictureButtonUi.PictureUiState
import com.example.lemonadeapp.TextUi.TextUiState
import com.example.lemonadeapp.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)

    abstract class Abstract(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : UiState {

        override fun update(binding: ActivityMainBinding) = with(binding) {
            pictureImageButton.updateUiState(picture)
            actionButton.updateUiState(button)
            text.update(hintTextView)
        }
    }

    data class NewGame(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text)

    data class StartSqueezing(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text)

    data class FinishSqueezing(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text)

    data class LemonadeIsReady(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text)

    data class FinishGame(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : Abstract(picture, button, text)
}
