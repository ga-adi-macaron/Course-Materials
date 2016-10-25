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

1. **Lucky Sum:** Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
  - `luckySum(1, 2, 3)` -> 6
  - `luckySum(1, 2, 13)` -> 3
  - `luckySum(1, 13, 3)` -> 1


2. **Repeat Front:** Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
  - `repeatFront("Chocolate", 4)` -> "ChocChoChC"
  - `repeatFront("Chocolate", 3)` -> "ChoChC"
  - `repeatFront("Ice Cream", 2)` -> "IcI"


3. **Sum Digits:** Given a non-negative int n, return the sum of its digits _**recursively**_ (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

  - `sumDigits(126)` -> 9
  - `sumDigits(49)` -> 13
  - `sumDigits(12)` -> 3


4. **Big Diff:** Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
  - `bigDiff([10, 3, 5, 6])` -> 7
  - `bigDiff([7, 2, 10, 9])` -> 8
  - `bigDiff([2, 10, 7, 2])` -> 8


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
