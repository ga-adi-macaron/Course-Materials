---
title: Mastering Control Flow and Loops
type: lesson
duration: "1:35"
creator:
    name: Kristen Tonga
    city: NYC
competencies: Programming

---


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Mastering Control Flow

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Use if/else if/else conditionals to control program flow based on boolean conditions
- Use comparison operators to evaluate and compare statements
- Use boolean logic (!, &&, ||) to combine and manipulate conditionals
- Use switch conditionals to control program flow based on explicit conditions
- Loop over a code block one or more times

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*

- Create variables in Java using basic data types
- Use a text editor

## Opening (5 mins)

From Culttt.com: "Control Flow Structures are an important aspect of programming languages that allow your code to take certain actions based on a variety of scenarios. Control Flow is a fundamental concept in programming that allows you to dictate how your code runs under different conditions or until a certain condition is met."

## Introduction: Logical operators and control flow (10 mins)

Java supports a compact set of statements, specifically control flow statements, that you can use to incorporate a great deal of interactivity in your application.


#### Block Statements

Statements meant to be executed after a control flow operation will be grouped into what is called a **block statement**. These statements are wrapped into a pair of curly braces:

```java
{
  System.out.println("hello");
  System.out.println("roar");
}
```

#### Block scope

We've seen that scope changes depending on whether a variable is defined in the class (we use the `mVariableName` convention for these), or in a method (these variables have local scope only and are not available outside that method).

In Java, variables defined in **block statements** modify scope, meaning those variables are not available outside of the block.


For example:

```java
boolean beautiful = true;
if (beautiful)
{
  String name = "jay";
}
System.out.println(name); // symbol 'name' cannot be resolved
```

Variables defined in **block statements** are not available outside of the curly braces. How might we resolve this issue?


```java
boolean beautiful = true;
String name = "pepe";

if (beautiful)
{
  name = "robin"; // use the predefined variable
}
System.out.println(name);
//=> robin
```

## Demo: Conditional statements (10 mins)

Conditional statements are a way of essentially skipping over a block of code if it does not pass a boolean expression. Java supports two conditional statements: `if`...`else` and `switch`.

#### if...else statement

`if(expr) { code }`

... means run the `code` block if `expr` is `true`

```java
if (1 > 0) {
  System.out.println("hi");
}
//=> hi
```

When you need to test more than one case, you may use `else if`:

```java
String name = "kittens";
if (name.equals("puppies")) {
    name += "!!!";
} else if (name.equals("kittens")) {
    name += "!!";
} else {
    name = "!" + name;
}
System.out.println(name);
//=> "kittens!!"
```

#### Ternary Operator

Java has a ternary operator for conditional expressions. You can think about the ternary operator as a concise "if-else in one line":

```java
int age = 12;

String allowed = (age > 18) ? "yes" : "no";

System.out.println(allowed);
//=> "no"
```

#### Truth-y & False-y

It's important to know that all of the following become `false` when converted to a Boolean:


- `false`
- `0`
- `""` (empty string)
- `NaN`
- `null`
- `undefined`

For example:

```java
Boolean b = new Boolean("");
System.out.println(b);
//=> false
```

This can be vary helpful when checking if conditions exist, are undefined, or if variables don't hold value.


## Demo: Comparison Operators (10 mins)

[Comparisons](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html) in Java can be made on primitives using `<`, `>`, `<=`, and `>=`.

```java
'A' > 'a'
//=> false

'b' > 'a'
//=> true

12 > 12
//=> false

```

Note that you _cannot_ do:

```java
12 >= "12"

// or

"Apple" > "Oranges"
```

#### Equality Operator `==`

> Check: Can you remember from the pre-work how to compare variables?

When verifying equality between primitives use double equal `==`:

```java
System.out.println(1 == 2);
=> false
```

But what about with Objects like strings?

##### A special note on Equality among Strings:

There are actually two ways to compare the equality of strings.

```java
String blue = "blue";
boolean withSign = (blue == "blue");            //=> true
boolean withWords = (blue).equals("blue");      //=> true
```

Do you know which one of these would be preferred?

Well, lets do another example to show you which and why:

```java
String blue = "blue";
String bl = "bl";
String ue = "ue";
System.out.println(bl+ue);                      //=> blue
boolean withSigns = (bl+ue == blue);            //=> false
boolean withWords = (bl+ue).equals(blue);       //=> true
```

Why isn't `withSigns` true? The print out looks the same.

Well, Objects and arrays are complex collections of values, and when we refer to them, we're actually referencing where they live in memory.`==` compares the place where the object was stored on the computer.

What this means is that Java doesn't care if they look similar. It only compares whether or not they are the exact same object in memory. In each of the cases above, when checking for equality, we're actually comparing two objects that are in two different places in memory.

`String blue` has a reference to where it is stored on the computer, and that is a different place than `String bl` is stored. They're not exactly "the same" according to `==`.

`equals()`, on the other hand, is a method that can be called on an instance(`str1`) of a String Object. And this method checks whether the `char` arrays in each String are the same, not whether the references are the same.

The long and short of it, use `equals` when comparing strings.


#### !=

There is also an `!=` operator, which is the inverse `==`.


## Guided Practice: Boolean/Logical Operators (15 mins)

[Logical operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html) will always return a boolean value `true` or `false`.

There are two "binary" operators that require two values:

- **AND**, denoted `&&`
- **OR**, denoted `||`

A third "unary" operator requires only one value:

* **NOT**, denoted `!`

#### && (AND)

Do these with me!

The `&&` operator requires both values to the left and right of the operator to be `true` in order to return the entire statement as `true`:

```java
boolean result = false;

if(true && true) {
  result = true;
}
System.out.println(result);
//=> true
```

Any other combination using the `&&` operator is `false`.  What happens if I check `true && false`?

```java
boolean result = false;

if(true && false) {
  result = true;
}
System.out.println(result);
//=> false
```

```java
boolean result = false;

if(false && false) {
  result = true;
}
System.out.println(result);
//=> false
```

#### || (OR)

The `||` operator requires just one of the left or right values to be `true` in order to return true.

So, now, if I do `true || false`, what will be returned?

```java
if(true || false) {
  System.out.println("true");
}
//=> true

if(false || true) {
  System.out.println("true");
}
//=> true

if(false || false) {
    System.out.println("true");
}
//=> ... silence ...
```


Only `false || false` will return `false`

The `!` takes a value and returns the opposite boolean value, i.e.

```java
!(true)
//=> false
```

The `&&` and `||` operators use short-circuit logic, which means whether they will execute their second operand is dependent on the first.


This is useful for checking for null objects before accessing their attributes:

```java
if(instructor != null && instructor.getName().equals("drew")) {
  System.out.println("davis")
}
```

In this case, if the first operand `instructor != null` is false, then the second operand `instructor.getName().equals("drew")` will not be evaluated. The expression is basically saying "we already know the whole `&&` expression is false, because `instructor != null` is false. Why bother dealing with the second operand?"

This is also important because a `Null Pointer Exception` will be thrown if we try to call a method using "dot notation" on a null Object reference.

## Introduction: Switch Statement (10 mins)

The switch statement can be used for multiple branches based on a number or string:

```java
  String food = "apple";

  switch(food) {
    case "pear":
      System.out.println("I like pears");
      break;
    case "apple":
      System.out.println("I like apples");
      break;
    default:
      System.out.println("No favourite");
  }
//=> I like apples
```

In this case, the `switch` statement compares `food` to each of the cases (`pear` and `apple`) and evaluates the expressions beneath them if there is a match. It uses `String.equals` method in this case, or `==` in the case of primitives, to evaluate equality.

The default clause is optional.

**Note: Breaks are important!** If you don't put a break statement, the expression will continue to be evaluated for each following case. This might cause unintended consequences.

For example if you eliminate the break statements:

```java
  String food = "apple";

  switch(food) {
    case "pear":
      System.out.println("I like pears");
    case "apple":
      System.out.println("I like apples");
    default:
      System.out.println("No favourite");
  }
```

The result would be:
```
I like apples 
No favourite
```
 

If `food = "pear"` then the output would be:

```
I like pears  
I like apples 
No favourite
```

Thi is not exactly what we had intended.

## Demo: Loops (15 mins)


In just about all programming languages, loop-ing exist.  A loop is a statement or block of code that will continue to execute while or until a condition exists.

`while` loops, for example, will run a block of code **while** a condition is `true`.

Java has `while` loops and `do-while` loops.

The `while` loop is good for basic looping, but there's a possibility it will never get run.


```java
while (true) {
  // an infinite loop!
}
```

Using a `do-while` loop makes sure that the body of the loop is executed at least once, because `while()` isn't evaluated until after the block of code runs.

```java
int input = 0;
do {
  System.out.println(input++);
} while (input < 10);
```

You can use looping in combination with iteration: a way of incrementally repeating a task.

For example, using a for loop:

```java
int iterations = 10;
for (int i = 0; i < iterations; i++) {
  System.out.println(i);
}
```

Notice the placement of the comma and semi-colons, and let's take a look at what each of the parts do:

1. `int i = 0;` is the **initialization** phase.
  - This is executed once, before the loop begins.
  - Note that `int i` is declared within this phase. This means that the lifespan of `i` is limited to within the for loop, which is a much cleaner, and leads to less problems down the line.  

2. `i < iterations;` is the **termination** phase.
  - Every time the loop evaluates, it checks this statement.
  - If this statement evaluates to `false`, the loop terminates.
  - This is equivalent to the `while` section of the `do...while` loop.

3. `i++` is the **increment** expression.
  - This happens every time the loop evaluates.
  - This is equivalent to the `do` section of the `do...while` loop.
  - In this case, each loop, `i` is incremented by 1.

In android studio, you can use `fori+TAB` to automatically create an empty `for loop`.

## Fizz Buzz - Independent Practice (15 minutes)

Fizz buzz is a game about division. Create a program that will iterate through numbers from 1 to 101 and log each number in the console.

- In the loop every time a number is divisible by **3**, instead of logging the number itself, the word "fizz" should appear.
- If the number is divisible by  **5**, the word "buzz" should be logged.
- If the number is divisible by both **3** and  **5**, then the word "fizzbuzz" should be logged.

Hint: Remember the _modulus_ operator?

A typical output would look like this:

<img src="https://i.imgur.com/avioQC8.png" width="400px">

#### Solution

```java
for (int i = 1; i < 101; i++) {

  if((i % 3 == 0) && (i % 5 == 0)) {
    System.out.println("fizzbuzz");
  } else if(i % 3 == 0) {
    System.out.println("fizz");
  } else if(i % 5 == 0) {
    System.out.println("buzz");
  } else {
    System.out.println(i);
  }
}
```

## Conclusion (5 mins)
These are some of the foundational tools you'll use in many of your applications. You'll probably need to refresh yourself on the exact syntax a few times before you memorize it, but it's important to be able to remember, these core "control flow" concepts, in general, because they'll come up in pretty much every programming language you'll ever encounter.

- [Control Flow](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
