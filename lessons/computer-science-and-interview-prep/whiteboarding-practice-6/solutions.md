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

	One possible solution:

	```java
	public int getMaxProfit(int[] stockPricesYesterday) {

		int maxProfit = Integer.MIN_VALUE;

		// go through every time
		for (int outerTime = 0; outerTime < stockPricesYesterday.length; outerTime++) {

			// for every time, got through every OTHER time
			for (int innerTime = 0; innerTime < stockPricesYesterday.length; innerTime++) {

				// for each pair, find the earlier and later times
				int earlierTime = Math.min(outerTime, innerTime);
				int laterTime   = Math.max(outerTime, innerTime);

				// and use those to find the earlier and later prices
				int earlierPrice = stockPricesYesterday[earlierTime];
				int laterPrice   = stockPricesYesterday[laterTime];

				// see what our profit would be if we bought at the
				// min price and sold at the current price
				int potentialProfit = laterPrice - earlierPrice;

				// update maxProfit if we can do better
				maxProfit = Math.max(maxProfit, potentialProfit);
			}
		}

		return maxProfit;
	}
	```

2. In your brute force solution, were you checking some combinations of buy & sell times more than once? Modify your method so it looks at each combination only once.

	One possible solution:

	```java
	public int getMaxProfit(int[] stockPricesYesterday) {

		int maxProfit = Integer.MIN_VALUE;

		// go through every price and time
		for (int earlierTime = 0; earlierTime < stockPricesYesterday.length; earlierTime++) {
			int earlierPrice = stockPricesYesterday[earlierTime];

			// and go through all the LATER prices
			for (int laterTime = earlierTime + 1; laterTime < stockPricesYesterday.length; laterTime++) {
				int laterPrice = stockPricesYesterday[laterTime];

				// see what our profit would be if we bought at the
				// min price and sold at the current price
				int potentialProfit = laterPrice - earlierPrice;

				// update maxProfit if we can do better
				maxProfit = Math.max(maxProfit, potentialProfit);
			}
		}

		return maxProfit;
	}
	```

3. Write an efficient version of this method that only loops through the input array once - no nested loops!

    One possible solution:

    ```java
	public int getMaxProfit(int[] stockPricesYesterday) {

		// make sure we have at least 2 prices
		if (stockPricesYesterday.length < 2) {
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}

		// we'll greedily update minPrice and maxProfit, so we initialize
		// them to the first price and the first possible profit
		int minPrice = stockPricesYesterday[0];
		int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

		// start at the second (index 1) time
		// we can't sell at the first time, since we must buy first,
		// and we can't buy and sell at the same time!
		// if we started at index 0, we'd try to buy /and/ sell at time 0.
		// this would give a profit of 0, which is a problem if our
		// maxProfit should be negative (if prices go down all day)
		for (int i = 1; i < stockPricesYesterday.length; i++) {
			int currentPrice = stockPricesYesterday[i];

			// see what our profit would be if we bought at the
			// min price and sold at the current price
			int potentialProfit = currentPrice - minPrice;

			// update maxProfit if we can do better
			maxProfit = Math.max(maxProfit, potentialProfit);

			// update minPrice so it's always
			// the lowest price we've seen so far
			minPrice = Math.min(minPrice, currentPrice);
		}

		return maxProfit;
	}
    ```


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
