---
title: Whiteboard Practice
type: Morning exercise
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Whiteboard Practice

## Exercise

Team up in groups of 2 or 3 and take turns working on the following problems. Pretend you are in an interview setting:
- Keep talking!
- Ask questions (to the instructors, or to your teammates)
- Consider starting with an example, showing the expected outputs for sample inputs
- Consider writing pseudocode before Java to make your steps clear to both you and the interviewer

#### Requirements

Take turns working through these problems on the whiteboard. It's OK if you don't finish them all. Make as much progress as you can.

Today's problems are from [Interview Cake](https://www.interviewcake.com/), which is a great resource for whiteboarding and interview preparation.

1. Write a function to reverse a string. Do not use `StringBuilder`'s `reverse()` method.

	One possible solution:

	```java
	public String reverse(String str) {

		char[] strChars = str.toCharArray();

		int startIndex = 0;
		int endIndex = strChars.length - 1;

		while (startIndex < endIndex) {
			// swap characters
			char temp = strChars[startIndex];
			strChars[startIndex] = strChars[endIndex];
			strChars[endIndex] = temp;

			// move towards middle
			startIndex++;
			endIndex--;
		}

		return new String(strChars);
	}
	```

2. Write a function that takes a string and reverses the order of words but not the characters within the words. E.g. "The eagle has landed" becomes "landed has eagle The".

	One possible solution:

	```java
	public String reverseWords(String message) {

		char[] messageChars = message.toCharArray();

		// first we reverse all the characters in the entire messageChars array
		reverseCharacters(messageChars, 0, messageChars.length - 1);
		// this gives us the right word order
		// but with each word backwards

		// now we'll make the words forward again
		// by reversing each word's characters

		// we hold the index of the /start/ of the current word
		// as we look for the /end/ of the current word
		int currentWordStartIndex = 0;
		for (int i = 0; i <= messageChars.length; i++) {

			// found the end of the current word!
			if (i == messageChars.length || messageChars[i] == ' ') {

				// if we haven't exhausted the string our
				// next word's start is one character ahead
				reverseCharacters(messageChars, currentWordStartIndex, i - 1);
				currentWordStartIndex = i + 1;
			}
		}

		return new String(messageChars);
	}

	public void reverseCharacters(char[] messageChars, int startIndex, int endIndex) {

		// walk towards the middle, from both sides
		while (startIndex < endIndex) {

			// swap the front char and back char
			char temp = messageChars[startIndex];
			messageChars[startIndex] = messageChars[endIndex];
			messageChars[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
    ```


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
