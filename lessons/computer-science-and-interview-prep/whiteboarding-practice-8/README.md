---
title: Whiteboard Practice
type: Morning Exercise
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Whiteboard Practice: More Recursion

## Exercise

Team up in groups of 2 or 3 and take turns working on the following problems. Pretend you are in an interview setting:
- Keep talking!
- Ask questions (to the instructors, or to your teammates)
- Consider starting with an example, showing the expected outputs for sample inputs
- Consider writing pseudocode before Java to make your steps clear to both you and the interviewer

#### Requirements

Take turns working through these problems on the whiteboard. It's OK if you don't finish them all. Make as much progress as you can.

1. **Count X:** Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
  - `countX("xxhixx")` -> 4
  - `countX("xhixhix")` -> 3
  - `countX("hi")` -> 0


2. **End X:** Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
  - `endX("xxre")` -> "rexx"
  - `endX("xxhixx")` -> "hixxxx"
  - `endX("xhixhix")` -> "hihixxx"


3. **Group Sum:** Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, our convention is to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.

  - `groupSum(0, [2, 4, 8], 10)` -> true
  - `groupSum(0, [2, 4, 8], 14)` -> true
  - `groupSum(0, [2, 4, 8], 9)` -> false


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
