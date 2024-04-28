package com.example.lemonadeapp

import org.junit.Assert.assertEquals
import org.junit.Test


class MainViewModelTest {

    /**
     * TestCase N1: сorrect
     * 1 Нажать на кнопку 1 - перешли на #2 State: Start squeezing
     * 2 Тапнуть 5 раз по картинке лимона - перешли на #3 State: Finish squeezing
     * 3 Нажали на кнопку 1 - перешли на #4 State: Lemonade is ready
     * 4 Нажали на кнопку 1 - перешли на #5 State: Finish game
     * 5 Нажали на кнопку 1 - вернулись на #1 State: New game
     */
    @Test
    fun addition_isCorrect() {
        val repository: FakeRepository = FakeRepository()
        val viewModel: MainViewModel = MainViewModel(repository = repository)

        var actualUiState: UiState = viewModel.init()
        var expectedUiState: UiState = UiState.NewGame
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.startSqueezing()
        expectedUiState = UiState.StartSqueezing

        repeat(5) {
            assertEquals(expectedUiState, actualUiState)
            actualUiState = viewModel.clickOnPicture()
        }
        expectedUiState = UiState.FinishSqueezing
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.lemonadeIsReady()
        expectedUiState = UiState.LemonadeIsReady
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.finishGame()
        expectedUiState = UiState.FinishGame
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.newGame()
        expectedUiState = UiState.NewGame
        assertEquals(expectedUiState, actualUiState)
    }

//    @Test
//    fun addition_isCorrect() {
//        val viewModel: MainViewModel = MainViewModel()
//
//        var actualUiState: UiState = viewModel.init()
//        var expectedUiState: UiState = UiState.NewGame
//        assertEquals(expectedUiState, actualUiState)
//
//        actualUiState = viewModel.handleAction()
//        expectedUiState = UiState.StartSqueezing
//
//        repeat(5) {
//            assertEquals(expectedUiState, actualUiState)
//            actualUiState = viewModel.clickOnPicture()
//        }
//        expectedUiState = UiState.FinishSqueezing
//        assertEquals(expectedUiState, actualUiState)
//
//        actualUiState = viewModel.handleAction()
//        expectedUiState = UiState.LemonadeIsReady
//        assertEquals(expectedUiState, actualUiState)
//
//        actualUiState = viewModel.handleAction()
//        expectedUiState = UiState.FinishGame
//        assertEquals(expectedUiState, actualUiState)
//
//        actualUiState = viewModel.handleAction()
//        expectedUiState = UiState.NewGame
//        assertEquals(expectedUiState, actualUiState)
//    }
}

private class FakeRepository : Repository {

    private var counterOfClicks: Int = 0

    override fun increaseCounter(): CheckResult {
        counterOfClicks++
        return if (counterOfClicks < 5) {
            CheckResult.Increment
        } else {
            counterOfClicks = 0
            CheckResult.ResetCounter
        }
    }
}