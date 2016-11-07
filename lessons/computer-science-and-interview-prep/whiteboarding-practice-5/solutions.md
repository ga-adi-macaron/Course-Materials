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

Today's problems are from [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/098478280X), which is a great resource for whiteboarding and interview preparation.

1. A _magic index_ in an array of n integers `A[0...n-1]` is defined to be an index `i` such that `A[i] == i`. Given a **sorted** array of **distinct** integers, write a method to find a magic index, if one exists, in array A.

	Follow-up: Can you solve this problem using recursion? Hint: given what we know about the input array, can you determine if one half of the array _cannot_ contain a magic index?

    One possible solution:

    ```java
	// A "brute force" solution
	public static int getMagicIndex(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	// A recursive solution
	public static int getMagicIndexRecursively(int[] array) {
		return getMagicIndexRecursively(array, 0, array.length - 1);
	}

	public static int getMagicIndexRecursively(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			// base case
			return mid;
		} else if (array[mid] > mid) {
			// recurse into the first half of the array
			return getMagicIndexRecursively(array, start, mid - 1);
		} else {
			// recurse into the second half of the array
			return getMagicIndexRecursively(array, mid + 1, end);
		}
	}
    ```

	Diagram of a sample call: `getMagicIndexRecursively( [-4, 1, 3, 8, 9] )`
	![magic-index](images/magic-index.png)

2. Write a method to return all permutations of a string of unique characters.

	Hint: you don't always have to return the value of a recursive call immediately. Sometimes you might want to make the recursive call, modify the result, then return that.

    One possible solution:

    ```java
	public static List<String> getPermutations(String str) {
		if (str == null) {
			return null;
		}

		ArrayList<String> permutations = new ArrayList<String>();

		if (str.length() == 0) {
			// base case
			permutations.add("");
			return permutations; // only permutation of empty string is empty string
		}

		char first = str.charAt(0); // first character in 'str'
		String remainder = str.substring(1); // rest of string after first character
		
		// recursive call to get permutations of 'remainder'
		List<String> remainderPerms = getPermutations(remainder);

		// the permutations of 'str' are each of the permutations of 'remainder' plus 'first' at each position
		for (String remainderPerm : remainderPerms) {
			for (int i = 0; i <= remainderPerm.length(); i++) {
				permutations.add(remainderPerm.substring(0, i) + first + remainderPerm.substring(i));
			}
		}
		
		return permutations;
	}
    ```

	Diagram of a sample call: `getPermutations("abc")`
	![permutations](images/permutations.png)


#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
