---
title: Unit Testing
type: lesson
duration: "1:20"
creator: James Davis (NYC)

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Unit testing | Introduction to JUnit

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Add unit tests to an Android Studio project
* Given a class, add conditional methods to a test case
* Perform a unit test with JUnit

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Review the [Intro to testing](../intro-to-testing) lesson

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 10 min  | [Opening](#opening-man-vs-machine-10-minutes)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction-unit-tests-5-mins)  | Unit tests |
| 20 min  | [Demo](#demo-creating-a-unit-test-in-android-studio-20-mins)  | Creating a Unit Test in Android Studio |
| 40 min  | [Independent Practice](#independent-practice-automated-testing-40-minutes)  | Automated testing |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening: Man vs. Machine (10 minutes)

In the [previous lesson](../intro-to-testing), we outlined ways to test something (whether it be a house or an app).
We did this by hand, which is fine. A lot of QA teams test apps by hand.
However, this could get tedious.
Mainly, because they usually have to test the full feature once one small thing changes.

Bringing back the house example, let's say you (the inspector) have to test if a bedroom is indeed a bedroom.
The room must have at least a bed, a dresser, a closet.
Let's also say a interior designer walks in and adds a lamp to the dresser.
Then, you have to go back to the room and check if the dresser, bed, and closet are still there.

Now, the designer added a rug.
So, you have to check again if the bed, dresser, and closet are still there.

Every time something changes, you have to ensure the thing you are checking does what it is required to do.
This can be repetitive, and in some cases a waste of time.

> Check: Take 20 seconds and discuss with the person next to you - what are some ways to prevent this? Share out!

There are a few ways to tackle this problem.
They way we will talk about today is automation!

Think about the previous example.
Now imagine, instead of yourself, you built a robot to inspect the house for you.
So, every time the designer changed something in the house, the robot would inspect the room for you! And while that's happening, you are on vacation in some remote, tropical place.

This is the difference between manual and automated testing.
You code tests to religiously check your code for defects while you and the QA team have more time to do other things.

## Introduction: Unit tests (5 mins)

There are two types of automated tests: Unit tests and UI tests.

> Check: Predict the difference.

Unit tests check if the code logic is correct, and UI tests check if the elements on the screen work as expected.
We'll talk more about UI tests in a future lesson.
This lesson will focus on Unit tests.

#### What is a Unit test?

A Unit Test is one that tests a piece of code (a unit).
A unit, in most cases, is a _method_.

So, think of a unit test as checking "Are this class and its methods working as expected?"

## Demo: Creating a Unit Test in Android Studio (20 mins)

Follow along, if you'd like!

To do test our classes & methods, we create test classes that test other classes.

Create a new Android Studio project.
In the **src** folder, you will find three folders:

* **main** - the location of your app's main code (classes, activities, resources, etc.)
* **androidTest** - the location of tests for Android-related things (much like UI stuff)
* **test** - the location of non-Android tests

The **test** folder is where we'll add new test classes.

First, let's create a Student class, which has the methods `getFullName` and `getLetterGrade`.
The constructor takes a first name, last name, and number grade.

Create a new test in the src/test package, call it `StudentTest`.

We know that the Student class has three methods.
The idea is to have methods in the Test that implement the class being tested and asserting that their methods are working.

In the `StudentTest` class, add methods that test if the `getFullName` and `getLetterGrade` methods are correct.
Make sure to add the `@Test` annotation, or else JUnit doesn't recognize it.

```java
package co.ga.junittesting;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testIfFullNameIsCorrect() {

    }

		@Test
    public void testIfLetterGradeIsCorrect() {

    }
}
```

To assert thing, you would use JUnit's `assert_____()` static methods. The main ones are:

```java
		assertEquals(4, 2 + 2);
		assertTrue(true);
    assertFalse(false);
    assertNull(null);
    assertNotNull("Not null");
```

Each of these take an *expected value* and an *actual value*.
The expected value is what you think the method should return, and the actual is what the method actually returns.

So, filling out the rest of the class:

```java
package co.ga.junittesting;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testIfFullNameIsCorrect() {
				Student student = new Student("Leslie", "Knope", 93);

				String expected = "Leslie Knope";
				String actual = student.getFullName();

				assertEquals(expected, actual);
    }

		@Test
    public void testIfLetterGradeIsCorrect() {
				Student student = new Student("Charlie", "Brown", 76);

				String expected = "C";
				String actual = student.getLetterGrade();

				assertEquals(expected, actual);
    }
}
```

To run the test, you right click on the class in the Project View and click "Run StudentTest".

> Check: Were you able to click "Run StudentTest" and get the same output I did?

**Note**: If you write multiple test classes, you can right click on the folder that contains the classes and click "Run tests in ______" to run all of them!

## Independent Practice: Automated testing (40 minutes)

In the [starter code](starter-code), there is an Android Project. In it, you will be testing the MathUtils class. This class has a few bugs in it. You will have to test the following:

* `MathUtils.multiply(number1, number2, number3, etc.)` correctly multiplies the numbers you provide it
	* Test for both integer and decimal point numbers
* `MathUtils.add(number1, number2, number3, etc.)` correctly adds the numbers you provide it
	* Test for both integer and decimal point numbers
* `MathUtils.square(number)` correctly squares the numbers you provide it
	* Test for both integer and decimal point numbers
* `MathUtils.pythagorean(a, b)` correctly calculates the results of using a and b in Pythagorean theorem
	* Test for both integer and decimal point numbers

    _Note: Not every method will have errors._

> Check: With 5 minutes left, review the solution. Were students able to fix the errors they found in MathUtils?

## Conclusion (5 mins)

* What is the difference between a manual and an automated test?
* What is a unit test?
