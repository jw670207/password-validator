package com.example.paper.csci3130_a2;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ValidatorUITest {

    @Rule
    public ActivityTestRule<Validator> mActivityTestRule = new ActivityTestRule<>(Validator.class);

    @Test
    public void validatorUITest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.pwET),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.pwET),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText2.perform(replaceText("Bb1279bn"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.submitBT), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.pwET), withText("Bb1279bn"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText3.perform(replaceText("B455pyy"));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.pwET), withText("B455pyy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText4.perform(closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.submitBT), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.pwET), withText("B455pyy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText5.perform(replaceText("B455pyy 65"));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.pwET), withText("B455pyy 65"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText6.perform(closeSoftKeyboard());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.submitBT), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.pwET), withText("B455pyy 65"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText7.perform(replaceText("B45TT4564"));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.pwET), withText("B45TT4564"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        editText8.perform(closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.submitBT), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        button4.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
