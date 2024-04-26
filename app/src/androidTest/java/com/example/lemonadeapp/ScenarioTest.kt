package com.example.lemonadeapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * TestCase N1: сorrect
     * 1 Нажать на кнопку 1 - перешли на #2 State: Start squeezing
     * 2 Тапнуть 5 раз по картинке лимона - перешли на #3 State: Finish squeezing
     * 3 Нажали на кнопку 1 - перешли на #4 State: Lemonade is ready
     * 4 Нажали на кнопку 1 - перешли на #5 State: Finish game
     * 5 Нажали на кнопку 1 - вернулись на #1 State: New game
     */
    @Test
    fun useAppContext() {
        val gamePage = GamePage()
        gamePage.checkStateNewGame()

        gamePage.clickActionButton()

        repeat(5) {
            gamePage.checkStateStartSqueezing()
            gamePage.clickOnPicture()
        }
        gamePage.checkStateFinishSqueezing()

        gamePage.clickActionButton()
        gamePage.checkStateLemonadeIsReady()

        gamePage.clickActionButton()
        gamePage.checkStateFinishGame()

        gamePage.clickActionButton()
        gamePage.checkStateNewGame()
    }
}