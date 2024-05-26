package com.example.lemonadeapp.game_page

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.lemonadeapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class TextUi(
    rootId: Matcher<View>,
    rootClass: Matcher<View>
) {

    private val interaction = onView(
        allOf(
            withId(R.id.hintTextView),
            isAssignableFrom(TextView::class.java),
            rootId,
            rootClass,
        )
    )

    fun checkStateNewGame() {
        interaction.check(matches(withText(R.string.hint_select_lemon)))
    }

    fun checkStateStartSqueezing() {
        interaction.check(matches(withText(R.string.hint_start_squeezing)))
    }

    fun checkStateFinishSqueezing() {
        interaction.check(matches(withText(R.string.hint_start_squeezing)))
    }

    fun checkStateLemonadeIsReady() {
        interaction.check(matches(withText(R.string.hint_drink)))
    }

    fun checkStateFinishGame() {
        interaction.check(matches(withText(R.string.hint_start_again)))
    }

}

