---
title: Whiteboard Practice
type: Morning Exercise
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

1. **Split Array:** Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)

  - `splitArray([2, 2])` → true
  - `splitArray([2, 3])` → false
  - `splitArray([5, 2, 3])` → true

    One possible solution:

    ```java
    public boolean splitArray(int[] nums) {
        return helper(nums, 0, 0, 0);
    }

    public boolean helper(int[] nums, int startIndex,
                          int groupOneSum, int groupTwoSum) {
        if (startIndex >= nums.length) {
            // base case: startIndex is outside the bounds of nums,
            // so we're done. Check if the two sums are equal.
            return groupOneSum == groupTwoSum;
        } else {
            // otherwise, 2 options: add value at startIndex to first group,
            // or add it to the second group
            return helper(nums, startIndex + 1,
                          groupOneSum + nums[startIndex], groupTwoSum)
                || helper(nums, startIndex + 1,
                          groupOneSum, groupTwoSum + nums[startIndex]);
        }
    }
    ```

    Sample call to `splitArray([5, 2, 3])`:
    
    <img src="images/splitArray.png" width="600"/>

2. **Score Up:** The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}. The "answers" array contains a student's answers, with "?" representing a question left blank. The two arrays are not empty and are the same length. Return the score for this array of answers, giving +4 for each correct answer, -1 for each incorrect answer, and +0 for each blank answer.

  - `scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"])` → 6
  - `scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"])` → 11
  - `scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"])` → 16

    One possible solution:

    ```java
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals(key[i])) {
                score += 4;
            } else if (!answers[i].equals("?")) {
                score -= 1;
            }
        }
        return score;
    }
    ```

3. **User Compare:** We have data for two users, A and B, each with a String name and an int id. The goal is to order the users such as for sorting. Return -1 if A comes before B, 1 if A comes after B, and 0 if they are the same. Order first by the string names, and then by the id numbers if the names are the same. Note: with Strings str1.compareTo(str2) returns an int value which is negative/0/positive to indicate how str1 is ordered to str2 (the value is not limited to -1/0/1).

  - `userCompare("bb", 1, "zz", 2)` → -1
  - `userCompare("bb", 1, "aa", 2)` → 1
  - `userCompare("bb", 1, "bb", 1)` → 0

    One possible solution:

    ```java
    public int userCompare(String aName, int aId, String bName, int bId) {
        int comp = aName.compareTo(bName);
        comp = (comp == 0 ? aId - bId : comp); // If strings are equal, compare IDs
        return (comp == 0 ? 0 : comp / Math.abs(comp)); // normalize to -1 or 1
    }
    ```

#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
