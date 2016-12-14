---
title: Linear and Binary Search
type: lesson
duration: "1:30"
creator: James Davis (NYC)

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Linear and Binary Search Lesson

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Compare binary search with linear search strategies
- Use a binary search to search through an array
- Explain what a Binary Search Tree is
- Know how a Binary Search Tree may be implemented in Java


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-linear-search-15-mins)  | Linear Search |
| 15 min  | [Introduction](#introduction-binary-search-15-mins)  | Binary Search |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
---
## Opening (5 mins)

Searching is a very important part of development. It's used in many applications, websites, etc.

> Check: Can you think of any?

Let's use Google as an example (it will be a recurring theme throughout this lesson). Google's sole purpose, originally, was to search through websites given a particular criteria.

There are many ways to search for particular items in a set of data. Today, I'm going to introduce a couple of ways: the brute-forcey (but still useful!) *Linear Search* and the more common *Binary Search*.


## Introduction: Linear Search (15 mins)

#### Solidify the concepts

*Close your laptops when doing this exercise.*

For the next 4 minutes, talk to the person next to you and try to figure how to do the following:

Given an array of random numbers, search for a particular number WITHOUT sorting.

*Note:* This is a conceptual exercise; do not write this in Java!  Use your desks or the walls.

> check: Have students share out.

#### Brute forcing our way to the top!

So, the easiest way to search for something is to do a linear search.

The idea is to go through each item, one at a time, and checking if it is the droid you are looking for.

Here's some pseudocode for searching for a number in an array of numbers:

```
int linearSearch(int[] array) {
	for each number in array {
		does number equal array[position]?
			Yes: return position
	}

	if number was not found in array, return -1
}
```

> Check: What do you like and/or dislike about this method of search?

<a name="guided-practice"></a>
#### Guided Practice: Linear Search (10 minutes)

Let's discuss and write out the steps to perform a search on this array of 12 numbers:

12, -3, 5, 6, 3, 1, 0, -33, 6, 9, 12, 2

The goal: Find the number *9*.

## Introduction: Binary Search (15 mins)

#### Solidify the concepts

I'm thinking of a number between 60 and 80. Try to guess what number it is. I'll give you no context.

Alright, let's try it again. I'll give you context clues this time about whether it is higher or lower.

The latter is one of the ideas behind a binary search!

#### Binary Searching

The idea is interesting. If you have a sorted list of numbers, you can *divide and conquer* the set of numbers again and again until you find the answer:

First, you divide the set of numbers in half and look at the middle element in the sorted array. Is the number you are looking for higher or lower than the number you are looking at right now? If it's lower, look at the numbers before the number. Otherwise, look at the higher numbers.

You just eliminated half of the possibilities!

So then you do it again but now, just with the numbers left over. Rinse and repeat until you have one number left, the one you are looking for (or not).

<a name="guided-practice"></a>
#### Guided Practice: Binary Search (10 minutes)

Let's discuss and write out the steps to perform a binary search using this array of 12 numbers:

12, -3, 5, 6, 3, 1, 0, -33, 6, 9, 12, 2

The goal: Let's try finding the number *9*, again.


<a name="independent-practice"></a>
#### Independent Practice: Pseudocode and Java (20 minutes)

For the next 20 minutes, write out the code for binary search in pseudocode or Java.

> Check: Have students share out in pairs.

```java
public boolean binarySearch(int key, int[] data)
    {
         int low = 0;
         int high = size - 1;

         while(high >= low) {
             int middle = (low + high) / 2;
             if(data[middle] == key) {
                 return true;
             }
             if(data[middle] < key) {
                 low = middle + 1;
             }
             if(data[middle] > key) {
                 high = middle - 1;
             }
        }
        return false;
   }

```

> Check: Since binary search only works on sorted arrays, what are the pros and cons of this method?

## Introduction: Binary Search Tree (10 mins)

We've already learned about Linked Lists, and how nodes connect to each other to form a linear chain. There is another data structure called Binary Search Trees which can be used to enhance the binary search process.

Because of the common properties they share with Linked Lists, Items can easily be added or removed to Trees, something not easily done with arrays.

A __Binary Tree__ is a specific tree data structure in which each node has at most 2 child nodes. These are commonly referred to as "left" and "right" nodes. A __Binary Search Tree__ additionally has a special property. This is that the key in each node must be greater than all keys stored in the left sub-tree, and smaller than all keys in the right sub-tree.

Here's a visual example:

[![Binary Search Tree](https://encrypt3d.files.wordpress.com/2010/09/nodes-in-binary-search-tree.png)](https://encrypt3d.files.wordpress.com/2010/09/nodes-in-binary-search-tree.png)

> Check: Can you draw another example of a BST?

## Guided Practice: Implementing a BST in Java (40 mins)

So how would we make this data structure?

We'll need to implement a BST, which will have these properties:
* The Left subtree contains the nodes with keys less than the node's key.
* The Right subtree contains the nodes with keys greater than the node's key.
* Both the right and left subtree should also be binary search tree.
* There should not be any duplicate nodes.

We will want to implement the following methods:

* Searching
* Insert Node
* MinValue
* MaxValue

First, we know that our data structure will be made of nodes. We can assume that this looks like this:

```java
public class Node {

    protected Node left;
    protected Node right;
    protected int value;

    public Node(int value){
        this.value=value;
    }
}
```

This is pretty standard. Now, for our methods:

**Searching:**

If we want to search for a node that matches a given key:

  1. We start at the root node as current node.

  2. If the search key’s value matches the current node’s key, then we have matched.

 3. If search key’s value is greater than current node’s:

    i. If the current node has a right child, search right

    ii. else, no matching node in the tree

4. If search key is less than the current node’s
    i. If the current node has a left child, search left

    ii. Else, no matching node in the tree

```java
    public void search(Node n, int value){
        if(n.value == value || n==null){
            System.out.println("\nFound Value: " + n.value);
        }else if(value<n.value){
            search(n.left,value);
        }else {
            search(n.right,value);
        }
    }
```

**Insertion:**

We want to always insert a new load as a leaf node. Here's the basic process:

1. Start at the root node.

2. If the new node's key is less than the current key:

	i. if the current node has a left child, search left.

	ii. else add the node as the current node's left child.

3. If the new node's key is greater than the current key:

	i. if the current node has a right child, search right.

	ii. else add the new node as the current node's right child.

```java
    public void insert(Node n, int value){
        if(value < n.value){
            if(n.left != null){
                insert(n.left,value);
            }else{
                n.left=new Node(value);
            }
        }
        if(value > n.value){
            if(n.right != null){
                insert(n.right,value);
            }else{
                n.right=new Node(value);
            }
        }
    }
```

**Note:** Normally there is another operation we would need to do after inserting/removing called balancing the tree.

**Min and Max Value:**

We know how to get to the min and max, because we just need to get to the left and right-most nodes, respectively:


```java
    public int minValue(Node n){
        while(n.left!=null){
            n=n.left;
        }
        return n.value;
    }

    public int maxValue(Node n){
        while(n.right!=null){
            n=n.right;
        }
        return n.value;
    }
```

## Conclusion (10 mins)

Binary Search Trees are a popular algorithm subject, and further Binary Search is a core concept in many built-in Java and Android processes. While you might not have to implement it when writing apps, it's important to understand so you have a good grasp of how things work under the hood.

## Reference:

[tutorial] (http://www.code2learn.com/2013/02/binary-search-tree-bst-algorithm.html)
