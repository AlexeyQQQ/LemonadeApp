package com.example.lemonadeapp

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class GamePage {

    private val rootId: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val rootClass: Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))

    private val pictureUi = PictureUi(rootId, rootClass)
    private val actionButtonUi = ActionButtonUi(rootId, rootClass)
    private val textUi = TextUi(rootId, rootClass)

    fun checkStateNewGame() {
        pictureUi.checkStateNewGame()
        actionButtonUi.checkStateNewGame()
        textUi.checkStateNewGame()
    }

    fun checkStateStartSqueezing() {
        pictureUi.checkStateStartSqueezing()
        actionButtonUi.checkStateStartSqueezing()
        textUi.checkStateStartSqueezing()
    }

    fun checkStateFinishSqueezing() {
        pictureUi.checkStateFinishSqueezing()
        actionButtonUi.checkStateFinishSqueezing()
        textUi.checkStateFinishSqueezing()
    }

    fun checkStateLemonadeIsReady() {
        pictureUi.checkStateLemonadeIsReady()
        actionButtonUi.checkStateLemonadeIsReady()
        textUi.checkStateLemonadeIsReady()
    }

    fun checkStateFinishGame() {
        pictureUi.checkStateFinishGame()
        actionButtonUi.checkStateFinishGame()
        textUi.checkStateFinishGame()
    }

    fun clickActionButton() {
        actionButtonUi.click()
    }

    fun clickOnPicture() {
        pictureUi.click()
    }

}
