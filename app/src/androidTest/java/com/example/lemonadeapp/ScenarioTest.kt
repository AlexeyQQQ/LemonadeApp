package com.example.lemonadeapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lemonadeapp.game_page.GamePage
import com.example.lemonadeapp.load_page.LoadPage
import com.example.lemonadeapp.main.presentation.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * TestCase N1: сorrect
     * 1 Нажать на кнопку 1 - перешли на Load (state Progress)
     *
     * 1.1 Ожидание ошибки - state Error
     * 1.2 Клик по Retry button - state Progress
     * 1.3 Ожидание загрузки - перешли на Start squeezing
     *
     * 2 Тапнуть 5 раз по картинке лимона - перешли на Finish squeezing
     * 3 Нажали на кнопку 1 - перешли на Lemonade is ready
     * 4 Нажали на кнопку 1 - перешли на Finish game
     * 5 Нажали на кнопку 1 - вернулись на New game
     */
    @Test
    fun testCase1() {

        // step 0
        val gamePage = GamePage()
        gamePage.checkStateNewGame()

        activityScenarioRule.scenario.recreate()
        gamePage.checkStateNewGame()

        // step 1
        gamePage.clickActionButton()

        val loadPage = LoadPage()
        loadPage.checkProgressState()

        activityScenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        // step 1.1
        loadPage.waitError()
        loadPage.checkErrorState(message = "No internet connection")

        activityScenarioRule.scenario.recreate()
        loadPage.checkErrorState(message = "No internet connection")

        // step 1.2
        loadPage.clickRetry()
        loadPage.checkProgressState()

        activityScenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        // step 1.3
        loadPage.waitDisappear()

        // step 2
        repeat(5) {
            gamePage.checkStateStartSqueezing(requiredClicks = 5)
            activityScenarioRule.scenario.recreate()
            gamePage.checkStateStartSqueezing(requiredClicks = 5)
            gamePage.clickOnPicture()
        }
        gamePage.checkStateFinishSqueezing()

        activityScenarioRule.scenario.recreate()
        gamePage.checkStateFinishSqueezing()

        // step 3
        gamePage.clickActionButton()
        gamePage.checkStateLemonadeIsReady()

        activityScenarioRule.scenario.recreate()
        gamePage.checkStateLemonadeIsReady()

        // step 4
        gamePage.clickActionButton()
        gamePage.checkStateFinishGame()

        activityScenarioRule.scenario.recreate()
        gamePage.checkStateFinishGame()

        // step 5
        gamePage.clickActionButton()
        gamePage.checkStateNewGame()

        activityScenarioRule.scenario.recreate()
        gamePage.checkStateNewGame()
    }
}