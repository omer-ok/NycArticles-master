package com.test.nyarticles.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.test.nyarticles.R

import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_fragment_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.fragment))
            .check(matches(isDisplayed())) // method 1

    }

}