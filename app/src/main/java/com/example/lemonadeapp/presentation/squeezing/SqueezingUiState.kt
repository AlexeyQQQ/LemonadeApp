package com.example.lemonadeapp.presentation.squeezing

import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.action.UpdateActionButton
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.picture.UpdatePictureButton
import com.example.lemonadeapp.views.text.TextUiState
import com.example.lemonadeapp.views.text.UpdateTextView
import java.io.Serializable

interface SqueezingUiState : Serializable {

    fun update(
        pictureImageButton: UpdatePictureButton,
        actionButton: UpdateActionButton,
        hintTextView: UpdateTextView,
    ) = Unit

    object Empty : SqueezingUiState

    abstract class Abstract(
        private val picture: PictureUiState,
        private val button: ActionButtonUiState,
        private val text: TextUiState,
    ) : SqueezingUiState {

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
}