---
title: Data Types and Variables
duration: "1:30"
creator:
    name: Kristen Tonga
    city: NYC
---


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Data Types and Variables


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Identify what Java data type to use in specific situation and why you chose the specific data type over another.
- Describe the different types of variables (locals, instance, constants) and when to use them
- Use variables to perform a simple task with Math and String classes

---
<a name="opening"></a>
## Opening (5 min)

In our daily lives, we have different methods of storing things for use later on.
Some form of organization.

These things could be anything from toys, to clothes, to money, and many other things; 

In software development these are considered `data types`.

In the real world we store these `data types` in either, boxes, or garages, or some sort of container. 

Computers store these `data types` in what are known as `variables`. Who has moved recently? Did you put things in boxes and label them? Well then you've been dealing with data types and variables all along.

Today we are going to be exploring how data types and variables are the building blocks of basic programming. 


## Introduction: Data types in Java (10 mins)

#### Describe a real world situation where students have been using data types and variables: 
- Putting things in boxes(data types): 
    Data types are simply the computer's way of categorizing the data we use in programming. Just like putting things in a box, there is a set size that you cannot go over with data types. Each data type has a limit to the value we can assign it.
    
- Labeling something(variables):
    Variables are the labels we put on the boxes so we know which box has the data we want. Depending on the data type we can do certain things to the variable. (Frying pan vs Cardboard box)


|Category    | DataType                     | Description          | Example |
|------------|------------------------------|----------------------|---------|
|True/False  | boolean, Boolean                   | Represents either true or false                               |true, false|
|Integers    | short, int, Integer, long, Long    | Whole numbers, with no delimiter. Can optionally have underscores to make large numbers easier to read	| 42, 1024, 1\_000\_000 |
|Decimals    | float, Float, double, Double       | Decimals, with no delimiter                                   | '42.123', 2.5' |
|Characters  | char                               | Single character, surrounded by single quotes                 | 'a', 'A'|
|Strings     | String                             | Anything, surrounded by double quotes, with some exceptions        | "lots of kittens", "a lazy lizard", "", "10", "$"    |                                                                | true, false


There are also a few odd ones:
- Byte, which is one 8-bits of data. You don't need to worry about it right now.  
- Collections (we'll talk more about this Week 3)

We'll dig deeper into all of the categories on the board, and show you how to manipulate them.

> Check: What are a few examples of data and what data type do they fall into?

## Demo: Lets start with Numbers (15 mins)

#### Starting an IntelliJ Project

Steps to Create a new IntelliJ Project: Create New Project > Next > Check the "Create project from template" box > Select "Command Line App" > Next > Pick name & location > Finish.
You are given a class that is named the same as the file with a `main` method inside it.

Note: What does the `//` mean?  This represents a comment.
You can also replace `//` with a multi-line comment `/* write your code here */`.
Comments are used to clearly articulate what your code is doing so that other developers can easily jump into a project and understand what's going on.

We'll talk more about all of these pieces later, for now, write your code directly within the main method, where the comment says, `//Write your code here`.

#### Declaring and Assigning

First lets talk a bit about syntax.
Programming languages, and languages in general, have a certain syntax that should be followed in order to create a valid "sentence".
In Java there is a specific syntax for creating variables.

```java
int num1 = 5;
```

This "sentence" does two things:
- Declare a variable named `num1` with type `int`
- Assign the value `5` to that variable

It's important to know that `=` does not mean "equals" like it would in a math class, but rather it is the *assignment operator*.
It is used to assign the value on its right to the variable on its left.

#### Decimals vs Integers

Ok, lets talk a bit about those number data types.
What do you expect to be printed to the console?

```java
int num1 = 5;
System.out.println("num1, type int = " + num1);
---
$ num1 = 2;
```

How about here?

```java
int num2 = 5 / 2;
System.out.println("num2, type int = 5/2 = " + num2);
---
$ num2 = 2
```

But Why is `num2` not 2.5?
Well, in Java (unlike JavaScript, Ruby or PHP) numbers are strictly typed, and a type is either an integer or decimal.
An int stores a integer, not a decimal, as demonstrated in the previous function.

So, what type of variable would we use if we wanted to assign a decimal number?
How about a float?

```java
float num3 = 5 / 2;
System.out.println("num3, type float = 5/2 = " + num3);
---
$ num3 = 2
```

> Check: That didn't work quite as expected. Can anyone guess why?

Because both 5 and 2 are automatically assigned data type int, when the calculation is done the answer is also an int: `float a = (float) (int a = int b / int c);`.
We must tell the computer that the divisors are of a decimal type, not an integer type.

```java
float num4 = 5f / 2f;
System.out.println("num4, type float = 5f/2f = " + num4);
---
$ num4 = 2.5
```

```java
double num5 = 5d / 2d;
System.out.println("num5, type double = 5d/2d " + num5);
---
$ num5 = 2.5
```

Note: In the previous example, we used both a float and a double data type to save decimal numbers.  

> Check: What is the difference between float and double and which should you use?

#### Number data types and Bits

To answer this question, it is helpful to understand that a data type defines not only the type of data but also the methods that can be used to manipulate that data.
The *primitive* data types in Java also has a certain pre-assigned size in memory.
This is represented in a number of bits.

| Name  | Width in bits | Range    |
|-------|---------------|----------|
| float   | 32          | 3.4e–038 to 3.4e+038 |
| double  | 64          | 1.7e–308 to 1.7e+308 |

More memory means more information can fit into that variable.
Double's are much larger than floats.
What does that mean for working with decimals?
Floats are more memory efficient, and doubles provide more accuracy.

Double's are recommended for currency and where accuracy is important.
There is also a `BigDecimal` class, used when even more decimal points are needed.

The same data type differentiation exists in Integers between shorts (did you notice it in our list), ints and longs.

| Name  | Width in bits | Range    |
|:-------:|:---------------:|:----------:|
| byte  | 8				| -128 to 127 |
| short | 16           | -32,768 to 32,768                  |
| int   | 32           | -(2^31) to 2^31 (approx 2 billion) |
| long  | 64           | -(2^63) to 2^63                    |

`int` will cover almost all of your Integer needs.

> Check: What is the most common data type for decimals? What is the most common data type for integers?


#### Using Standard Arithmetic Operators

Now that we understand a bit more about the Number data types, lets look a bit at what we can do with them.

Here are the standard arithmetic operators that you've been learning since grade school:

``` java
System.out.println(2 + 2);
System.out.println(2 - 2);
System.out.println(2 / 2);
System.out.println(2 * 2);
System.out.println(2 % 2); // What does this do??
```

## Demo: Using Math Methods (10 mins)

Programming languages can be a little stingy with the number of operations they allow you to do.
For example, how do you square or cube a number?
There is a special 'Math' Object, provided by Java, that has some very useful methods.

Raising a number to a power? Use `Math.pow(num1,num2)`.

``` java
// 3^2 becomes
System.out.println( Math.pow(3,2) );
---
$ 4
```

Taking a square root? Use `Math.sqrt(num1)`.

``` java
// √(4) becomes
Math.sqrt(4);
---
$ 2
```

Need a random number? Use `Math.random()`.

``` java
// returns double value with positive sign greater than or equal to 0.0 and less than 1.0
Math.random() // returns random number in range
int max = 10;
int min = 20;
int range = Math.abs(max - min) + 1;
(Math.random() * range) + min;
```

>Check: Who provides the Math object? Where do you think you might be able to find more information?  ([Oracle Math Documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html))

## Introduction: Primitives vs. Objects (10 mins)

Before we get into Strings, let's take a step back.
Have you noticed that all the data types we've used so far are lowercase?
What do you notice about the `String` data type?

Do you notice that it is capitalized?
This is a naming convention that is used to distinguish between primitive and Object data types.

**Primitive data types** are just a value, nothing more. A variable of a primitive type holds a value, but has no methods or "actions" you can tell it to do.

**Object data types** contain attributes and methods, and start with a capital letter.
_Attributes_ are values that live inside the object.
A single Object is capable of holding many different values.
_Methods_ are actions the object can take.
An Object includes instructions for how to carry out various actions.

A primitive variable holds the primitive value itself. An Object variable, however, doesn't hold all the attributes and methods of the Object. Instead, an Object variable holds a _reference_ to the place in memory where the Object is stored.

> Check: Discuss with the person next to you: What does a primitive contain? What does an object contain?  What's one easy way to tell the difference between an Object and a primitive data type? Be ready to share out!

#### Words: char and Strings

With that basic introduction to the two sorts of data types, primitives and Objects, lets talk about words.

A `char` is a primitive data type.  What is an example of a `char`?

``` java
char myChar = 'a';
myChar = 'b';
myChar = '5';
myChar = ';';
```

A String is capitalized because a String is an Object.

Strings are collections of letters and symbols known as *characters*, and we use them to deal with words and text.

Strings are special - String is actually a array of 'char' data:

``` java
String str = "abc";
// is actually
char data[] = {'a', 'b', 'c'};
```

## Demo: Creating a new string (15 mins)

Strings are a weird type of Object.
You can instantiate (i.e. create an instance of) a String in a few ways:

``` java
//variable can be assigned like a primitive
String a = "I'm a string."
```

Which is really short for:

``` java
//variable assigned like an Object
String a = new String("I'm a string too!")
```

#### String helper methods

Because a String is an Object, it has pre-defined methods we can use.

To find the length of a string, use it's `length` property:

```java
"hello".length();
---
$ 5
```

To get the first letter of a String:

```java
"hello".charAt(0);
---
$ "h"
```

To replace part of a String:

```java
"hello world".replace("hello", "goodbye");
---
$ "goodbye world"
```

To make a String uppercase:

```java
"hello".toUpperCase();
---
$ "HELLO"
```

To add two Strings together:
```java
"hello".concat(" world");
---
$ "hello world"
```

Remember, Strings are special Objects that look like primitives. Use the `str1.concat(str2)` function.
Or concatenate (add together) using `+` :

```java
String twoStringsTogether = "Hello" + " World";
---
$ "Hello World"
```

> Instructor Note: Introduce other methods as seen fit.  May want to explain when concatenation might be used.

##### A special note on Equality among Strings:

What if you want to compare two strings?

Can you remember from the pre-work how to compare variables?

```java
boolean areEqual = (1 == 2);
---
$ false
```

What's special about strings?

```java
String blue = "blue";
boolean withSign = (blue == "blue");            //=> true
boolean withWords = (blue).equals("blue");      //=> true
```

Do you know which one of these would be preferred? Well, lets do another example to show you which and why:

```java
String blue = "blue";

String bl = "bl";
String ue = "ue";
System.out.println(bl+ue);                    //=> blue

boolean withSign = (bl+ue == blue);
System.out.println(withSign);                 //=> false

boolean withWords = (bl+ue).equals(blue);
System.out.println(withWords);                //=> true
```

Why isn't `withSigns` true?
The output of `println()` looks the same.
Remember, Strings are Objects, so what a String variable actually holds is a _reference_ to where the String value is stored in memory.

`==` compares the values held by the variables to its left and right.
`(bl+ue) == blue` is comparing the reference held by 'blue' to the result of evaluating `(bl + ue)`.
The latter references a different location in memory than the former, so the comparison yields false.

`equals()`, on the other hand, doesn't just look at the reference held in each variable, it _follows_ each reference and looks at the attributes within the Objects that the variables reference. In the case of Strings, it compares the underlying `char` arrays to see if they're the same.

The long and short of it is: use `equals()` when comparing Strings or any other non-primitive Objects. Use `==` when comparing primitives.

> Check: Why can we call methods on a variable with data type String but not on an int?


## Demo: Converting between data types (10 mins)

Sometimes it is necessary to convert between data types.  User input is _always_ a String - like when you enter your email address, age, income, etc.  If you'd like to operate on those numbers though, you'll have convert it to a type of number.

Remember how we talked about the size of primitive data types? An float is smaller than a double, and a double smaller than a long?

When converting from smaller types to larger types, for example, int(4 byte) to double(8 byte), conversion is done automatically. This is called **implicit casting**.

```java
int a = 100;
double b = a;
System.out.println(b);    // 100.0
```

If, on the other hand, you are converting from a bigger data type to a smaller data type, for example, a double(8 byte) to an int(4 byte), the change in data type must be clearly marked. This is called **explicit casting**.

```java
double a = 100.7;
int b = (int) a;
System.out.println(b);  // 100
```

While that is useful for numbers, to cast successfully, a variable must be an **instance of** that second Object.
What do you think would happen if you tried to cast a String to an int?

There is a different way to convert Strings to numbers.

Did you notice that there is both an `int` and an `Integer` data type? The `Integer` data type is an Object "wrapper" around an int that provides certain methods.
For example, to convert an String to an Integer, one can use:

```java
String strValue = "42";
int intValue = new Integer(strValue).intValue();
```

Similar methods exist for all of the wrappers.

#### NaN

If a String is converted to a number but contains an invalid character, the result of the conversion will be **NaN**, which stands for: Not A Number.

NaN is toxic, and if a calculation is attempted on that variable or a method called subsequently, your program will break.

Test for NaN using `isNaN()`.

#### Null

A null value is an empty value.  Taken from a StackOverflow post:

"Zero is a value. It is the unique, known quantity of zero, which is meaningful in arithmetic and other math."

"Null is a non-value. It is a placeholder for a data value that is not known or not specified. It is only meaningful in this context."

> Check: When might you get NaN value?  What is a null value, by the way?

<a name="ind-practice"></a>
## Independent Practice: Practice! (15 minutes)
> Instructor Note: This can be a pair programming activity or done independently.

Open the IntelliJ project found in `starter-code` and complete all tasks specified in the comments. We will go over the answers in 12 minutes.

> Check: Were students able to create the desired deliverable(s)? Did it meet all necessary requirements / constraints?


<a name="conclusion"></a>
## Conclusion (5 mins)

- Identify the different types of data
- What type of data do you think is passed as a web request?


### ADDITIONAL RESOURCES
- [Oracle Java Docs on Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Oracle Java Docs on Math Object](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html)
