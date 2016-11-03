---
title: UI Testing with Espresso
type: lesson
duration: "1:30"
creator: James Davis (NYC)

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) UI Testing with Espresso

### LEARNING OBJECTIVES
*After this lesson, students will be able to:*

- Determine the differences between UI Testing and Unit Testing
- Create UI tests using the Espresso Recorder
- Run UI tests with the Espresso framework


### STUDENT PRE-WORK
*Before this lesson, students should already be able to:*

- Explain the purpose of testing

### INSTRUCTOR PREP

_Before this lesson, instructors will need to:_

- Open Android Studio. Start Genymotion, or have a device open in Vysor

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction-what-is-espresso-5-mins)  | What is Espresso? |
| 20 min  | [Demo](#demo-setting-up-espresso-20-minutes)  | Setting up Espresso |
| 20 min  | [Guided Practice](#guided-practice-making-tests-do-stuff-20-mins)  | Making Tests do "Stuff" |
| 5 min  | [Introduction](#introduction-note-about-collection-views-5-mins)  | Note about Collection Views |
| 15 min  | [Guided Practice](#guided-practice-write-some-tests-15-mins)  | Write Some Tests |
| 15 min  | [Independent Practice](#independent-practice-write-some-tests-15-mins)  | Write Some Tests! |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening (5 mins)

There are two main types of programmatic testing: Unit testing and User Interface testing. They both test _if an app behaves as expected_.

Unit testing tests the smallest units of an app, usually classes or their methods. **UI testing** tests the flow and visuals of an app.

This can be done manually - you look at an app and confirm that your elements are working as expected (e.g., if a clicked button opens a dialog, or if a block of text is visible on the screen).

But that's not very cool. Just like unit tests, you can automate UI testing with Espresso.

## Introduction: What is Espresso? (5 mins)

Espresso is a testing framework, created by Google and provided by the [Testing Support Library](http://developer.android.com/tools/testing-support-library/index.html#Espresso) that helps Android engineers develop reliable UI tests.

Extra documentation can also be found [here](https://google.github.io/android-testing-support-library/docs/espresso/index.html).

When using Espresso, Android Studio compiles your code as per usual. However, the difference is that it installs a testing APK onto the device and it automatically starts running the tests when it starts.

## Demo: Setting up Espresso (20 minutes)

**This section is no longer needed since the addition of the Espresso Recorder. Keep here for reference.**

Feel free to code along if you'd like!

#### Include Espresso in your apps

To start testing, you have to import the Espresso library into your project.

Open your app/build.gradle file and add the core Espresso library as a dependency.

```gradle
	dependencies {
    	// ... other dependencies ...

		androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.2'
    androidTestCompile 'com.android.support.test:runner:0.5'
    androidTestCompile 'com.android.support:support-annotations:23.2.1'
	}
```

**You might need to adjust your support annotation version number to match the build tool version.**

Also, in the same file, add the test runner (which, well, runs the tests) to the default Android config:

```gradle
	android {
    	compileSdkVersion 23
    	buildToolsVersion "23.0.2"

    	defaultConfig {
        	// .. other config options ..

        	testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    	}
    }
```

#### Adding a test

Adding a test in Android Studio is as easy as adding a class (since all tests are classes with methods being run).

Remember, for Espresso, always add your UI tests to the _androidTest_ folder. Unit tests go in the regular _test_ folder.

Right click the application's package folder in the _src/androidTest/java_ folder, and click on New > Java Class and name it whatever you'd like. It should probably be named after the Activity you are testing (i.e., if you are testing the SettingsActivity, it is suggested to call it SettingsActivityTest).

For Espresso to run the test, you have to annotate the class:

```java

    @RunWith(AndroidJUnit4.class)
    public class LoginActivityTest {
        // ...
    }

```

Next, you have to add a test rule member variable, which defines which Activity we'll be testing. It is of type `ActivityTestRule`, and should be annotated with `@Rule`:

```java

    @RunWith(AndroidJUnit4.class)
    public class LoginActivityTest {

        @Rule
        public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    // ...

    }


```

Your class is setup for testing. Now, you have to add tests for everything you're testing in the activity. Every test is a method, annotated with `@Test`, where it's name is prefixed with the word `test` (i.e. testIfOnline, testThatAppLaunches, etc).

For simplicity, you can also right click the class, click _Generate..._, and then click _Test Method_.

```java

    @RunWith(AndroidJUnit4.class)
    public class LoginActivityTest {

        @Rule
        public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

        @Test
        public void testSomething() throws Exception {
            // test code...
        }
    }

```

> Check: There are two other important annotations: @Before and @After. What do you think they do?

The @Before and @After annotations denote methods that should be run before and after each test method, respectively.

For instance, if you had both types of methods in your class, it would call the Before methods, then run a test, then the After methods. Then it calls the Before method, then the next test, and so on.

You use these methods to setup and tear down the states of the tests, ensuring that you have control over how they run. In a teardown, for instance, you probably want to sign out of the app so future tests that login don't fail.

To add these methods easily, you can right click the class, click _Generate..._, and then click _SetUp Method_ or _TearDown Method_.

```java

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {


    }

```

## Demo: Write Some Tests (15 mins)

Alright, let's import the [starter-code](starter-code). In it, we will have two edit texts, one text view, and a button.

This app adds two numbers together.

Let's make a test that ensures the add button works.

First, launch the app like normal, then go to "Run" then "Record Espresso Tests" to open up the test recorder.

Perform any actions you need, and when ready, click "Add Assertion" in the recorder window. Choose what UI property you want to assert, and then save it. This creates a single test case in your UI test cases. We will review the generated code soon.

Unfortunately, the test recorder isn't perfect and often requires some cleanup after it is done, but in the end it will save you time over writing the tests manually.

For instance, the recorder seems to add `childAtPosition` on some assertions which don't require them, causing them to fail. Simply delete them and the tests should pass again.


## Guided Practice: Making Tests do "Stuff" (20 mins)

#### Running tests

To run a test, all you have to do it right click the class and click "Run 'Test'".

#### The Goal


The goal of a UI test is to ensure that the app works as expected, visually. Unlike unit tests, you should only care about what's on screen.

These automated tests emulate the user. If a user is testing your app, they don't care how the classes work, but only if the app visually represent what they expect.

#### The language of Espresso

There are four main components to Espresso:

1. Espresso - Starting point that allows you to select basic Views (`onView`, `onData`) and press buttons such as the back button
2. ViewMatchers - allows you to pass one of these to the view selectors to specify which view you're talking about
3. ViewActions - Allows you to do things like type and click
4. ViewAssertions - matches the view against a certain condition to check that the view is what you expect

Espresso was developed to make testing easier. Every line of code that tests a UI feature can be read in plain English. It's not perfect, but it's fairly easy to understand what's going on.

The structure of a UI test is as follows:

- On a view that matches some condition, perform an action on it and/or check if it matches some visual condition.


```java
    onView(withId(R.id.sign_in_button))
        .perform(click())
        .check(matches(isDisplayed()));
```

"On a view with the id "_R.id.sign_in_button_", click it, and then check if it's visible."


#### On view, with...

OnView is much like `findViewbyId`, in which they both reference a view on the screen. However, `onView` does not return a view; it returns a `ViewInteraction`. ViewInteractions allow Espresso to perform actions on a view, or to assert that it meets expectations.

The method takes one parameter; a Matcher. This tells the class what you want to interact with in the view hierarchy. Usually, `withId()` is the easiest way of going about this. However, if you are trying to access a view without an ID, you'll have to find other ways to match it.


* withId()
* withText()
* withHint()
* withContentDescription()

#### Perform an action

Once you have a ViewInteraction, assuming that it didn't fail, you can perform an action on it.

**Note**: Some actions cannot be done on certain views (i.e., you can't type text into an ImageView).

To perform an action, you have to call ViewInteraction's `perform`:

```java
    onView(withId(R.id.sign_in_button))
        .perform( /* some action */ );
```

The perform method takes in an array (comma-separated [varargs](https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html)) of `ViewAction`s. These are actions that will be done to the matched view, sequentially.



Here's a list of commonly-used ViewActions:

* click()
* clearText()
* typeText()
* closeSoftKeyboard()
* doubleClick()
* longClick()
* pressBack()
* scrollTo()
* swipeRight(), swipeLeft(), swipeUp(), swipeDown()

And to make the code above work:

```java
    onView(withId(R.id.sign_in_button))
        .perform(click());

    onView(withId(R.id.email_edittext))
        .perform(clearText(), typeText(), closeKeyboard(), swipeRight());
```

#### Assert yourself

The other main thing you can do with a ViewInteraction is to check a given assertion on the view.

The method is `check()`, and it takes in one ViewAssertion:

```java
    onView(withId(R.id.sign_in_button))
        .check( /* some assertion */ );
```

There are two methods that return ViewAssertions. The first being `matches()`, which checks if the view matches the given matchers. If it does, nothing happens. If it fails, it throws an `AssertionFailedError`. If this error is uncaught, it ends the current tests and starts the next one (if any).

Here's how you match if a view is currently displayed:


```java
    onView(withId(R.id.sign_in_button))
        .check(matches(isDisplayed()));
```


Here's a list of common parameters for matches():

* isDisplayed()
* isEnabled()
* isChecked()
* withText()
* hasErrorText()
* isRoot()
* isDisplayedAtLeast(int percent)

Note: You can also negate any matchers with the `not()` method:

```java
    onView(withId(R.id.sign_in_button))
        .check(matches(not(isDisplayed())));
```


The other method that returns a ViewAssertion is `doesNotExist()`, which asserts that a view is not in the current hierarchy.

```java
    onView(withId(R.id.sign_in_button))
        .check(doesNotExist());
```

## Introduction: Note about Collection Views (5 mins)

The process is a bit different for views that use adapters, like ListView. You can't just say `onView(withId(R.id.someId))`, because the adapter is reusing the same layout, so multiples of that view will probably be on the screen.

The way around this is `onData()` instead of `onView()`. `onData()` looks through the data inside the adapter and grabs a ViewInteraction based on what you find.

Conceptually, this shouldn't be difficult to grasp. However, the execution of it is not very simple. Meaning, it can't fit into this lesson due to the time it takes to implement.

However, [An Introduction to Espresso](https://androidresearch.wordpress.com/2015/04/04/an-introduction-to-espresso/) explains the process pretty well, and should be a good starting point.

## Independent Practice: Write Some Tests! (15 mins)

With the same starter code, work with the person next to you and write tests to check if the following user stories are met:

* As a user, I can see the answer text view, two edit texts, and an Add button
* As a user, I should see an error that says "Missing value!" when a number was not input.
* As a user, when I add the numbers _123_ and _456_, then the answer text view should read _$789_.
  * This test should fail.


## Conclusion (5 mins)

- Describe the difference between UI and unit testing.
- Identify the general steps needed to write a UI test for your app.

#### Resources

- [An Introduction to Espresso](https://androidresearch.wordpress.com/2015/04/04/an-introduction-to-espresso/)
- [Espresso Documentation](https://google.github.io/android-testing-support-library/docs/espresso/index.html)
- [Espresso with RecyclerViews (near the bottom of the article)](https://androidresearch.wordpress.com/2015/04/04/an-introduction-to-espresso/)
- [Espresso Cheat Sheet](https://google.github.io/android-testing-support-library/docs/espresso/cheatsheet/index.html)
