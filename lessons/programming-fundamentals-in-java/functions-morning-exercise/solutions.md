---
title: Functions Practice
type: Morning exercise
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Functions Practice Morning Exercise

> ***Note:*** _This can be a pair programming activity or done independently._

## Exercise

#### Requirements

For more practice writing methods, try these problems from CodingBat:

- [Blackjack](http://codingbat.com/prob/p117019)
```java
/* Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over. */
public int blackjack(int a, int b) {
    if (a <= 21 && b <= 21) {
        return (Math.abs(21 - a) < Math.abs(21 - b)) ? a : b;
    } else if (a <= 21) {
        return a;
    } else if (b <=21) {
        return b;
    } else {
        return 0;
    }
}
```


- [Build an array](http://codingbat.com/prob/p178353)
```java
/* Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a length 0 array. Note: String.valueOf(xxx) will make the String form of most types. The syntax to make a new string array is: new String[desired_length] */
public String[] fizzArray2(int n) {
    String[] result = new String[n];
    for (int i = 0; i < n; i++){
        result[i] = String.valueOf(i);
    }
    return result;
}
```


- [Word count](http://codingbat.com/prob/p117630)
```java
/* The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array. */
public Map<String, Integer> wordCount(String[] strings) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String string : strings) {
        if (map.containsKey(string)){
            map.put(string, map.get(string) + 1);
        } else {
            map.put(string, 1);
        }
    }
    return map;
}
```


- [Shift left](http://codingbat.com/prob/p105031)
```java
/* Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array. */
public int[] shiftLeft(int[] nums) {
    if (nums.length < 2) {
        return nums;
    }
    
    int firstValue = nums[0];
    for (int i = 1; i < nums.length; i++) {
        nums[i - 1] = nums[i];
    }
    nums[nums.length - 1] = firstValue;

    return nums;
}
```


Use CodingBat's built-in tests to check if your code works correctly.
We'll go over these problems together at the end of the exercise.

#### Deliverable

Nothing to hand in! Just work on your code in CodingBat until all the tests pass.
