package com.ryankolbe.ryankolbedevspace;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class AboutMeTest {

    @Rule
    public IntentsTestRule<AboutMe> intentsTestRule =
            new IntentsTestRule<>(AboutMe.class);

    @Test
    public void test_ClickHomeButton() {
        onView(withId(R.id.btn_about_me_back)).perform(click());
        intended(hasComponent(MenuScreen.class.getName()));
    }

    @Test
    public void test_ProfileTextViewTop() {
        onView(allOf(withId(R.id.tv_scrollview), isDisplayed()))
                .check(matches(withSubstring("professional")));
    }

    @Test
    public void test_ProfileTextViewBottom() {
        onView(allOf(withId(R.id.tv_scrollview), isDisplayed()))
                .perform(swipeUp())
                .check(matches(withSubstring("Netflix")));
    }
}