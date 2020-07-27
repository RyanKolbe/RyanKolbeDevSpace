package com.ryankolbe.ryankolbedevspace;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class SetErrorMatcher {

    @NonNull
    public static Matcher<View> withError() {
        return new BoundedMatcher<View, EditText>(EditText.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("has no error text: ");
            }

            @Override
            protected boolean matchesSafely(EditText item) {
                return item.getError() != null;
            }
        };
    }
}