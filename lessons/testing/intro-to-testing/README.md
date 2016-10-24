---
title: Introduction to Testing
type: lesson
duration: "1:00"
creator: James Davis (NYC)
---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 10 min  | [Introduction](#introduction-what-is-testing-15-mins)  | What is testing? |
| 15 min  | [Demo](#demo-test-cases-and-user-stories-15-mins)  | Test Cases and User Stories |
| 5 min  | [Guided Practice](#guided-practice-lets-make-test-cases-10-mins)  | Let's make test cases |
| 5 min  | [Introduction](#introduction-performing-a-test-10-mins)  | Performing a test |
| 10 min  | [Guided Practice](#guided-practice-perform-a-test-on-our-house-15-mins)  | Perform a test on our House |
| 10 min  | [Independent Practice](#independent-practice-20-mins)  |   |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Introduction to Testing


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Explain why testing is important for the development of an application
* Create user stories and test cases for an application
* Perform tests

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- n/a

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
* Ensure students have Excel or are familiar with Google Sheets

---

## Introduction: What is testing? (10 mins)

Testing is the process of making sure your app works properly, from preventing crashing to ensuring that all the features are implemented properly.

The people in charge of testing are developers, quality assurance engineers (QA), and the users of your app. This is in order of stakeholder happiness.

*Stakeholders* are people or organizations who are actively involved in a project, or somehow affected by the project's progress. They include project managers, owners, people who invested money into your app or company, etc.

#### Happy Stakeholder

Stakeholders are the happiest when they don't know something was broken. That's where the developers come in. Through testing their app as early as possible, developers are able to find issues with the app and fix them before anyone knows about it.

In the worst case, if a dev finds an issue but cannot fix it right away, they can notify the QA engineers of the known issue. Although it's not the best case scenario, saying "I'm aware of this issue" is a lot better than hearing "How did you miss this issue?!"

#### Somewhat Happy Stakeholder

Developers will miss issues sometimes. It happens!

That is why a lot of companies have a QA department; a team of people who test your app constantly, dedicated to finding this issues and informing the team. The developer then fixes the issues.

This is still a good situation, somewhat. Catching issues before the public sees them is always good. However, if the QA team finds a bunch of issues, this may affect the project and, generally, worry the other stakeholders. A project manager, for instance, may have to delay the release of an app to give you time to fix the issues, which may cost the project time, energy, and money.

#### Upset Stakeholder

QA teams will miss issues sometimes. It happens!

This is where the user comes in. Usually, at this stage, the issues missed are small and do not break the app. So, things aren't so bad.

However, the user is the most important stakeholder. If something huge is wrong with your app, that could have been prevented, they will tell you...and they will tell everyone around them. The last thing you would want is a low rating in the Play Store.

This is why developers and quality assurance engineers test the app early and often: To help keep the users as happy as possible.

## Demo: Test Cases and User Stories (15 mins)

A **Test Case** is a set of conditions that confirms if a feature is working as expected. If all of the conditions are true, then the feature is functional.

For instance, if you added the ability to login to your app, it would be something like the following:

**Login Test Case**
*The feature is implemented if the following conditions are true:*

1. The user can login successfully
2. An error message is shown when the user inputs incorrect credentials
3. The user can retrieve their password if they forgot it
4. The user is able to sign in as a guest

> Check: What do all of these have in common?

All of these mention the user and focus on what the user can do with that feature. In the end, the users should be the main concern for all of your apps.

#### User Stories

Again, users are the most important stakeholders for your apps. It only makes sense to center your app features around them. So, there's the concept of **User Stories** - a short statement that defines a feature from the user's perspective.

Here are a few examples of user stories for Twitter:

* As a user, I can write and post 140-character tweets.
* As a user, I can view other peoples' tweets.
* As a user, I can follow other people and be notified when they tweet.

They are usually concise, one-sentence statements formatted as "As a _____, I can _____."

> Check: Why do you think the format is important?

This format puts you in the user's shoes. It keeps you focused on their needs.

> Check: Why are they concise?

They are concise for a few reasons:

* It ensures that a user story is direct about its needs
* Easier to read
* It keeps the requirements simple

When writing User Stories, using the one-sentence template above, the term "user" can be replaced with the following:

- **Member** - if your site/app has authentication, a "member" is typically a user that has an account; ex: "As a member, I can change my preferred credit card."
- **Admin** - an "admin" is someone who has edit access to pages or user information; ex: "As an admin, I can edit the 'About Us' section"


## Guided Practice: Let's make test cases (5 mins)

Test cases can be applied to anything, and in general, they should be associated with features.

To prove that point, let's build a house! This house has three features: a bedroom, a bathroom, and a kitchen.

1. First, let's open a Google Sheet or an Excel tab write/type the names of the test cases in columns

	* Bedroom Test Case, Bathroom Test Case, Kitchen Test Case

2. Let's discuss: What requirements are needed for each room. Put them in the appropriate columns?

	* e.g., the bedroom needs to be big enough to fit a bed, the bathroom needs a toilet and bathtub, etc.

3. Now, take one minute to reword the requirements as user stories, so they relate to the "user"

	* e.g., the user needs to be able to take a shower, the user should be able to cook food, the user can sleep in a bed

When you're finished make sure you have this doc handy. These test cases will be used for the next guided practice.

## Introduction: Performing a test (5 mins)

Performing a test is straight forward: All you have to do is look at the conditions of a test case and check if the test case's **assertions** are true.

To **assert** something is to state that something is true.

Example: The Login screen

- **Condition**: The user can login successfully
- **Assertion**: After entering their username and password, the user will be logged in and looking at the home page

> Check: Show the Login Test Case. What assertions can be made from other conditionals?

To perform this test condition, you would attempt to login and check if the assertion is true. If it, for instance, brought you to the forget password screen when the condition asserted that you would see the home page, the test would fail.

A test case's condition can also make multiple assertions, if necessary.

Example: The Login screen

- **Condition**: The user is able to sign in as a guest
- **Assertion 1**: After clicking the "Sign in as Guest" button, the user will looking at the home page
- **Assertion 2**: On the home page, the user name should say "Guest"
- **Assertion 3**: A "Login" button is visible

## Guided Practice: Perform a test on our House (10 mins)

> Instructor note: Go back to the user stories the students made in the previous examples, and come up with assertions

> Draw house floor plans on the board (at least two). Go through each test case and conditional with the students, checking off the ones that pass.

> Provide a small studio apartment floor plan (one room and a bathroom). The main room will be just big enough to fit a twin-sized bed and a stove (not much else), and the bedroom can fit just a toilet, sink, and a small shower. Technically, although it looks like it would not pass, it passes the house test.

> With the students taking more control, ask them to perform the test on the small studio apartment.


## Independent Practice (10 mins)

> ***Note:*** _This is a pair programming activity._

In the previous examples, we tested if a house was indeed a house. On the whiteboard, you will create test cases, user stories, and conditionals for an object of your choice.

Examples: Car, Cell Phone, Television, Laptop, app of your choice etc.

Team up and do the following:

* Create at least 3 test cases that define the main features of the thing
* Create user stories for the test cases
* List the conditionals for each test case

> Check: Ask a couple of the teams to come up and share their test cases. Ask the class what they liked, and what they would change.


## Conclusion (5 mins)

* What is a test case?
* What is a user story?
* Why is testing a feature important?
* Predict: What do you think "Test-Driven Development" means?
