package com.example.lemonadeapp.presentation.squeezing

import com.example.lemonadeapp.data.repository.Repository
import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.text.TextUiState

class SqueezingViewModel(
    private val repository: Repository
) {

    fun init(isFirstTime: Boolean = true): SqueezingUiState {
        return if (isFirstTime) {
            SqueezingUiState.StartSqueezing(
                picture = PictureUiState.StartSqueezing,
                button = ActionButtonUiState.StartSqueezing,
                text = TextUiState.StartSqueezing,
            )
        } else {
            SqueezingUiState.Empty
        }
    }

    fun clickOnPicture(): SqueezingUiState {
        repository.increment()
        return if (repository.isMax()) {
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
        repository.reset()
    }
}
