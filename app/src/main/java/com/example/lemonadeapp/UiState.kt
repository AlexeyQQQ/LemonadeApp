package com.example.lemonadeapp

import com.example.lemonadeapp.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)

    fun handleAction(viewModel: Actions): UiState

    object NewGame : UiState {
        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                pictureImageButton.isClickable = false
                pictureImageButton.setImageResource(R.drawable.ic_tree)

                actionButton.isEnabled = true
                actionButton.text = actionButton.context.getString(R.string.select_lemon)

                hintTextView.text = hintTextView.context.getString(R.string.hint_select_lemon)
            }
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.startSqueezing()
        }
    }

    object StartSqueezing : UiState {
        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                pictureImageButton.isClickable = true
                pictureImageButton.setImageResource(R.drawable.ic_lemon)

                actionButton.isEnabled = false
                actionButton.text = actionButton.context.getString(R.string.squeeze_lemon)

                hintTextView.text = hintTextView.context.getString(R.string.hint_start_squeezing)
            }
        }

        override fun handleAction(viewModel: Actions): UiState = throw IllegalStateException("")
    }

    object FinishSqueezing : UiState {
        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                pictureImageButton.isClickable = false
                pictureImageButton.setImageResource(R.drawable.ic_lemon)

                actionButton.isEnabled = true
                actionButton.text = actionButton.context.getString(R.string.squeeze_lemon)

                hintTextView.text =
                    hintTextView.context.getString(R.string.hint_start_squeezing)
            }
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.lemonadeIsReady()
        }
    }

    object LemonadeIsReady : UiState {
        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                pictureImageButton.isClickable = false
                pictureImageButton.setImageResource(R.drawable.ic_lemonade)

                actionButton.isEnabled = true
                actionButton.text = actionButton.context.getString(R.string.drink)

                hintTextView.text = hintTextView.context.getString(R.string.hint_drink)
            }
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.finishGame()
        }
    }

    object FinishGame : UiState {
        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                pictureImageButton.isClickable = false
                pictureImageButton.setImageResource(R.drawable.ic_glass)

                actionButton.isEnabled = true
                actionButton.text = actionButton.context.getString(R.string.start_again)

                hintTextView.text = hintTextView.context.getString(R.string.hint_start_again)
            }
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.newGame()
        }
    }

}
