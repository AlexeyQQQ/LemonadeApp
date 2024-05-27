package com.example.lemonadeapp

import com.example.lemonadeapp.core.views.text.TextUiState
import com.example.lemonadeapp.core.views.text.UpdateTextView
import org.junit.Assert.assertEquals
import org.junit.Test

class CustomTextViewUiStateTest {

    @Test
    fun testNewGameState() {
        val state = TextUiState.NewGame
        val textView = FakeTextView()
        state.update(textView)

        assertEquals(R.string.hint_select_lemon, textView.actualResId)
    }

    @Test
    fun testStartSqueezingState() {
        val state = TextUiState.StartSqueezing(requiredClicks = 5)
        val textView = FakeTextView()
        state.update(textView)

        assertEquals(R.string.hint_start_squeezing, textView.actualResId)
    }

    @Test
    fun testFinishSqueezingState() {
        val state = TextUiState.FinishSqueezing
        val textView = FakeTextView()
        state.update(textView)

        assertEquals(R.string.hint_finish_squeezing, textView.actualResId)
    }

    @Test
    fun testLemonadeIsReadyState() {
        val state = TextUiState.LemonadeIsReady
        val textView = FakeTextView()
        state.update(textView)

        assertEquals(R.string.hint_drink, textView.actualResId)
    }

    @Test
    fun testFinishGameState() {
        val state = TextUiState.FinishGame
        val textView = FakeTextView()
        state.update(textView)

        assertEquals(R.string.hint_start_again, textView.actualResId)
    }
}

private class FakeTextView : UpdateTextView {

    var actualResId: Int = -1

    override fun updateText(resId: Int) {
        actualResId = resId
    }

    override fun updateText(resId: Int, requiredClicks: Int) {
        actualResId = resId
    }
}