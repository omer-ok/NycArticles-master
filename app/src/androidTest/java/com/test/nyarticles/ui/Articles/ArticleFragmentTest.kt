package com.test.nyarticles.ui.Articles

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.test.nyarticles.R
import com.test.nyarticles.ui.Articles.Adapter.ArticleAdapter
import com.test.nyarticles.ui.MainActivity
import org.junit.Rule
import org.hamcrest.CoreMatchers.not

import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ArticleFragmentTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /*@get: Rule
    val espressoIdlingResoureRule = EspressoIdlingResourceRule()*/


    @Test
    fun a_test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.recycler_view_list)).check(matches(isDisplayed()))

        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
    }
}