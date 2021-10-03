package com.example.awesomeapp

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.awesomeapp.ui.DetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<DetailActivity>()

    @Test
    fun launchActivity() {
        val scenario = activityScenarioRule.scenario
    }
}