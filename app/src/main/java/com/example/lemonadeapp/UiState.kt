package com.example.lemonadeapp

import com.example.lemonadeapp.ActionButtonUi.ActionButtonUiState
import com.example.lemonadeapp.ActionButtonUi.UpdateActionButton
import com.example.lemonadeapp.PictureButtonUi.PictureUiState
import com.example.lemonadeapp.PictureButtonUi.UpdatePictureButton
import com.example.lemonadeapp.TextUi.TextUiState
import com.example.lemonadeapp.TextUi.UpdateTextView
import java.io.Serializable

interface UiState : Serializable {

//    fun update(binding: ActivityMainBinding)

    fun update(
        pictureImageButton: UpdatePictureButton,
        actionButton: UpdateActionButton,
        hintTextView: UpdateTextView,
    )

    object Empty : UiState {
        override fun update(
            pictureImageButton: UpdatePictureButton,
            actionButton: UpdateActionButton,
            hintTextView: UpdateTextView,
        ) = Unit
    }

    abstract class Abstract(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : UiState {

        override fun update(
            pictureImageButton: UpdatePictureButton,
            actionButton: UpdateActionButton,
            hintTextView: UpdateTextView,
        ) {
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
