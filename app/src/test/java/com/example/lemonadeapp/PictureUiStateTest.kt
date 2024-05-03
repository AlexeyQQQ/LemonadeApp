package com.example.lemonadeapp

import androidx.annotation.DrawableRes
import com.example.lemonadeapp.views.picture.PictureUiState
import com.example.lemonadeapp.views.picture.UpdatePictureButton
import org.junit.Assert.assertEquals
import org.junit.Test

class PictureUiStateTest {

    @Test
    fun testNewGameState() {
        val state = PictureUiState.NewGame
        val button = FakePictureButton()
        state.update(button)

        assertEquals(false, button.actualClickable)
        assertEquals(R.drawable.ic_tree, button.actualImageResource)
    }

    @Test
    fun testStartSqueezingState() {
        val state = PictureUiState.StartSqueezing
        val button = FakePictureButton()
        state.update(button)

        assertEquals(true, button.actualClickable)
        assertEquals(R.drawable.ic_lemon, button.actualImageResource)
    }

    @Test
    fun testFinishSqueezingState() {
        val state = PictureUiState.FinishSqueezing
        val button = FakePictureButton()
        state.update(button)

        assertEquals(false, button.actualClickable)
        assertEquals(R.drawable.ic_lemon, button.actualImageResource)
    }

    @Test
    fun testLemonadeIsReadyState() {
        val state = PictureUiState.LemonadeIsReady
        val button = FakePictureButton()
        state.update(button)

        assertEquals(false, button.actualClickable)
        assertEquals(R.drawable.ic_lemonade, button.actualImageResource)
    }

    @Test
    fun testFinishGameState() {
        val state = PictureUiState.FinishGame
        val button = FakePictureButton()
        state.update(button)

        assertEquals(false, button.actualClickable)
        assertEquals(R.drawable.ic_glass, button.actualImageResource)
    }
}

private class FakePictureButton : UpdatePictureButton {

    var actualClickable: Boolean? = null

    @DrawableRes
    var actualImageResource: Int = -1

    override fun updateUiState(outer: PictureUiState) {
        // SOLID : I interface segregation
    }

    override fun updateUi(clickable: Boolean, imageResource: Int) {
        actualClickable = clickable
        actualImageResource = imageResource
    }
}