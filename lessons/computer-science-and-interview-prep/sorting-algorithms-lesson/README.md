---
title: Sorting Algorithms
duration: "1:25"
creator:
    name: Josh Bartz
    city: Missoula

---

<!--  OUTSTANDING

-->

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Sorting Algorithms

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain Bubble Sort, Insertion Sort
- Explain your decision behind what sorting algorithm should be used for a given problem

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Write Java functions that accepts input and iterates over data collections

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Open/run the starter and solution code for this lesson and adapt as needed

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Guided Practice](#guided-practice-bubble-sort-15-mins)  | Bubble Sort |
| 15 min  | [Introduction](#introduction-insert-sort-15-mins)  | Insert Sort |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

Sorting data is a common operation. Whether we are sorting by numerical value, alphabetical order, or some custom definition, we need a way to organize and order our data. For example, what if you are writing a fantasy sports app, and you want to be able to list all of the leaders by a certain statistical category?  Sorting algorithms will help you do that.

An __algorithm__ is defined simply as a procedure or formula used to solve a problem. In this case, the problem is we want our unsorted data to be sorted. Fortunately for us, several formulas have already been written to solve this problem.


<a name="introduction"></a>
## Guided Practice: Bubble Sort (15 mins)

One of the simplest sorting algorithms is called Bubble Sort. Bubble Sort works in just a few steps:

1) Start at the beginning of an array (or list)
2) Compare the current item to the next
3) Swap them if the current item is greater than the next
4) Go to the next item
5) Repeat steps 1-4 until no swaps take place


Some pros of Bubble Sort are:

1) Simple to implement
2) Very fast on data that is already _mostly_ sorted

The largest disadvantage of using Bubble Sort is that it is much slower than other algorithms when working with data that isn't already mostly sorted, as it may require a lot of iterations through the list.

Here is an example of how Bubble Sort operates on the array {5, 1, 4, 2, 8} (Source: https://en.wikipedia.org/wiki/Bubble_sort):

__First Pass__

( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.

( 1 5 4 2 8 ) --> ( 1 4 5 2 8 ), Swap since 5 > 4

( 1 4 5 2 8 ) --> ( 1 4 2 5 8 ), Swap since 5 > 2

( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

__Second Pass__

( 1 4 2 5 8 ) --> ( 1 4 2 5 8 )

( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

Now, the array is already sorted, but the algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

__Third Pass__

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )


<a name="guided-practice"></a>
#### Demo: The Bubble Sort Algorithm (5 mins)

Let's take a look at some pseudocode for Bubble Sort:

```
func bubblesort( var a as array )
    for i from 1 to N
        for j from 0 to N - 1
           if a[j] > a[j + 1]
              swap( a[j], a[j + 1] )
end func
```

As you can see, it is a pretty basic, nested `for` loop that just compares each element to the element that follows. Then, the pseudocode swaps the two elements if the original element is greater than the next.

<a name="independent-practice"></a>

#### Independent Practice: Bubble Sort in Java - Optimized (15 mins)

Now, you're going to write Java code to implement the pseudocoded algorithm above. For a small optimization, think about how you could know the algorithm is complete without having to run the nested `for` loops - once this has been achieved, have the algorithm quit.

Use the [starter code](starter-code/BubbleSort.java) provided to get started:

```java
public static void main(String[] args) {
	int[] arr = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
	bubbleSort(arr);

	for(int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
}

private static void bubbleSort(int[] input) {
	//Your code here. Include a print statement
	//declaring after which pass (iteration through
	//the outside loop) the algorithm. It should be the 9th.		
}
```


<a name="introduction"></a>
## Introduction: Insert Sort (15 mins)

Insert Sort is another relatively simple sorting algorithm. Like Bubble Sort, it works best on arrays and lists that are already mostly sorted. It is faster and more optimized than Bubble Sort, especially on smaller lists. Insert Sort works by iterating through the list or array and _inserting_ each element where it belongs in the collection being built behind it.

Here is how Insert Sort works on the same array that we sorted above:

( 5 __1__ 4 2 8 ) --> ( __1__ 5 4 2 8 ), Here, the algorithm starts at the second element and iterates backwards until it finds where the element fits. In this case, the element goes before _5_

( 1 5 __4__ 2 8 ) --> ( 1 __4__ 5 2 8 ), Now, the algorithm goes to the 3rd element and finds that it belongs between _1_ and _5_

( 1 4 5 __2__ 8 ) --> ( 1 __2__ 4 5 8 ), Element #4, _2_, belongs between _1_ and _4_

( 1 4 2 5 __8__ ) --> ( 1 4 2 5 8 ), Now, because all of the elements are already in order, no change is made.


Basically, Insert Sort works by going forward through an array one time, stopping at each element to look behind it to find the proper place for that element. This sort of operation requires nested `for` loops, which is why Insert Sort is known as a quadratic sorting algorithm.

#### Quadratic Functions

Consider the formula in the graph below:

<p align="center">
  <img src="https://i.imgur.com/OElD9b3.png">
</p>

Because the term "quad" can refer to a square, and the variable in this equation gets squared (x^2), we refer to this equation as a Quadratic Equation.   


<a name="guided-practice"></a>
#### Guided Practice: The Insert Sort Algorithm (10 mins)

Now, as a class, let's come up with the pseudocode for Insert Sort.


```
func insertionSort( var a as array )
    for i from 1 to N
        for j from i to 1
            if a[j] < a[j-1]
                swap a[j] and a[j-1]
end func
```

<a name="independent-practice"></a>
#### Independent Practice: Implement Insertion Sort (15 mins)

> ***Note:*** _This can be a pair programming activity or done independently._

Your turn! Implement Insert Sort to sort an array of integers. Print each swap after it occurs to better see how Insert Sort reorders the elements.    Use the [starter code](starter-code/InsertionSort.java) provided to get started:

``` java
public static void main(String[] args) {
	int[] arr = {7, 3, 2, 4, 9, 1, 14, 12};
	doInsertionSort(arr);

	for(int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
}

private static void doInsertionSort(int[] input) {
    //Your code here
}
```


<a name="conclusion"></a>
## Conclusion (5 mins)

There is no perfect sorting algorithm. There is, however, a perfect time and place for several sorting algorithms. That is why it is necessary to know the properties of several algorithms and how their respective strengths and weaknesses stack up against each other. The two algorithms taught in this lesson both have similar strengths and weaknesses. Unfortunately, neither one does very well with larger, less sorted datasets. For that, we need a more powerful algorithm in future lessons.
