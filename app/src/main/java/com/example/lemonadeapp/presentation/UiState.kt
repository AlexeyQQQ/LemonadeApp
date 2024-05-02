package com.example.lemonadeapp.presentation

import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.action.UpdateActionButton
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.picture.UpdatePictureButton
import com.example.lemonadeapp.views.text.TextUiState
import com.example.lemonadeapp.views.text.UpdateTextView
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
