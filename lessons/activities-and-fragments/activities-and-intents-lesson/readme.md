---
title: Activities and Intents
type: lesson
duration: "2:05"
creator:
  name: James Davis
  city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Activities and Intents

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Define what an Activity is
* Understand the components of the Manifest
* Given a running application, identify the activities in that application
* Identify the same activities in the app manifest
* Use Intents to move between Activities
* Pass data between activities

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create an activity
- Use nested layouts to create more complicated views
- Explain view recycling and why it matters

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written
- **Note**: With the addition of `startActivityForResult`, this lesson is unusually long. Consider giving the students a break mid-way through.


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-what-is-an-activity-what-is-a-manifest-10-mins)  | What is an Activity? What is a Manifest? |
| 15 min  | [Demo](#demo-creating-activities-15-mins)  | Creating Activities |
| 10 min  | [Introduction](#introduction-what-are-intents-10-mins)  | What are Intents? |
| 10 min  | [Demo](#demo-starting-an-activity-with-an-intent-10-mins)  | Starting an activity with an Intent |
| 10 min  | [Introduction](#introduction-sending-data-from-one-activity-to-another-activity-10-mins)  | Sending data from one Activity to another Activity |
| 15 min  | [Guided Practice](#guided-practice-sending-data-between-activities-15-mins)  | Sending Data between Activities |
| 20 min  | [Demo](#demo-passing-data-back-in-the-result-20-mins)  | Passing data back in the result |
| 10 min  | [Independent Practice](#independent-practice-startactivityforresult-10-mins)  | startActivityForResult |

## Opening (5 mins)

Previously, we learned about the UI elements that make up a screen in an app, and how we interact with it in the Java code. Notice how the file was called MainActivity.java? Most of the time, you can think of an Activity as a screen of your app - that's all!

> Check: If Activities are screens, why do you think they are called "Activities"?


## Introduction: What is an Activity? What is a Manifest? (10 mins)

The definition of an activity is something that is done for a particular purpose.

Think about the activity that the user is doing on a screen. If you are looking at a screen whose purpose is to log in the user, for example, it should be called the Login Activity. If the activity shows a user's social network profile , it should be called the User Profile Activity.

Let's add a new Activity to this app. Right click on the folder where you want to put the activity, then go to *New* > *Activity*, and then click on the type of base activity you want (usually, *Empty Activity* is what you want if you want to build it from scratch).

An Activity is a plain ol' Java class, so you already know how to add it to a project.

Doing this also adds the Activity to the Android Manifest.

> Check: So what is an activity again?

#### What is a Manifest?

The dictionary defines a ship's manifest to be "a document giving comprehensive details of a ship and its cargo and other contents, passengers, and crew for the use of customs officers."

The ship, in our case, is the app you are building.

The Android Manifest xml file presents important information about your app to the Android system. If something isn't defined in the manifest, then the system just ignores it.

Notably, the manifest is known for describing the main components of your app; the Activities, Services, Content Providers, etc. It is also the place to define permissions (e.g., giving your app permission to access the internet or to access a device's camera).

Whenever you create a new Activity through the New Activity menu, Android Studio will automatically add it to the manifest.

> Check: How do activities relate to the manifest?

## Demo: Creating Activities (15 mins)

In this demo, let's walk through the following:

* Creating a new project in Android Studio
* Examining the manifest file, describing components like the XML elements, attributes, and package
* Describe what a launcher activity is (The activity that opens when the app is launched), and make comparisons to Java's *public static void main* method
* Add 2 more activities to the project, and go back to the manifest and see them added

> Instructor Note: A complete example of this is found in the [solution code folder](solution-code).

> Check: Take 2 minutes, with the person next to you, and discuss what a launcher activity is, and how it compares to public static void main. Be ready to share out!


## Introduction: What are Intents? (10 mins)

Intent, as defined in the dictionary, means: purpose, goal, objective. *Something intends to do some goal*.

This translates to your app and activities; every activity has a goal.

For example, a `ComposeEmailActivity` allows the user to compose and send an email. If you click a "compose new email" button, you are actively saying "I intend to compose an email".

This is the idea behind Intents in Android. Intents are messages you send between app components, like Activities, usually with the goal of doing something.

> Check: So, imagine you are in your app's `EmailListActivity`, and you click on one of your emails. In plain ol' English, could you describe what is happening between the user and the EmailListActivity? Take 10 seconds to think about it.

The following "dialogue" is happening:

- EmailListActivity: "Hey, you clicked one of your emails. What's up?"
- You: "I intend on reading that email. Is that okay?"
- EmailListActivity: "Yeah, sure! I'll start the ReadEmailActivity now."
- You: "Thank you."

Let's create an EmailListActivity and a ComposeEmailActivity.

So, how does an Intent look like in code?

```java

	Intent intent = new Intent(EmailListActivity.this, ComposeEmailActivity.class);
	startActivity(intent);

```

You create a new Intent object, and you pass it two parameters: The activity you are currently in, and the class of the activity you intend to start. The code snippet above could be read as, *From the Email List Activity, please start the Compose Email Activity*.

The method, `startActivity()`, starts the intended activity immediately.

> Check: What two parameters should you pass your Intent objects?

## Independent Practice: Starting an activity with an Intent (10 mins)

Using the code from the previous demo, add a button to the app's main activity. Set an `onClickListener` to that button and have the listener start one of the other activities. Run the app in a virtual device, and click on the button to start the new activity.

Note: A complete example of this is found in the [solution code folder](solution-code).

## Introduction: Sending data from one Activity to another Activity (10 mins)

Intents are how Activities communicate with each other. In the previous example, we started an activity to compose an email by clicking an email in the list. However, how does the ReadEmailActivity know what email to show?

> Check: Take 30 seconds to talk with the person next to you about this question.

When you start a new activity, it is shown with the default settings that you give it. However, some activities need to receive a bit more information. This info is sent from the original activity to the one you are starting.

> Let's rename our Activities to match the email example

When creating new intents, you can also give it *extra* data. Here's an example:

```java

	Intent intent = new Intent(EmailListActivity.this, ReadEmailActivity.class);
	intent.putExtra("ID", 123);
	intent.putExtra("SENDER", "John Smith");
	startActivity(Intent);

```

> Check: Take 20 seconds to study the code and come up with an explanation, in English, about what's happening. Be ready to share!

The Intent class has a handful of helper methods you can call to get and store extra data. The main one is `putExtra()`, which takes two parameters: a String that gives the data a name, and the data itself.

With `intent.putExtra()`, you can put data inside the intent (including Strings, numbers, booleans, certain objects).

Once you start a new activity, you can retrieve the Intent and get the sent data, as follows:

```java

	// get the intent that started this activity
	Intent intent = getIntent();

	// get the data from the intent
	int id = intent.getIntExtra("ID", 0);
	String sender = intent.getStringExtra("SENDER");

```

Again, the Intent class has a handful of getters for extra data, usually formatted like *get_____Extra*. Examples, `getIntExtra()`, `getStringExtra()`, `getBooleanExtra()`, etc.

Here we are hard-coding the Keys, what do you think we could do as an alternative?

**Note**: You should only send data if you need to do so. If the activity you are starting doesn't need extra data, you don't have to set it.

## Guided Practice: Sending Data between Activities (15 mins)

> Instructor Note: Show the class that getting data without setting it or with a type in the extra id would cause incorrect or null data. Then, after you introduce this exercise, be sure to stop the class after each step and reveal the answer.

With the person next to you, go ahead and start a new Android project with a empty main activity. Do the following:

- Add a new Activity, and call it `EchoActivity`.
- In `MainActivity`, add an `EditText` and a Button. In the `EchoActivity`, it will just have a `TextView`.
- In Java, set an `onClickListener` to the button and make it start the `EchoActivity`. The value of the `EditText` is passed in the intent.
- In the `EchoActivity`, the value is plucked from the intent and put in the TextView.

#### Independent Practice: Add two numbers (15 mins)

> This should be done as a pair programming exercise.

Now, with the person next to you, without stopping every two minutes, do the following:

* Create a new project, with a blank main Activity
* Create a new activity, call it SolutionActivity
* In the main activity, put two EditTexts and one button in the layout. The button's text will say "Add"
* In the solution activity, just have one TextView
* When the button is pressed, it takes the two values and sends them to the solution activity, where the sum of the two numbers are shown. Add the two numbers in the SolutionActivity.

## Demo: Passing data back in the result (20 mins)

Passing data works in both directions, and you can receive data when returning from an Activity you previously started. For example, if you start SecondActivity from MainActivity, you can get data back from SecondActivity when it closes.

Returning data from an Activity only requires a few additions to your code.

This can be broken down into changes in your calling Activity (the one you are starting the second activity from), and changes in your secondary Activity.

Open the Starter-Code and follow along.

#### Second Activity

First, let's look at the second Activity, or the one you are passing the data back from. In this Activity, we press a button, and it passes the values from the two EditTexts back to the Main Activity.

> Check: How do you think we are going to pass data from the second activity to the first when clicking the button? Share out!

Just like when we're starting an Activity, we also pass data back using an Intent and extras.

```java
mButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    Intent resultIntent = new Intent();
    resultIntent.putExtra("first",mFirstNameText.getText().toString());
    resultIntent.putExtra("last",mLastNameText.getText().toString());

    setResult(RESULT_OK,resultIntent);
    finish();
}
});
```

First we create an intent, then put the two Strings in as extras. The next two lines of code are new, though.

- **setResult**: This method takes two parameters. The first is a value that lets our first Activity know that everything went well, and that this Activity finished correctly. The second parameter is simply an Intent holding the data we want to pass back.
- **finish**: This method closes the current Activity and returns to the previous one.

#### Main Activity

Now that we've finished the Second Activity, let's return to the Main Activity. We have two steps to complete.

> Check: What are they? You know this by now.

We need to start the Second Activity and get the results from the Second Activity.

Starting the Activity is almost identical to how we previously did it, with one exception:

```java
Intent intent = new Intent(MainActivity.this,SecondActivity.class);
startActivityForResult(intent,NAME_REQUEST);
```

Notice the `startActivityForResult` method. The first parameter is a normal Intent, but the second is a variable telling the system what we are asking for (we will use this in a minute). We need to add that variable at the top of the Activity.

```java
private static final int NAME_REQUEST = 20;
```

You can assign any integer value that is **greater than 0**.

Next, we have to get the results from the Second Activity. Whenever you return from an Activity that is expecting results, the `onActivityResult` is automatically called.

> Check: Give the students 2 minutes to discuss what data they think will be returned to us based on what was passed into the second activity and what was returned in the result after pressing the button.

```java
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// Check what request we're responding to...
	if (requestCode == NAME_REQUEST) {
	    // Make sure the request was successful...
	    if (resultCode == RESULT_OK) {
	        String firstName = data.getStringExtra("first");
	        String lastName = data.getStringExtra("last");
	        mText.setText(firstName+" "+lastName);
	    }
	}
}
```

The first parameter is the static variable we passed in when starting the activity, in our case `NAME_REQUEST`. The second parameter is the result status, in our case `RESULT_OK`. The final parameter is the Intent we passed back containing the data.

Since we could be starting different Activities from our Main Activity, we first have to check that our result is coming from the `NAME_REQUEST` activity, then we have to check to make sure the results are valid. After that, we can retrieve the data like normal and use it however we want.

> Check: What are the key differences between how we started activities before and what we just did?

## Independent Practice: startActivityForResult (10 mins)

**Do this activity with a partner**

Instead of passing values from the first activity to the second, we are going to pass the data back from the second activity to the first.

If the user chooses add, they are taken to a calculate activity with two EditTexts where they type 2 numbers, and a calculate button. The sum of the numbers from the calculate activities is displayed on the main activity after pressing the calculate button.

**Bonus:**

If the user chooses subtract, the same steps occur, except the difference is displayed in the main activity.

> Check: Let's take 2 minutes to review the answer. Were all students able to complete the activity successfully? If not, where did you get stuck?

#### Conclusion (5 mins)

- What is an activity?
- What is an intent?
- How do we start an activity?
- How do we send data from one activity to another?
- How do we receive data when returning from an activity?

## Additional Resources

* Android Developer | Starting Activities - http://developer.android.com/guide/components/activities.html#StartingAnActivity
* Android Developer | Intents - http://developer.android.com/guide/components/intents-filters.html
