package com.ryankolbe.ryankolbedevspace;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ryankolbe.ryankolbedevspace.SetErrorMatcher.withError;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class CalculatorTest {

    public String length = "2";
    public String width = "7";
    public String height = "5";

    @Rule
    public IntentsTestRule<Calculator> intentsTestRule =
            new IntentsTestRule<>(Calculator.class);

    @Test
    public void test_CalculatorClickHomeButton() {
        onView(withId(R.id.btn_calculator_back)).perform(click());
        intended(hasComponent(MenuScreen.class.getName()));
    }

    @Test
    public void test_EditTextLengthSetError() {
        onView(withId(R.id.et_height))
                .perform(typeText(height), closeSoftKeyboard());
        onView(withId(R.id.et_width))
                .perform(typeText(width), closeSoftKeyboard());
        onView(withId(R.id.btn_run_formula))
                .perform(click());
        onView(allOf(withId(R.id.et_length), isDisplayed()))
                .check(matches(withError()));
    }

    @Test
    public void test_EditTextWidthSetError() {
        onView(withId(R.id.et_height))
                .perform(typeText(height), closeSoftKeyboard());
        onView(withId(R.id.et_length))
                .perform(typeText(length), closeSoftKeyboard());
        onView(withId(R.id.btn_run_formula))
                .perform(click());
        onView(allOf(withId(R.id.et_width), isDisplayed()))
                .check(matches(withError()));
    }

    @Test
    public void test_EditTextHeightSetError() {
        onView(withId(R.id.et_length))
                .perform(typeText(length), closeSoftKeyboard());
        onView(withId(R.id.et_width))
                .perform(typeText(width), closeSoftKeyboard());
        onView(withId(R.id.btn_run_formula))
                .perform(click());
        onView(allOf(withId(R.id.et_height), isDisplayed()))
                .check(matches(withError()));
    }

    @Test
    public void test_CalculationResult() {
        onView(withId(R.id.et_length))
                .perform(typeText(length), closeSoftKeyboard());
        onView(withId(R.id.et_width))
                .perform(typeText(width), closeSoftKeyboard());
        onView(withId(R.id.et_height))
                .perform(typeText(height), closeSoftKeyboard());
        onView(withId(R.id.btn_run_formula))
                .perform(click());
        onView(allOf(withId(R.id.tv_calculation_result), isDisplayed()))
                .check(matches(withText("118")));
    }
}