package com.example.lemonadeapp

import com.example.lemonadeapp.presentation.Actions
import com.example.lemonadeapp.presentation.UiState
import com.example.lemonadeapp.views.action.ActionButtonUiState
import com.example.lemonadeapp.views.action.UpdateActionButton
import com.example.lemonadeapp.views.picture.UpdatePictureButton
import com.example.lemonadeapp.views.text.UpdateTextView
import org.junit.Assert.assertEquals
import org.junit.Test

class ActionButtonUiStateTest {

    @Test
    fun testNewGameState() {
        val state = ActionButtonUiState.NewGame
        val button = FakeActionButton()
        state.update(button)

        assertEquals(R.string.select_lemon, button.actualTextId)
        assertEquals(true, button.actualEnabled)
    }

    @Test
    fun testStartSqueezingState() {
        val state = ActionButtonUiState.StartSqueezing
        val button = FakeActionButton()
        state.update(button)

        assertEquals(R.string.squeeze_lemon, button.actualTextId)
        assertEquals(false, button.actualEnabled)
    }

    @Test
    fun testFinishSqueezingState() {
        val state = ActionButtonUiState.FinishSqueezing
        val button = FakeActionButton()
        state.update(button)

        assertEquals(R.string.squeeze_lemon, button.actualTextId)
        assertEquals(true, button.actualEnabled)
    }

    @Test
    fun testLemonadeIsReadyState() {
        val state = ActionButtonUiState.LemonadeIsReady
        val button = FakeActionButton()
        state.update(button)

        assertEquals(R.string.drink, button.actualTextId)
        assertEquals(true, button.actualEnabled)
    }

    @Test
    fun testFinishGameState() {
        val state = ActionButtonUiState.FinishGame
        val button = FakeActionButton()
        state.update(button)

        assertEquals(R.string.start_again, button.actualTextId)
        assertEquals(true, button.actualEnabled)
    }

    @Test
    fun testNewGameHandleAction() {
        val state = ActionButtonUiState.NewGame
        val viewModel = FakeViewModel()

        val actual = state.handleAction(viewModel)
        val expected = FakeUiState("1")
        assertEquals(expected, actual)
    }

    @Test(expected = IllegalStateException::class)
    fun testStartSqueezingHandleAction() {
        val state = ActionButtonUiState.StartSqueezing
        state.handleAction(FakeViewModel())
    }

    @Test
    fun testFinishSqueezingHandleAction() {
        val state = ActionButtonUiState.FinishSqueezing
        val viewModel = FakeViewModel()

        val actual = state.handleAction(viewModel)
        val expected = FakeUiState("2")
        assertEquals(expected, actual)
    }

    @Test
    fun testLemonadeIsReadyHandleAction() {
        val state = ActionButtonUiState.LemonadeIsReady
        val viewModel = FakeViewModel()

        val actual = state.handleAction(viewModel)
        val expected = FakeUiState("3")
        assertEquals(expected, actual)
    }

    @Test
    fun testFinishGameHandleAction() {
        val state = ActionButtonUiState.FinishGame
        val viewModel = FakeViewModel()

        val actual = state.handleAction(viewModel)
        val expected = FakeUiState("4")
        assertEquals(expected, actual)
    }
}

private class FakeActionButton : UpdateActionButton {

    var actualTextId: Int = 0
    var actualEnabled: Boolean? = null

    override fun updateUiState(outer: ActionButtonUiState) {
        // SOLID : I interface segregation
    }

    override fun updateText(textId: Int) {
        actualTextId = textId
    }

    override fun updateEnabled(enabled: Boolean) {
        actualEnabled = enabled
    }
}

private class FakeViewModel : Actions {
    override fun startSqueezing(): UiState {
        return FakeUiState("1")
    }

    override fun lemonadeIsReady(): UiState {
        return FakeUiState("2")
    }

    override fun finishGame(): UiState {
        return FakeUiState("3")
    }

    override fun newGame(): UiState {
        return FakeUiState("4")
    }
}

private data class FakeUiState(
    private val id: String
) : UiState {
    override fun update(
        pictureImageButton: UpdatePictureButton,
        actionButton: UpdateActionButton,
        hintTextView: UpdateTextView
    ) = Unit
}