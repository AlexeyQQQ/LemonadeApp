package com.example.lemonadeapp.presentation.squeezing

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.data.SqueezingRepository
import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.text.TextUiState

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
                    text = TextUiState.StartSqueezing,
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
                text = TextUiState.StartSqueezing,
            )
        }
    }

    fun exit() {
        squeezingRepository.reset()
    }
}
