package com.example.lemonadeapp

import com.example.lemonadeapp.core.views.action.ActionButtonUiState
import com.example.lemonadeapp.core.views.picture.PictureUiState
import com.example.lemonadeapp.core.views.text.TextUiState
import com.example.lemonadeapp.squeezing.data.SqueezingRepository
import com.example.lemonadeapp.squeezing.presentation.SqueezingUiState
import com.example.lemonadeapp.squeezing.presentation.SqueezingViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class SqueezingViewModelTest {

    private lateinit var repository: FakeSqueezingRepository
    private lateinit var viewModel: SqueezingViewModel

    @Before
    fun beforeTest() {
        repository = FakeSqueezingRepository()
        viewModel = SqueezingViewModel(squeezingRepository = repository)
    }

    @Test
    fun testUiStates() {
        var actualUiState: SqueezingUiState = viewModel.init()
        var expectedUiState: SqueezingUiState = SqueezingUiState.StartSqueezing(
            picture = PictureUiState.StartSqueezing,
            button = ActionButtonUiState.StartSqueezing,
            text = TextUiState.StartSqueezing(requiredClicks = 5),
        )

        repeat(5) {
            assertEquals(expectedUiState, actualUiState)
            actualUiState = viewModel.clickOnPicture()
        }

        expectedUiState = SqueezingUiState.FinishSqueezing(
            picture = PictureUiState.FinishSqueezing,
            button = ActionButtonUiState.FinishSqueezing,
            text = TextUiState.FinishSqueezing,
        )
        assertEquals(expectedUiState, actualUiState)
    }

    @Test
    fun testExit() {
        viewModel.exit()
        assertEquals(1, repository.resetCount)
    }
}

private class FakeSqueezingRepository : SqueezingRepository {

    val maxClicks: Int = 5
    var counterOfClicks: Int = 0
    var resetCount: Int = 0

    override fun increment() {
        counterOfClicks++
    }

    override fun isMax(): Boolean {
        return counterOfClicks == 5
    }

    override fun reset() {
        counterOfClicks = 0
        resetCount++
    }

    override fun saveLastScreen() = Unit

    override fun requiredClicks(): Int = maxClicks
}