package com.example.lemonadeapp

class MainViewModel(
    private val repository: Repository
) : Actions {

    fun init(): UiState {
        return UiState.NewGame(
            picture = PictureUiState.NewGame,
            button = ButtonUiState.NewGame,
            text = TextUiState.NewGame,
        )
    }

    fun clickOnPicture(): UiState {
        return when (repository.increaseCounter()) {
            is CheckResult.Increment -> UiState.StartSqueezing(
                picture = PictureUiState.StartSqueezing,
                button = ButtonUiState.StartSqueezing,
                text = TextUiState.StartSqueezing,
            )

            is CheckResult.ResetCounter -> UiState.FinishSqueezing(
                picture = PictureUiState.FinishSqueezing,
                button = ButtonUiState.FinishSqueezing,
                text = TextUiState.FinishSqueezing,
            )

            else -> throw IllegalStateException()
        }
    }

    override fun startSqueezing(): UiState {
        return UiState.StartSqueezing(
            picture = PictureUiState.StartSqueezing,
            button = ButtonUiState.StartSqueezing,
            text = TextUiState.StartSqueezing,
        )
    }

    override fun lemonadeIsReady(): UiState {
        return UiState.LemonadeIsReady(
            picture = PictureUiState.LemonadeIsReady,
            button = ButtonUiState.LemonadeIsReady,
            text = TextUiState.LemonadeIsReady,
        )
    }

    override fun finishGame(): UiState {
        return UiState.FinishGame(
            picture = PictureUiState.FinishGame,
            button = ButtonUiState.FinishGame,
            text = TextUiState.FinishGame,
        )
    }

    override fun newGame(): UiState {
        return UiState.NewGame(
            picture = PictureUiState.NewGame,
            button = ButtonUiState.NewGame,
            text = TextUiState.NewGame,
        )
    }
}

interface Actions {

    fun startSqueezing(): UiState

    fun lemonadeIsReady(): UiState

    fun finishGame(): UiState

    fun newGame(): UiState
}
