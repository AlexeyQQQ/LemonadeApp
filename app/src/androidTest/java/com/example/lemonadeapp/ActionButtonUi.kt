package com.example.lemonadeapp

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class ActionButtonUi(
    rootId: Matcher<View>,
    rootClass: Matcher<View>
) {

    private val interaction = onView(
        allOf(
            withId(R.id.actionButton),
            isAssignableFrom(AppCompatButton::class.java),
            rootId,
            rootClass
        )
    )

    fun checkStateNewGame() {
        interaction.check(matches(withText(R.string.select_lemon)))
            .check(matches(isEnabled()))
    }

    fun checkStateStartSqueezing() {
        interaction.check(matches(withText(R.string.squeeze_lemon)))
            .check(matches(not(isEnabled())))
    }

    fun checkStateFinishSqueezing() {
        interaction.check(matches(withText(R.string.squeeze_lemon)))
            .check(matches(isEnabled()))
    }

    fun checkStateLemonadeIsReady() {
        interaction.check(matches(withText(R.string.drink)))
            .check(matches(isEnabled()))
    }

    fun checkStateFinishGame() {
        interaction.check(matches(withText(R.string.start_again)))
            .check(matches(isEnabled()))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

}
