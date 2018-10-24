package com.vladimir_khm.users.main;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.vladimir_khm.users.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static org.hamcrest.CoreMatchers.equalTo;
import static com.vladimir_khm.users.Constants.USER_ID;


@RunWith(AndroidJUnit4.class)
public class UsersActivityTest {

    private final String CLICKED_USER_ID = "59c92a0521f2d2a3670f6c18";

    @Rule
    public IntentsTestRule<UsersActivity> activityRule =
            new IntentsTestRule<>(UsersActivity.class);

    @Test
    public void listItemClick() {
        onView(withId(R.id.recyclerViewMain))
                .perform(actionOnItemAtPosition(0, click()));
        intended(hasExtras(hasEntry(equalTo(USER_ID), equalTo(CLICKED_USER_ID))));
        onView(withId(R.id.tvUserIDDetail)).check(matches(withText(CLICKED_USER_ID)));
    }

}