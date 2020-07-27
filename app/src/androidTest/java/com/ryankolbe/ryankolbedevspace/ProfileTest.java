package com.ryankolbe.ryankolbedevspace;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ProfileTest {

    @Rule
    public IntentsTestRule<Profile> intentsTestRule =
            new IntentsTestRule<>(Profile.class);

    @Test
    public void test_ProfileBackButton() {
        onView(withId(R.id.btn_profile_back)).perform(click());
        intended(hasComponent(MenuScreen.class.getName()));
    }

    @Test
    public void test_ProfileTitleDisplay() {
        onView(allOf(withId(R.id.tv_profile_title), isDisplayed()))
                .check(matches(withText("My Details")));
    }

    @Test
    public void test_UserTextView() {
        onView(allOf(withId(R.id.tv_user), isDisplayed()))
                .check(matches(withText("Ryan Kolbe")));
    }

    @Test
    public void test_ContactTextView() {
        onView(allOf(withId(R.id.tv_contact), isDisplayed()))
                .check(matches(withText("012 345 6789")));
    }

    @Test
    public void test_EmailTextView() {
        onView(allOf(withId(R.id.tv_email), isDisplayed())).
                check(matches(withText("216189985@mycput.ac.za")));
    }

    @Test
    public void test_TwitterTextView() {
        onView(allOf(withId(R.id.tv_twitter), isDisplayed())).
                check(matches(withText("ryan.kolbe1")));
    }

    @Test
    public void test_LinkedInTextView() {
        onView(allOf(withId(R.id.tv_linkedin), isDisplayed())).
                check(matches(withText("www.linkedin.com/in/ryan-kolbe")));
    }
}