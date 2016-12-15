---
title: Whiteboard Practice
type: Morning exercise
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Whiteboard Practice - Brain Teasers

## Exercise

Team up in groups of 2 or 3 and take turns working on the following problems. Pretend you are in an interview setting:
- Keep talking!
- Ask questions (to the instructors, or to your teammates)
- Consider starting with an example, showing the expected outputs for sample inputs
- Consider writing pseudocode before Java to make your steps clear to both you and the interviewer

#### Requirements

Take turns working through these problems on the whiteboard. It's OK if you don't finish them all. Make as much progress as you can.

Today's problems are from [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/098478280X), which is a great resource for whiteboarding and interview preparation. These are brain teasers, so you won't need to write any code, per se, but you may want to draw some diagrams and do some calculations to guide and explain your thinking.

1. You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight 1.1 grams. Given a scale that provides an exact measurement, how would you find the heavy bottle? You can only use the scale _**once**_.

    One possible solution:

	>You are allowed to remove pills from the bottles - hopefully you asked this as a clarifying question! Put 1 pill from bottle 1, 2 pills from bottle 2, ..., 19 pills from bottle 19, and 20 pills from bottle 20 on the scale, and perform one measurement of the weight of the pills.

	>The expected weight is `1 + 2 + ... + 20 = (20 * 21) / 2 = 210` (see [here](https://betterexplained.com/articles/techniques-for-adding-the-numbers-1-to-100/) for more on the formula for adding consecutive integers). If the actual weight is 210.1 grams, then bottle 1 contains the heavy pills. If the actual weight is 210.8 grams, then bottle 8 contains the heavy pills, etc.

2. There are 100 closed lockers in a hallway. You will make 100 passes through the hallway. On your first pass, you open all 100 lockers. On your second pass, you close every other locker. On your third pass, you "toggle" every third locker - if it's closed, you open it; if it's open, you close it. This continues so that on pass _i_ you toggle every _ith_ locker. After the last pass, when only locker 100 is toggled, how many lockers will be open?

    One possible solution:

	>When will a door be open? When it has been toggled an odd number of times (e.g. opened, close, opened). To find the total number of open doors at the end, we need to know how many of the 100 doors will be toggled an odd number of times.

	>When would the number of toggles for door _n_ be odd? When _n_ is a perfect square. Why? Consider door 36 - the factors of 36 are `(1, 36), (2, 18), (3, 12), (4, 9), (6, 6)`. For each one of those factors, door 36 will be toggled on that pass (the first pass, the 36th pass, etc). Note that `(6,6)` only contributes one factor, thus giving 36 an odd number of factors. Therefore, door 36, and any other _n_ that is a perfect square, will be open after the 100th pass.

	>There are 10 perfect squares between 1 and 100, inclusive: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100. Therefore, 10 lockers will be open at the end of the exercise.
	
3. There is a building with 100 floors. If an egg drops from the _Nth_ floor or above, it will break. If it's dropped from any floor below, it will not break. You're given 2 eggs and you need to find N. You can drop each of the two eggs multiple times, but of course once they break you cannot drop them again. How can you minimize the number of total drops you need to make with the 2 eggs while finding N?

    One possible solution:

	>The general idea is to drop egg 1 at higher and higher floors, skipping some floors each time, until it breaks, then use egg 2 to move upwards one floor at a time from the last floor egg 1 survived until it breaks too. Then the last floor egg 2 survived is _N_.

	>The key question, then is what interval to use with egg 1 when jumping to a higher floor after each successful drop. In order to minimize the total number of drops between both eggs, consider the relationship between the interval / # of floors skipped with egg 1 and the corresponding number of drops that might be needed for egg 2.

	>If you move egg 1 up by 10 floors each drop, then at most egg 2 will need to be dropped 9 times (once at each floor egg 1 skipped). If egg 1 skips 15 floors each time, then egg 2 will need to be dropped at most 14 times, etc.

	>To minimize the total number of drops, we want to set the interval for egg 1 such that # of egg 1 drops + # of egg 2 drops is always the same, no matter how many times egg 1 is dropped. This means that the # of floors egg 1 skips needs to get _smaller_ with each subsequent drop.

	>If egg 1's first drop is at floor `x` and it breaks, then egg 2 will make at most `x - 1` drops. If egg 1 survives from floor `x` and is dropped a second time, then we want to make sure the maximum number of drops for egg 2 is now `x - 2` to keep the total drops between eggs constant. How can we ensure egg 2 is only dropped at most `x - 2` times? By having egg 1 skip just `x - 1` floors for it's second drop.

	>So egg 1 will start at floor `x`, then go up by `x - 1` floors, then go up by `x - 2` floors, etc. Solve for `x`: `x + (x - 1) + (x - 2) + ... + 1 = 100 -> x(x + 1) / 2 = 100 -> x = 14`. This means egg 1 will be dropped at floor 14, then 27, then 39, etc, and egg 2 will be dropped at as many intermediate floors as necessary after egg 1 breaks. This will take a maximum of 14 drops.

#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
