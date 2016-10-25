---
title: Whiteboard Practice
type: Morning exercise
duration: "1:30"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Whiteboard Practice - Recursion

## Introduction

Today we're going to focus on **recursion**, which is when a method calls itself. You need two things to avoid an infinite loop where the method keeps calling itself forever:

1. A _base case_, which returns a value without any further recursive calls (you can have more than one base case sometimes)
2. A _reduction step_, which changes the input before making the next recursive call, so as to make progress toward the base case

Consider this sample problem:

```java
// factorial(5), a.k.a. 5!, is defined as 5 * 4 * 3 * 2 * 1
public static int factorial(int n) {
	if (n <= 1) {
		// this is the base case, when n is 1 (or less than 1)
		return 1;
	} else {
		// otherwise, reduce the input by 1 and make a recursive call
		return n * factorial(n - 1);
	}
}
```

Sketch of the recursive calls on the memory stack for `factorial(4)`:
![factorial](images/factorial.png)

## Exercise

Team up in groups of 2 or 3 and take turns working on the following problems. Pretend you are in an interview setting:
- Keep talking!
- Ask questions (to the instructors, or to your teammates)
- Consider starting with an example, showing the expected outputs for sample inputs
- Consider writing pseudocode before Java to make your steps clear to both you and the interviewer

#### Requirements

Take turns working through these problems on the whiteboard. It's OK if you don't finish them all; make as much progress as you can.

1. Write a recursive function called `reverse` that accepts a string and returns a reversed string. For example:
  - `reverse("abc")` -> "cba"
  - `reverse("ab")` -> "ba"
  - `reverse("a")` -> "a"
  - `reverse("")` -> ""


2. The fibonacci sequence is 1, 1, 2, 3, 5, 8, etc. where the sequence starts with two 1s, then each following entry is the sum of the previous two entries. Write a recursive function called `fib` that accepts a number `n`, greater than zero, and returns the Nth fibonacci number. For example:
  - `fib(1)` -> 1
  - `fib(2)` -> 1
  - `fib(3)` -> 2
  - `fib(4)` -> 3
  - `fib(5)` -> 5
  - `fib(-1)` and `fib(0)` -> 0 (input shoud be >= 1)


3. A _palindrome_ is a string that is spelled the same backwards and forwards. Put another way, a palindrome is a string where the first letter is equal to the last letter, and the second letter is equal to the second to last letter and so on and so forth. An empty string is considered a palindrome. A one letter string is considered a palindrome.

  Write a function called `isPalindrome` that accepts a string and returns `true` if the string is a palindrome, and returns `false` if the string is not. For example:
  - `isPalindrome("")` -> true
  - `isPalindrome("a")` -> true
  -	`isPalindrome("ab")` -> false
  - `isPalindrome("abba")` -> true
  - `isPalindrome("catdog")` -> false
  - `isPalindrome("tacocat")` -> true


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
