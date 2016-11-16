---
title: Error Handling Lesson
duration: "0:55"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Error Handling with Try/Catch Blocks


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe an Exception
- Describe the purpose of try/catch blocks
- Implement try/catch blocks

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Write a Java function that iterates through data and implements control flow

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction-exception-5-mins)  | Exception |
| 10 min  | [Introduction](#introduction-trycatch-block-10-mins)  | Try/Catch Block |
| 10 min  | [Demo](#demo-arrayindexoutofboundsexception-10-mins)  | ArrayIndexOutOfBoundsException |
| 5 min  | [Guided Practice](#guided-practice-divide-by-zero-5-mins)  | Divide By Zero |
| 5 min  | [Introduction](#introduction-when-you-should-use-trycatch-blocks-5-mins)  | When you should use Try/Catch blocks |
| 10 min  | [Independent Practice](#independent-practice-file-reading-and-writing-10-mins)  | File Reading and Writing |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

We often check for code that could cause errors manually through conditional statements, but Java (as well as many other programming languages) provides a very useful tool called a Try/Catch block. This helps to not only shape the behavior of our apps if an error occurs, but also lets us stop our apps from completely crashing if an error-prone portion of code is used (such as file streaming or networking operations).

> Check: Ask the students if they have encountered any errors that have "exception" in the name.

***

<a name="introduction"></a>
## Introduction: Exception (5 mins)

Before we can start talking about the try/catch block, we need to talk about Exceptions. Exceptions are events that occur while a program is running that interrupts the normal flow of the code. These can be null pointer exceptions, divide by zero, array out of bounds, etc. You can see many of the built-in exceptions in the [Java documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html).

When an Exception occurs, we say that it is **thrown**. This will become important when we look at the Try/Catch blocks. While many parts of Java and Android throw exceptions on their own, you can also manually throw exceptions as well.

***

<a name="introduction"></a>
## Introduction: Try/Catch Block (10 mins)

Alone, exceptions aren't particularly useful, but when paired with a Try/Catch block, they become very important. A Try/Catch block looks like this:

```java
try {
  //Your code goes here
} catch(Exception e) {
  //Execute this code if an error occurs
  e.printStackTrace();
}
```

If you remember from earlier, we said that Exceptions are **thrown**. We also say that they are **caught** in the catch statement. `Exception` is the most generic type of Exception that all other exceptions are derived from, and you can catch multiple types of exceptions from a single block of code.

It is important to note that the code in the catch block is only executed if an Exception is thrown that matches the type of Exception declared.

> Check: Talk with the person next to you: Why would we want to be able to catch multiple types of exceptions?

***

<a name="demo"></a>
## Demo: ArrayIndexOutOfBoundsException (10 mins)

Let's take a look at a case where we try to access a value from an array with an index outside of its bounds. Open up the starter-code for ArrayOutOfBounds. As you can see, this app has an array of Strings and lets us type a number into the EditText to access the string at that index.

If we run the app and type in a number that is outside of the bounds of the array, we get an `ArrayIndexOutOfBoundsException`, and our app crashes! Instead of having the app crash, we can still log the error, but let the app handle the exception gracefully by letting the user know what they entered isn't valid.

Let's add a Try/Catch around the code that is causing the error.

> Check: Give the students 1 minute to discuss what code they think should be inside of the try block.

```java
try {
  int index = Integer.parseInt(mEditText.getText().toString());
  mTextView.setText("Name: " + mStringArray[index]);
} catch (ArrayIndexOutOfBoundsException e) {
  e.printStackTrace();
  Toast.makeText(MainActivity.this, "A name for that index doesn't exist", Toast.LENGTH_SHORT).show();
}
```

As you can see, the code that is causing the error is `mStringArray[index]`. By putting that inside of the Try block, we can catch the exception, and show a Toast message to the user. The app will continue running, but we know the error occurred.

> Check: Why didn't we put Exception instead of ArrayIndexOutOfBoundsException?

***

<a name="guided-practice"></a>
## Guided Practice: Divide By Zero (5 mins)

In this next example, we will be looking at an app that divides two numbers for us and displays the result. Open up the DivisionExample starter-code.

> Check: Give the students 2 minutes to look at the code and determine how we should complete the rest of the button logic to complete the division while checking for an exception to prevent dividing by 0.

```java
try {
    int result = numerator/divisor;
    mResultText.setText("Result: "+result);
} catch (ArithmeticException e) {
    Toast.makeText(MainActivity.this,"You can't divide by 0",Toast.LENGTH_LONG).show();
    e.printStackTrace();
}
```

We need to put the actual division operation in the try block because that's where the error is actually going to happen. In our catch block, we let the user know that they can't divide by 0.

> Check: Is it better to check for divide by 0 with an Exception or manually checking to see if the divisor is 0?

***

## Introduction: When you should use Try/Catch blocks (5 mins)

In most situations Try/Catch blocks are not mandatory, so using them is completely up to you. In fact, construction an `Exception` object as actually fairly _expensive_, meaning it is slow. For that reason, you shouldn't choose Try/Catch blocks when some other control flow statement would work.

There are, however, some circumstances where you are absolutely required to have Try/Catch blocks, such as File reading/writing and networking. In an upcoming lesson, we will be working with networking, but as a preview, lets look at a few lines of code that force us to use Try/Catch.

```java
URL url = new URL("http://www.google.com");
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
```

Android Studio will tell us there are two un-handled Exceptions, and it will try to reformat the code for us like this:

```java
URL url = null;
HttpURLConnection urlConnection = null;

try {
    url = new URL("http://www.google.com");
} catch (MalformedURLException e) {
    e.printStackTrace();
}

try {
    urlConnection = (HttpURLConnection) url.openConnection();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    urlConnection.disconnect();
}
```

We can consolidate the blocks like this:

```java
URL url = null;
HttpURLConnection urlConnection = null;

try {
    url = new URL("http://www.google.com");
    urlConnection = (HttpURLConnection) url.openConnection();
} catch (MalformedURLException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    urlConnection.disconnect();
}
```

You don't have to worry about forgetting to add Try/Catch blocks in mandatory places because Android Studio will let you know when it's required.

***

<a name="ind-practice"></a>
## Independent Practice: File Reading and Writing (10 mins)

Open the IndependentPractice starter-code. In this app, the user is able to type text into the EditText and press the Save button to save it to a file. When the app is opened, it attempts to read text from the file and put it in the EditText so the user can resume editing it.

With a partner, figure out where the Try/Catch blocks need to go and discuss why you think the code needs to be checked for an Exception.

> Check: Were students able to create the desired deliverable(s)? Did it meet all necessary requirements / constraints?

***

<a name="conclusion"></a>
## Conclusion (5 mins)

Exceptions are a very important part of keeping our apps running when problems occur. Sometimes, problems are out of our hands, such as certain file IO or networking situations, and we need to be prepared to handle those exceptions. Luckily, Android Studio does most of the work for us, and it's only up to us to decide what should happen if the exception is thrown and not worry about knowing when every type of exception might occur.

***

### ADDITIONAL RESOURCES
- [Try blocks](https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html)
- [Catch blocks](https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html)
