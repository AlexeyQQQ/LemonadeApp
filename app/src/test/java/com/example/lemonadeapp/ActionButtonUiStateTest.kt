package com.example.lemonadeapp

import com.example.lemonadeapp.core.views.action.ActionButtonUiState
import com.example.lemonadeapp.core.views.action.UpdateActionButton
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