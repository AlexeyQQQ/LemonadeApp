package com.example.lemonadeapp

import com.example.lemonadeapp.data.repository.Repository
import com.example.lemonadeapp.presentation.UiState
import com.example.lemonadeapp.presentation.squeezing.SqueezingViewModel
import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.text.TextUiState
import org.junit.Assert.assertEquals
import org.junit.Test


class SqueezingViewModelTest {

    /**
     * TestCase N1: сorrect
     * 1 Нажать на кнопку 1 - перешли на #2 State: Start squeezing
     * 2 Тапнуть 5 раз по картинке лимона - перешли на #3 State: Finish squeezing
     * 3 Нажали на кнопку 1 - перешли на #4 State: Lemonade is ready
     * 4 Нажали на кнопку 1 - перешли на #5 State: Finish game
     * 5 Нажали на кнопку 1 - вернулись на #1 State: New game
     */
    @Test
    fun testCase1() {
        val repository: FakeRepository = FakeRepository()
        val viewModel: SqueezingViewModel = SqueezingViewModel(repository = repository)

        var actualUiState: UiState = viewModel.init()
        var expectedUiState: UiState = UiState.NewGame(
            picture = PictureUiState.NewGame,
            button = ActionButtonUiState.NewGame,
            text = TextUiState.NewGame,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.startSqueezing()
        expectedUiState = UiState.StartSqueezing(
            picture = PictureUiState.StartSqueezing,
            button = ActionButtonUiState.StartSqueezing,
            text = TextUiState.StartSqueezing,
        )

        repeat(5) {
            assertEquals(expectedUiState, actualUiState)
            actualUiState = viewModel.clickOnPicture()
        }
        expectedUiState = UiState.FinishSqueezing(
            picture = PictureUiState.FinishSqueezing,
            button = ActionButtonUiState.FinishSqueezing,
            text = TextUiState.FinishSqueezing,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.lemonadeIsReady()
        expectedUiState = UiState.LemonadeIsReady(
            picture = PictureUiState.LemonadeIsReady,
            button = ActionButtonUiState.LemonadeIsReady,
            text = TextUiState.LemonadeIsReady,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.finishGame()
        expectedUiState = UiState.FinishGame(
            picture = PictureUiState.FinishGame,
            button = ActionButtonUiState.FinishGame,
            text = TextUiState.FinishGame,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.newGame()
        expectedUiState = UiState.NewGame(
            picture = PictureUiState.NewGame,
            button = ActionButtonUiState.NewGame,
            text = TextUiState.NewGame,
        )
        assertEquals(expectedUiState, actualUiState)
    }
}

private class FakeRepository : Repository {

    private var counterOfClicks: Int = 0

    override fun increment() {
        counterOfClicks++
    }

    override fun isMax(): Boolean {
        return counterOfClicks == 5
    }

    override fun reset() {
        counterOfClicks = 0
    }
}