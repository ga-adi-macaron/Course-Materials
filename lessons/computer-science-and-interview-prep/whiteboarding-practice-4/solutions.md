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

1. We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
  - `triangle(0)` -> 0
  - `triangle(1)` -> 1
  - `triangle(2)` -> 3

	One possible solution:

	```java
	public int triangle(int rows) {
		if (rows <= 1) {
			return rows; // base case
		} else {
			// get the # of blocks before the current row with a recursive call
			// then add "rows" b/c that's how many blocks are in the current row
			return triangle(rows - 1) + rows;
		}
	}
	```

2. Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that value, and set the key "a" to have the value "". Basically "b" is a bully, taking the value of "a". *(hint: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html#method_summary)*
  - `mapBully({"b": "dirt", "a": "candy"})` -> `{"b": "candy", "a": ""}`
  - `mapBully({"a": "candy"})` -> `{"b": "candy", "a": ""}`
  - `mapBully({"b": "carrot", "c": "meh", "a": "candy"})` -> `{"b": "candy", "c": "meh", "a": ""}`

	One possible solution:

	```java
	public Map<String, String> mapBully(Map<String, String> map) {
		if (map.containsKey("a")) {
			map.put("b", map.get("a")); // put a's value in b
			map.put("a", "");			// put "" in a
		}
		return map;
	}
	```

3. We have an array of heights, representing the altitude along a walking trail. Given start/end indexes into the array, return the sum of the changes for a walk beginning at the start index and ending at the end index. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6. The start end end index will both be valid indexes into the array with start <= end.
  - `sumHeights([5, 3, 6, 7, 2], 2, 4)` -> 6
  - `sumHeights([5, 3, 6, 7, 2], 0, 1)` -> 2
  - `sumHeights([5, 3, 6, 7, 2], 0, 4)` -> 11

	One possible solution:

	```java
	public int sumHeights(int[] heights, int start, int end) {
		int sum = 0;
		for (int i = start + 1; i <= end; i++) {
			// compare each height to the previous height
			// use abs() because we only care about magnitude, not direction
			sum += Math.abs(heights[i] - heights[i - 1]);
		}
		return sum;
	}
	```

4. We'll say that a positive int divides itself if every digit in the number divides into the number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit divides itself. Note: use % to get the rightmost digit, and / to discard the rightmost digit.
  - `dividesSelf(128)` -> true
  - `dividesSelf(12)` -> true
  - `dividesSelf(120)` -> false

	One possible solution:

	```java
	public boolean dividesSelf(int n) {
		int temp = n;
		while (temp > 0) {
			int rightmostDigit = temp % 10;
			if (rightmostDigit == 0 || n % rightmostDigit != 0) {
				// if the rightmost digit is zero,
				// or if the rightmost digit doesn't divide evenly into n
				return false;
			}
			// reduce the temp variable for the next loop iteration
			temp /= 10;
		}
		// if we made it here w/o returning false, then the result is true
		return true;
	}
	```

#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
