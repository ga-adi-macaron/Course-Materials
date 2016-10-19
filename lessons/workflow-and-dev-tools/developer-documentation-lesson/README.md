---
title: Using Developer Documentation
type: lesson
duration: "1:30"
created by: James Traver (CHI)
updated by: Charlie Drews (NYC)
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Using Developer Documentation

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Identify an error in an application
- Research the causes of those errors using developer documentation
- Rely on developer documentation to learn something new
- Find reputable sources of information online other than official documentation

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Open an Android application in Android Studio
- Run an app on an emulator or physical device
- Use logcat to view runtime error messages

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and review the many intentional errors the students will need to investigate
- Read and run the solution code to ensure it's working and that you agree with how the code was written

## Opening (5 mins)

#### Story of the re-usable rocket

> Instructor Note: It is recommended to have students pair up for this lesson. By pairing students together, they will see that other students have the same problems that they have. If your cohort shows signs of frustration from errors, it is recommended to encourage them that everyone has problems and even demonstrate an error or two that you ran into when you started developing. Feel free to replace any examples here with examples that you can personally identify with for cohort-to-cohort consistency.

At this point in your journey to become an Android developer, you have likely run into a problem -- or **exception**. You may be familiar with a variety of these such as `IOException`, `ClassNotFoundException`, or `NullPointerException`. We're going to look into exceptions this morning and find out how to resolve them. To do that, we're going to use **Developer Documentation**.

When Space-X designed their re-usable rocket for shipments to the international space station their engineers had to read hardware and software documentation to master their craft and build a safe and re-usable rocket. What if something went wrong during lift off? What if the rocket failed to land successfully (which it did on multiple occasions)? Space X's engineers needed to look through their error logs and then research causes to problems they found in documentation. As a developer, when you run into a problem you can use _developer documentation_ to properly understand errors and the correct way to resolve them. However, sometimes documentation can be confusing - especially when you are new to something.

> Instructor Note: ask students to brainstorm different types and sources of documentation. List them on the board. Possibilities include:
> - developer.android.com
> - StackOverflow
> - error messages in Android Studio
> - comments in source code in Android Studio (show students command + click)

## Introduction: What Errors Have You Hit? (10 mins)

> Instructor Note: It is recommended to take 5-10 minutes here to discuss how errors are handled on the job. This will help students see a real-world example of why documentation is important. Remember that students are new developers and may not have been exposed to any programming before this so keep terminology and problems simple.

> Check:  What do you do right now when you run into an error? (2 minutes)

> Check:  What is the most confusing source of information you've seen? (2 minutes)

#### Here's what you'll learn

Today's lesson will show you how identify problems in your applications. Once we identify them together, you'll learn how to read documentation and sift through the mountains of search results that you'll find on your own. At the end of this lesson, you will have seen how to use documentation, we'll have done so together, and you'll have learned to read data from Files thanks to developer documentation that already exists.

## Demo: Let's look at a broken app (15 mins)

Let's take a look at a basic Android application. Open the starter-code folder for this lesson in Android Studio. Let's run the app and see if we run into any errors.

```
.../starter-code/app/src/main/java/com/charlesdrews/documentationlesson/MainActivity.java
Error:(35, 17) error: cannot find symbol variable text
```

Oh no! We have a problem! What ever will we do? What would you do if you ran into this problem? Has anyone ran into this exact problem yet? Let's break this message down together. The compiler is telling us that there is a problem and it is doing the best job that it can to tell us in English.

First, we are told that in `MainActivity.java` on line 35, starting at character 17 of the line, we have an `error`. Yeah, we get that, Java; thanks. Java is telling us that it `cannot find symbol`. So it cannot find something called a symbol. I'm not entirely sure what that is. Wouldn't it be great if I had **developer documentation** to help me out? I guess I'll just have to look for some help online...

> Instructor Note: Search for 'cannot find symbol' and show the results (or use the result below). Read [the question](http://stackoverflow.com/questions/25706216/what-does-a-cannot-find-symbol-compilation-error-mean) that was asked on Stack overflow. Explain to students that there are open and closed communities where other developers can ask for help and receive it for free. Mention that STACK OVERFLOW is one such site.

This Stack Overflow website is one of the most popular websites on the internet for developers to ask for help. It looks like other people have had the same problem! That makes me feel a little bit better about this already. Stack Overflow allows a lot of people to ask questions and then provide answers. There could be many answers for a particular question. The community then votes for the best answer. After reading that person's question, I can't wait to read the answers!

> Instructor Note: Read the accepted answer and explain it 'in English' to students.

Based on what I've read here, it looks like my app failed to compile because I didn't declare the variable `text`. But didn't I declare that up on line 22? Why can't the program recognize it here?

> Instructor Note: Ask students to answer this question. Make sure everyone understands that a local variable in one on-click listener is **out of scope** from the perspective of a different on-click listener.

Right, I declared `text` in the `OnClickListener` for `firstButton`, so it is NOT in scope in the `OnClickListener` for `secondButton`. Let's move the declaration up into `onCreate` so it's in scope for both `OnClickListener`s. Note the Android Studio error message which says `text` must be declared `final` in order to be accessed from within an inner class.

```java
	protected void onCreate(Bundle savedInstanceState) {
		final EditText text = (EditText) findViewById(R.id.text);
        Button firstButton = (Button) findViewById(R.id.button1);
	}
```

Let's compile and run. Nice! So using _developer documentation_, in this case both StackOverflow and Android Studio error messages, I am able to find answers to problems that I run into. The entire internet can contribute to answers. You should, too.

> Instructor Note: Point out that "accepted" answers on StackOverflow are selected by the user that posted the question, and NOT by a panel of experts. There is no guarantee that an "accepted" answer, or any other answer, is correct. Students must carefully read SO answers and be sure they make sense!

## Guided Practice: Let's research and fix the remaining errors (20 mins)

Let's work through the remaining errors in the starter code one by one, using developer documentation to guide us.

> Have students find and fix the remaining errors in small groups, then go through them as a class. Use the solution code as needed.

## Independent Practice: Let's learn something new (30 min)

**Alert Dialogs** are a very handy tool in Android apps. They function like popups on a website - they display over the current activity, partially obscuring it, and they typically include buttons like "Cancel" or "OK" to close the dialog and/or complete an action.

Take some time to read through the official documentation for Alert Dialogs on the Android developer site, focusing on the "Building an Alert Dialog" section: https://developer.android.com/guide/topics/ui/dialogs.html#AlertDialog

> Instructor Note: This should be performed independently by students; it is a good idea to touch on each Learning Objective right before explaining each step.

#### Task: Launch an alert dialog

1. Add a third button to MainActivity
2. Create an on-click listener for your new button, and launch your alert dialog from within the `onClick()` method
3. Set a title and message for your alert dialog
4. Set positive and negative buttons, and show a Toast message when each one is clicked
5. Don't forget to call the `show()` method on your instance of `AlertDialog` to make it appear to the user

##### Solution

```java
Button thirdButton = (Button) findViewById(R.id.button3);
thirdButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Here is my title")
                .setMessage("Here is my message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "you clicked OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "you clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
});
```

> Check: Write and walk through the code that students should have completed during their independent practice. If students are confused, explain that many of their answers can be found in developer documentation. Everyone will find documentation that they like (nobody likes the same flavor of pancakes).

## Conclusion (5 mins)

- Why is it important to learn to use documentation?
- How is StackOverflow different than the official documentation?
