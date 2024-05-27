package com.example.lemonadeapp.squeezing.presentation

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.core.views.action.ActionButtonUiState
import com.example.lemonadeapp.core.views.picture.PictureUiState
import com.example.lemonadeapp.core.views.text.TextUiState
import com.example.lemonadeapp.squeezing.data.SqueezingRepository

class SqueezingViewModel(
    private val squeezingRepository: SqueezingRepository
) : ViewModel() {

    fun init(isFirstTime: Boolean = true): SqueezingUiState {
        return if (isFirstTime) {
            squeezingRepository.saveLastScreen()
            if (squeezingRepository.isMax()) {
                SqueezingUiState.FinishSqueezing(
                    picture = PictureUiState.FinishSqueezing,
                    button = ActionButtonUiState.FinishSqueezing,
                    text = TextUiState.FinishSqueezing,
                )
            } else {
                SqueezingUiState.StartSqueezing(
                    picture = PictureUiState.StartSqueezing,
                    button = ActionButtonUiState.StartSqueezing,
                    text = TextUiState.StartSqueezing(squeezingRepository.requiredClicks()),
                )
            }
        } else {
            SqueezingUiState.Empty
        }
    }

    fun clickOnPicture(): SqueezingUiState {
        squeezingRepository.increment()
        return if (squeezingRepository.isMax()) {
            SqueezingUiState.FinishSqueezing(
                picture = PictureUiState.FinishSqueezing,
                button = ActionButtonUiState.FinishSqueezing,
                text = TextUiState.FinishSqueezing,
            )
        } else {
            SqueezingUiState.StartSqueezing(
                picture = PictureUiState.StartSqueezing,
                button = ActionButtonUiState.StartSqueezing,
                text = TextUiState.StartSqueezing(squeezingRepository.requiredClicks()),
            )
        }
    }

    fun exit() {
        squeezingRepository.reset()
    }
}
