---
title: Classes
duration: "1:30"
creator:
    name: Alan Caceres
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Classes

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what classes and objects are
- Describe what object properties and methods are
- Demonstrate and explain instantiation
- Write getter and setter methods for a given class

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
* Recall basic knowledge of variables
* Recall basic knowledge of Java data types
* Recall basic knowledge of method creation

---

## Opening: What are classes? (5 minutes)

In computer programming, there is this concept called Object Oriented Programming. It is where we as programmers want to break up the logic for some complex idea into smaller more manageable, meaningful and reusable parts. These reusable parts are what we call *Objects*. In Java, almost every data type we've used is an extension of the *Object* class.

## Introduction: What are classes? (15 minutes)

Objects are special pieces of data that have properties and functions contained inside of them. We use these objects to divide our code into separate responsibilities. We can then use these objects from other code to execute their responsibility. How the object accomplishes its responsibility is irrelevant to the calling code. We'll call this a black box. We don't care how it works, as long as it reliably gives us the right answer.

We only have to worry about the inputs and outputs of the object, and let the object worry about itself and how it works. For example, with a `String` object we are able to call the `.split()` method to break it into substrings (e.g. `myString.split(",")` would break the string apart at each comma). We don't care *how* it breaks apart the String, just that it reliably returns the correct result.

This has an advantage for whomever is implementing the object as well. They can change the internals, perhaps make it more efficient, without breaking compatibility with any code that uses it already.

We give these objects a template using the concept of `classes`. A `class` is a special *type* that can be user-defined to ensure every object of its type contain all the properties and methods of that class. Unlike data types which have intrinsic value - i.e an `int` is a number, `char` are characters - classes have programmer-defined values. For example, a __Car__ class could hold the `double` value of __speed__ and also `String` value of __model__.

> Check: In your own words, explain what is an object? What is a class?

## Introduction: Instantiating an Object (10 minutes)

Creating an object of a class is called *instantiation*. This means we are creating a new object in memory. This is done by using the `new` keyword and a special thing called a **_constructor_**. Constructors are like a method whose name _exactly_ matches the name of the class. They can include some parameters that we can pass to our new object. They set up the initial state of the object.

Constructors are used only when an object is instantiated. Their sole purpose is to help create an instance of a class. In contrast, the purpose of methods is much more general: execute Java code. Note the difference between constructors and methods.


## Demo: Defining a Class (10 minutes)

The paradigm of Object Oriented Programming allows programmers to compartmentalize specific bits and pieces of code so that we can reuse this code while also hiding parts of it within each class. In the __Car__ example, we can create new Cars and give them different model names but have an internal concept of _speed_ that only the Car itself is aware.

Variables and other objects defined within an class are known as attributes or **_member variables_**. Java convention dictates that these variables be named in camel case starting with an 'm' denoting that it is a **_member variable_**.

Functions defined within a class are known as **_methods_**. Java convention dictates that methods also be named in camel case. Since methods are the actions your object can perform, best practice is to put a verb in your method names which clearly explains what the method does.

``` java
public class Animal {
    String mName;
    float mWeight;

    public Animal(String name,float weight) {
        mName = name;
        mWeight = weight;
    
    }

    public float getWeight(){
      return mWeight;
    
    }

    public float setWeight(float weight){
      mWeight = weight;
    
    }

}

// creating a new object of type Animal
Animal aMoose = new Animal("Moose", 500.0f);
```

> Check: What are methods? How should they be defined and written?

## Guided Practice: Defining a Class (10 minutes)

Ok, time for you to write your own class!

Create a new class using the syntax your learned above. Your class should be modeling a __Color__ object. Your __Color__ must have a name.  All of these must be set during construction.
``` java
public class Color {

    String mName;

    public Color(String name) {
        mName = name;
    
    }

}
```
> Note: do a few more examples.

In basic Java programs, you need a `static main()` method to be able to run the program, instantiate a `Color` object inside the main method in your Main.java class.

```java
public static void main(String [] args) {

}
```

Inside of this method, instantiate a Color object with a name:


```java
    public static void main(String [] args)
{
        Color pink = new Color("pink");
    
}
```

## Introduction: Getters and setters (5 minutes)
In Java, there is a convention used called _getters and setters_. It is not always a good idea to make _member variables_ public and so instead methods are defined to allow access.

By definition, getters "get" or return stored information from an instance of a class; setters assign information / data to an instance of a class.

## Demo: Getters and setters (5 minutes)

In our color object, we simply want to allow read access to the mName variable and so we would define a method called `getName()` within our `class`.

```java
public String getName() {
  return "The name of this color is " + mName;

}
```
Java naming convention dictates that getters should start with 'get' and then the name of the variable (minus any leading letters). The only exception is for getters with return type `boolean`, it is convention to name these as `isBoolean()` or `hasBoolean()`. For example our car might have a method: `hasLowFuel()`.

Perhaps we also to allow public access to change the `mName` variable, we would define a setter. The naming convention here is similar to the getter methods but with starting with 'set'

```java
public void setName(String name) {
    mName = name;

}
```

> Check: In your own words, write down the difference between getters and setters.

## Independent Practice: Getters and Setters (10 minutes)

Create a few more classes with a constructor, getters, and setters.

### Conclusion (5 minutes)

Throughout much of our work so far in this course, we have seen classes being used, and object being instantiated without understanding the reason behind all of it. Hopefully today's lesson helped clarify the mystery behind the code being automatically generated by IntelliJ. In an upcoming lesson, we will be discussing the `extends` keyword which allows us to copy a class and it's accessible variables and methods to allow us to modify a class we might otherwise not be able to modify. This is a concept known as subclassing.

### ADDITIONAL RESOURCES
- [Classes & Objects](http://www.javawithus.com/tutorial/class-as-a-reference-data-type)
- [Java Getters vs Setters](http://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work)
