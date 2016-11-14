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

Suppose we could access yesterday's stock prices as an array, where:
  - The indices are the time in minutes past trade opening time, which was 9:30am local time.
  - The values are the price in dollars of Apple stock at that time.

So if the stock cost $500 at 10:30am, `stockPricesYesterday[60] = 500`. You are going to write versions of a method that takes `stockPricesYesterday` and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday. No "shorting" - you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).

For example:
```java
int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)
```

1. Write a "brute force" version of this method which checks every possible combination.

2. In your brute force solution, were you checking some combinations of buy & sell times more than once? Modify your method so it looks at each combination only once.

3. Write an efficient version of this method that only loops through the input array once - no nested loops!


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
