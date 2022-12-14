package com.assignment.lloydsassignmentapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.assignment.lloydsassignmentapp.ui.AnimalListFragment
import com.assignment.lloydsassignmentapp.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AnimalListFragmentTest {
    @get:Rule
    var rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
        MainActivity::class.java
    )

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    private lateinit var scenario: FragmentScenario<AnimalListFragment>

    @Before
    fun setup() {
        val fragmentArgs = bundleOf("selecteditem" to 0)
        scenario = launchFragmentInContainer<AnimalListFragment>(fragmentArgs)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testRecyclerView() {
        onView(withId(R.id.animallist)).check(matches(not(isDisplayed())))
    }


}
