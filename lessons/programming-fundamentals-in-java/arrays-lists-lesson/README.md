---
title: Arrays vs Lists Review
duration: "1:30"
creator:
    name: Josh Bartz
    city: Missoula

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Linked Lists

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain the benefits of Lists over Arrays
- Explain how LinkedLists work
- Explain the difference between a LinkedList and an ArrayList

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Implement Arrays, ArrayLists, and LinkedLists

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Open/run the starter and solution code and adapt as needed
- Create a [gist](gist.github.com) to share the code needed for the independent practice and be sure to remove the answers to the discussion questions within the code

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-shortcomings-of-arrays-10-mins)  | Shortcomings of Arrays |
| 15 min  | [Introduction](#introduction-linked-lists-15-mins)  | Linked Lists |
| 10 min  | [Introduction](#introduction-array-lists-10-mins)  | Array Lists |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)


Arrays and Lists have been used throughout the course, but it is important that we have a solid understanding of all of the advantages and disadvantages of each, since they play a crucial role in programming, as well as interview questions.

## Introduction: Shortcomings of Arrays (10 mins)

Arrays are very useful for creating collections of objects or primitives. Arrays can be built and accessed very quickly, and every element is indexed for your convenience, making them a great way to organize data.

> Check: Have the students take 2 minutes to discuss at their tables any limitations or disadvantages of arrays.

Arrays are great if you know exactly how much data you need to organize. In Java, the size of an array is fixed once it has been created.

> Check: Show the code below to the students, and ask students to talk with the person next to them about what error it would cause (IndexOutOfBoundsException).


```java
    private int[] myIntArray = new int[3];
    int[0] = 12;
    int[1] = 13;
    int[2] = 14;
    int[3] = 15;

    //or...
    private int[] myOtherIntArray = new int[]{12, 13, 14};
    int[3] = 15;
```

Both attempts to insert the number 15 will cause an `IndexOutOfBoundsException`. This is because both arrays are fixed at length 3. In order to add the number 15, you must either replace one of the other elements, or create a whole new array. To create a collection of objects that can be added to without needing to re-copy itself continuously, we can use a __LinkedList__.


> Check: Have the students take 1 minute to come up with examples where an array would be the best choice to hold data.  Ask student groups to share out.


## Introduction: Singly Linked Lists (15 mins)

> Check: Ask the students if they remember the differences between an ArrayList and a LinkedList

The simplest form of the LinkedList is the singly LinkedList. In this data structure, each element knows about only two objects: itself and the next object in the list.

Typically, LinkedLists are thought of to contain _Nodes_. A basic Node class for a linked list looks similar to this (the real syntax is slightly different):

```java
public class Node {
    Node next;
    Object data;

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }
}
```


As you can see, a Node object contains a reference to another Node called `Next`. This is the next Node in the LinkedList. The last element in the LinkedList always has a `Next` pointing to `null`. If a Node is added onto the end, the previous last Node's `Next` now points to the new Node. The new Node's `Next` is now `null`.

But how is a Node actually used in the LinkedList?

> Check: Take two minutes to figure out how we would define a LinkedList class and its member variables.

```java
public class LinkedList {
    private Node head;
    private int size;
}
```

> Check: Ask the students to explain to each other what would happen if you remove an element from the LinkedList at 1. the head 2. the middle 3. the tail

#### Demo: Utilizing `java.util.LinkedList` (15 mins)


For a quick example of how to use the standard Java Linked List, consider the following:

```java
public static void main(String[] args) {
	List<Integer> intList = new LinkedList<>();
	intList.add(12);
	intList.add(13);
	intList.add(14);
	intList.add(15);

	for(int i = 0; i < intList.size(); i++) {
		System.out.println("For Loop: " + intList.get(i));
	}

	intList.add(1, 20);

	//A linked list has its own Iterator, which it uses to traverse
	//through the nodes. `it.hasNext()` will return `true` until it
	//reaches the last Node. Once `Node.next()` returns `null`, the
	//while loop exits.
	ListIterator<Integer> it = intList.listIterator(0);

	while(it.hasNext()) {
		System.out.println("From Iterator: " + it.next());
	}

	intList.remove(0);


	//You can also use a foreach loop
	for(Integer myInt : intList) {
		System.out.println("For Each: " + myInt);
	}
}
```

> Check: When the for loop executes, how does it access each value in the list?

Notice how the LinkedList can be read using a standard `for` loop. While it may look like a LinkedList is indexed (like an array), it is actually _iterated_ using its size (remember the small LinkedList implementation above). That means that, unlike an array, you cannot go directly to a specified element. Instead, you must iterate through the list until you reach the desired location. This may not seem like a lot of effort, but it is something to consider if you start working with large amounts of data. So how do we have a collection of undetermined size that is also indexed? For that, we use an ArrayList.

> Check: Ask the students to take a minute and come up with an example where we would use a LinkedList (1 mins). Have students share out.


## Introduction: Array Lists (10 mins)


Let's look at the above code again, but this time using an Array List. As the name implies, ArrayLists are Lists backed by an array data collection.

```java
public static void main(String[] args) {

	List<Integer> intList = new ArrayList<>();
	intList.add(12);
	intList.add(13);
	intList.add(14);
	intList.add(15);

	for(int i = 0; i < intList.size(); i++) {
		System.out.println("For Loop: " + intList.get(i));
	}

	intList.add(1, 20);

	ListIterator<Integer> it = intList.listIterator(0);

	while(it.hasNext()) {
		System.out.println("From Iterator: " + it.next());
	}

	intList.remove(0);

	for(Integer myInt : intList) {
		System.out.println("For Each: " + myInt);
	}

}
```

Both blocks of code are valid, and both use the same method names. That is because both `java.util.LinkedList` and `java.util.ArrayList` _implement_ the `List` interface. That means they appear to behave exactly the same to an outside class. Internally, however, they behave very differently.

An ArrayList is actually backed by an array of finite size. If the array becomes full, it then copies itself into a larger array. As the array grows larger, the cost of this copying also grows. The array is usually expanded by a factor of itself, so it grows by a larger amount each time to avoid doing extra copy operations. Essentially, it trades memory for speed, as the backer array allows for each element to be indexed.

> Check: Ask the students to come up with an example where we would use an ArrayList (1 min). Have students share out.

#### Independent Practice Practice: LinkedList vs ArrayList (20 mins)

In groups, look over this code.  With your group, discuss each question found within in the code around strengths and weaknesses of LinkedLists and ArrayLists.

> Instructor Note: Share this code with students (potentially as a gist, but be sure to strip out the answers under each discussion question.)


```java
public static void main(String[] args) {

	List<Integer> linkedList = new LinkedList<>();
	linkedList.add(12);
	linkedList.add(13);
	linkedList.add(14);
	linkedList.add(15);

	List<Integer> arrayList = new ArrayList<>();
	arrayList.add(12);
	arrayList.add(13);
	arrayList.add(14);
	arrayList.add(15);



// Discuss what situation will cause each of the types of lists executing the operations below to be slower and why.


	linkedList.add(2000);
	arrayList.add(2000);


// Discuss what operation is slower and why.


	int listInt = linkedList.get(4);
	int arrayInt = arrayList.get(4);


  // Discuss which of these operations is slower and why

	linkedList.remove(3);
	arrayList.remove(3);

}
```

> Check: Discuss the answers with the class during the last 5 minutes of the activity.

<a name="conclusion"></a>
## Conclusion (5 mins)

The Linked List is a very useful data structure. It allows for unlimited operations to be done on a single collection. However, no data structure is always the correct choice. Sometimes an array is best; other times it is a LinkedList. Sometimes, it is a combination of both, calling for an ArrayList. Always consider how you will be using your data when choosing the data structure to hold it.

## Additional Resources

- [A quick overview on when to use a LinkedList vs an ArrayList](http://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/)
