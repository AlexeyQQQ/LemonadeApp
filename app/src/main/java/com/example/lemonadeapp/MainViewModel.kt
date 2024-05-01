package com.example.lemonadeapp

import com.example.lemonadeapp.ActionButtonUi.ActionButtonUiState
import com.example.lemonadeapp.PictureButtonUi.PictureUiState
import com.example.lemonadeapp.TextUi.TextUiState
import com.example.lemonadeapp.repository.Repository

class MainViewModel(
    private val repository: Repository
) : Actions {

    fun init(isFirstTime: Boolean = true): UiState {
        return if (isFirstTime) {
            UiState.NewGame(
                picture = PictureUiState.NewGame,
                button = ActionButtonUiState.NewGame,
                text = TextUiState.NewGame,
            )
        } else {
            UiState.Empty
        }
    }

    fun clickOnPicture(): UiState {
        repository.increment()
        return if (repository.isMax()) {
            UiState.FinishSqueezing(
                picture = PictureUiState.FinishSqueezing,
                button = ActionButtonUiState.FinishSqueezing,
                text = TextUiState.FinishSqueezing,
            )
        } else {
            UiState.StartSqueezing(
                picture = PictureUiState.StartSqueezing,
                button = ActionButtonUiState.StartSqueezing,
                text = TextUiState.StartSqueezing,
            )
        }
    }

    override fun startSqueezing(): UiState {
        return UiState.StartSqueezing(
            picture = PictureUiState.StartSqueezing,
            button = ActionButtonUiState.StartSqueezing,
            text = TextUiState.StartSqueezing,
        )
    }

    override fun lemonadeIsReady(): UiState {
        return UiState.LemonadeIsReady(
            picture = PictureUiState.LemonadeIsReady,
            button = ActionButtonUiState.LemonadeIsReady,
            text = TextUiState.LemonadeIsReady,
        )
    }

    override fun finishGame(): UiState {
        return UiState.FinishGame(
            picture = PictureUiState.FinishGame,
            button = ActionButtonUiState.FinishGame,
            text = TextUiState.FinishGame,
        )
    }

    override fun newGame(): UiState {
        repository.reset()
        return init()
    }
}

interface Actions {

    fun startSqueezing(): UiState

    fun lemonadeIsReady(): UiState

    fun finishGame(): UiState

    fun newGame(): UiState
}
