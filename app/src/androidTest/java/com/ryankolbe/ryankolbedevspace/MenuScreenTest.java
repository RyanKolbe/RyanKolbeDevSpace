package com.ryankolbe.ryankolbedevspace;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MenuScreenTest {

    @Rule
    public IntentsTestRule<MenuScreen> intentsTestRule =
            new IntentsTestRule<>(MenuScreen.class);

    @Test
    public void test_ClickHomeButton() {
        onView(withId(R.id.btn_menu_home)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }

    @Test
    public void test_ClickCalculationButton() {
        onView(withId(R.id.btn_menu_calculator)).perform(click());
        intended(hasComponent(Calculator.class.getName()));
    }

    @Test
    public void test_ClickDevProfileButton() {
        onView(withId(R.id.btn_menu_profile)).perform(click());
        intended(hasComponent(Profile.class.getName()));
    }

    @Test
    public void test_ClickAboutMeButton() {
        onView(withId(R.id.btn_menu_about)).perform(click());
        intended(hasComponent(AboutMe.class.getName()));
    }
}