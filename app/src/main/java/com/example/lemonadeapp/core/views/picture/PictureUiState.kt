package com.example.lemonadeapp.core.views.picture

import androidx.annotation.DrawableRes
import com.example.lemonadeapp.R
import java.io.Serializable

interface PictureUiState : Serializable {

    fun update(imageButton: UpdatePictureButton)

    abstract class Abstract(
        private val isClickable: Boolean = false,
        @DrawableRes private val imageResource: Int,
    ) : PictureUiState {

        override fun update(imageButton: UpdatePictureButton) {
            imageButton.updateUi(isClickable, imageResource)
        }
    }

    object NewGame : Abstract(imageResource = R.drawable.ic_tree)

    object StartSqueezing : Abstract(isClickable = true, imageResource = R.drawable.ic_lemon)

    object FinishSqueezing : Abstract(imageResource = R.drawable.ic_lemon)

    object LemonadeIsReady : Abstract(imageResource = R.drawable.ic_lemonade)

    object FinishGame : Abstract(imageResource = R.drawable.ic_glass)
}
