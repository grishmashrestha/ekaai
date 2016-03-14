package com.lftechnology.unito;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import com.lftechnology.unito.activity.NewActivity;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/11/16.
 */
public class NewActivityTest {

    @Rule
    public ActivityTestRule<NewActivity> newActivityActivityTestRule = new ActivityTestRule<NewActivity>(NewActivity.class);

    @Test
    public void testButtonClick() {
        Espresso.onView(ViewMatchers.withId(R.id.clickMeBtn)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.editText)).check(ViewAssertions.matches(getMyMatcher()));
    }

    private Matcher<View> getMyMatcher(){
        new TypeSafeMatcher<View>(){

            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                if(item instanceof TextView)
                    return ((TextView)item).getText().toString().length() > 0;

                return false;
            }
        };
    }
 }
