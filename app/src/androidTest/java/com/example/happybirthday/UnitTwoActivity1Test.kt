package com.example.happybirthday

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.happybirthday.unit2.UnitTwoActivity1
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UnitTwoActivity1Test {
    @get:Rule
    val activity = ActivityScenarioRule(UnitTwoActivity1::class.java)

    @Test
    fun AffirmationsListTests() {
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollTo<RecyclerView.ViewHolder>(
                    withText(R.string.affirmation10)
                )
        )

        onView(withText(R.string.affirmation10))
            .check(
                matches(isDisplayed())
            )
    }
}