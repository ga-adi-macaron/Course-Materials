---
title: Whiteboard Practice
type: Morning exercise
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Whiteboard Practice - Linked Lists

## Exercise

Team up in groups of 2 or 3 and take turns working on the following problems. Pretend you are in an interview setting:
- Keep talking!
- Ask questions (to the instructors, or to your teammates)
- Consider starting with an example, showing the expected outputs for sample inputs
- Consider writing pseudocode before Java to make your steps clear to both you and the interviewer

#### Requirements

Take turns working through these problems on the whiteboard. It's OK if you don't finish them all. Make as much progress as you can.

Today's problems are from [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/098478280X), which is a great resource for whiteboarding and interview preparation.

1. Implement an algorithm to find the _kth-to-last_ element of a _singly_ linked list. The implementation of linked list you are using does NOT track the size of the list, i.e. you cannot do `position = size - k`.

    One possible solution:

    ```java
	public LinkedListNode kthToLast(LinkedListNode head, int k) {
		if (k < 0) {
			return null;
		}

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		// Move p2 forward k nodes into the list
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) {
				return null; // In case we have fewer than k elements
			}
			p2 = p2.next;
		}
		if (p2 == null) {
			return null;
		}

		// Now move p1 and p2 at the same speed. When p2 hits the end,
		// p2 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
    ```

2. Write code to remove duplicates from an **unsorted** singly linked list.

	Follow up: How would you solve this problem if a temporary data buffer (i.e. a separate data structure besides the linked list) was not allowed?

    One possible solution:

    ```java
	void deleteDups(LinkedListNode<T> n) {
		HashSet<T> set = new HashSet<T>();

		LinkedListNode previous = null;
		
		while (n != null) {
			// If n's data value has already been seen...
			if (set.contains(n.data)) {
				// Then remove n by having the previous node point past it
				previous.next = n.next;
			} else {
				// Otherwise, add n's data to the set & increment previous
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}

	void deleteDupsNoBuffer(LinkedListNode head) {
		if (head == null) {
			return;
		}

		LinkedListNode current = head;
		while (current != null) {
			// Remove all nodes after current w/ same data
			LinkedListNode runner = current;
			while (runner.next != null) {

				// If runner.next has duplicate data...
				if (runner.next.data.equals(current.data)) {

					// Then remove it by pointing past it
					runner.next = runner.next.next;
				} else {
					// Else move runner to next position
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
    ```

#### Deliverable

No deliverable - just practice working through problems out loud on a whiteboard
