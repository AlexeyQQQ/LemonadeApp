package com.example.lemonadeapp.game_page

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.lemonadeapp.R
import com.example.lemonadeapp.custom_matchers.DrawableMatcher
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class PictureUi(
    rootId: Matcher<View>,
    rootClass: Matcher<View>,
) {

    private val interaction = onView(
        allOf(
            withId(R.id.pictureImageButton),
            isAssignableFrom(AppCompatImageButton::class.java),
            rootId,
            rootClass
        )
    )

    fun checkStateNewGame() {
        interaction.check(matches(DrawableMatcher(R.drawable.ic_tree)))
            .check(matches(not(isClickable())))
    }

    fun checkStateStartSqueezing() {
        interaction.check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(isClickable()))
    }

    fun checkStateFinishSqueezing() {
        interaction.check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(not(isClickable())))
    }

    fun checkStateLemonadeIsReady() {
        interaction.check(matches(DrawableMatcher(R.drawable.ic_lemonade)))
            .check(matches(not(isClickable())))
    }

    fun checkStateFinishGame() {
        interaction.check(matches(DrawableMatcher(R.drawable.ic_glass)))
            .check(matches(not(isClickable())))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
}
