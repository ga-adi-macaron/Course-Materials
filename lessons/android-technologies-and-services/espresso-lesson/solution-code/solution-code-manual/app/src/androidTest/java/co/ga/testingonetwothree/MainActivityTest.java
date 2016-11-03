package co.ga.testingonetwothree;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * James Davis (Impactable)
 * Created on 3/28/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfAddWorks() throws Exception {
        String value1 = "5.23";
        String value2 = "12.01";

        String expectedAnswer = "$17.24";

        onView(withId(R.id.editText1)).perform(clearText(), typeText(value1), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(clearText(), typeText(value2), closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.answerTextView)).check(matches(withText(expectedAnswer)));
    }

    @Test
    public void testViewsDisplayed() throws Exception {
        onView(withId(R.id.editText1)).check(matches(isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(isDisplayed()));
        onView(withId(R.id.addButton)).check(matches(isDisplayed()));
        onView(withId(R.id.answerTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void testErrorIsDisplayed() throws Exception {
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.editText1)).check(matches(hasErrorText("Missing value!")));
    }

    @Test
    public void testAddNumbersError() throws Exception {
        String value1 = "123";
        String value2 = "456";

        String expectedAnswer = "$789";

        onView(withId(R.id.editText1)).perform(clearText(), typeText(value1), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(clearText(), typeText(value2), closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.answerTextView)).check(matches(withText(expectedAnswer)));
    }
}
