package com.example.lemonadeapp

class MainViewModel(
    private val repository: Repository
) : Actions {

    fun init(): UiState {
        return UiState.NewGame
    }

    fun clickOnPicture(): UiState {
        return when (repository.increaseCounter()) {
            is CheckResult.Increment -> UiState.StartSqueezing
            is CheckResult.ResetCounter -> UiState.FinishSqueezing
            else -> throw IllegalStateException()
        }
    }

    override fun startSqueezing(): UiState {
        return UiState.StartSqueezing
    }

    override fun lemonadeIsReady(): UiState {
        return UiState.LemonadeIsReady
    }

    override fun finishGame(): UiState {
        return UiState.FinishGame
    }

    override fun newGame(): UiState {
        return UiState.NewGame
    }
}

interface Actions {

    fun startSqueezing(): UiState

    fun lemonadeIsReady(): UiState

    fun finishGame(): UiState

    fun newGame(): UiState
}
