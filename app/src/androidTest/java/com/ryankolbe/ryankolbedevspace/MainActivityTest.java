package com.ryankolbe.ryankolbedevspace;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ryankolbe.ryankolbedevspace.SetErrorMatcher.withError;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_UserInputVisitorName() {
        String userName = "Ryan Kolbe";
        onView(withId(R.id.et_visitor_name))
                .perform(typeText(userName), closeSoftKeyboard());
        onView(withId(R.id.bt_launch_next)).perform(click());
    }

    @Test
    public void test_SetErrorNullUserInput() {
        onView(withId(R.id.bt_launch_next))
                .perform(click());
        onView(allOf(withId(R.id.et_visitor_name), isDisplayed()))
                .check(matches(withError()));
    }

    @Test
    public void test_VisitorNameIntentPassed() {
        String userName = "Ryan Kolbe";
        onView(withId(R.id.et_visitor_name))
                .perform(typeText(userName), closeSoftKeyboard());
        onView(withId(R.id.bt_launch_next)).perform(click());

        onView(allOf(withId(R.id.menu_screen_intro), isDisplayed()))
                .check(matches(withText(String.format("Dear %s \n Welcome to my code space", userName))));
    }
}