---
title: Subclassing
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Subclassing


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what subclassing means
- Explain how subclassing works in Java
- Extend a class using Java

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create a basic class with getters and setters
- Instantiate a user-defined class

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 20 min  | [Introduction](#introduction-subclassing-20-mins)  | Subclassing |
| 15 min  | [Demo](#demo-topic-15-mins)  | Topic |
| 30 min  | [Guided Practice](#guided-practice-subclassing-30-mins)  | Subclassing |
| 15 min  | [Independent Practice](#independent-practice-subclassing-cards-15-minutes)  | Subclassing Cards |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

Today we will be expanding upon our last lesson about classes. We learned about the basic components of a class and how they are created, but they can do so much more. We will be learning about how classes interact with each other, and more specifically, how they are related to each other.

> Check: Ask students to define what a class is, and how to instantiate one.

***

<a name="introduction"></a>
## Introduction: Subclassing (20 mins)

One of the key ideas behind Object-Oriented Programming is defining relationships between the classes you create. In OOP, we create templates that can be reproduced and interacted with. A subclass can be thought of as a more detailed version of a class you have already created.

For instance, a NormalUser and an Admin can both be considered a subclass of a User. We can say that a NormalUser `is a` User, and that an Admin `is a` User. We could simply make the properties and methods inside of User for every type of User, but our code becomes much clearer if we make a separate subclasses to represent each specific type of User.


```java
List<String> myList = new ArrayList<>();
```



<a name="demo"></a>
## Demo: Subclassing (15 mins)

Do this with me!

We're going to start with the example of shapes. First, let's define our Shape class with the property "mColor":

``` java
public class Shape {
  private String mColor;

  public Shape(String color){
    mColor = color;
  }

  public String getColor(){return mColor;}
}
```

When designing classes and subclasses, you need to ask yourself what properties or methods are unique to the subclass and what are common across all possible subclasses. In the case of our example, every type of shape has a color, so we include it in the superclass.

Now we're going to make a subclass, Square. A Square is a Shape, so we can make it a subclass:

There are some important keywords to notice:

- The `extends` keyword denotes that we are subclassing __Shape__ for this class. (Making __Shape__ our superclass)
- The `super` keyword is used to access members from the superclass, such as the constructor

Note that we must call the super constructor so the parent class can do the setup work required. This must be the first statement in the constructor.

``` java
public class Square extends Shape {
  private int mSideLength;

  public Square(int length, String color){
    super(color);
    mSideLength = length;
  }

  public int getArea(){
    return mSideLength * mSideLength;
  }
}
```

Now we will make a Triangle class that will still be a Shape, but have different behavior.

``` java
public class Triangle extends Shape {
  private int mSideLength1;
  private int mSideLength2;
  private int mSideLength3;

  public Triangle(int length1, int length2, int length3, String color){
    super(color);
    mSideLength1 = length1;
    mSideLength2 = length2;
    mSideLength3 = length3;
  }

  public double getArea(){
    double p = 0.5 * (mSideLength1 + mSideLength2 + mSideLength3);
    return Math.sqrt(p*(p-mSideLength1)*(p-mSideLength2)*(p-mSideLength3));
  }
}
```

What we have covered so far are all of the basics you need to build a class and create a subclass using it.



<a name="guided-practice"></a>
## Guided Practice: Subclassing (30 mins)


This is a tricky topic, so let's get some more guided practice.  Follow along:
Let's write a __Vehicle__ class with the  `mModel` and `mSpeed` member variable which are assigned on instantiation of the __Vehicle__.  How might we do that?

``` java
public class Vehicle {
    private float mSpeed;
    private String mOwnerName;

    public Vehicle(String ownerName) {
        mOwnerName = ownerName;
        mSpeed = 0.0f;
    }

    public void goFaster(){
      mSpeed += 5.0;
    }

    public void setSpeed(float speed){
      mSpeed = speed;
    }

    public float getSpeed(){return mSpeed;}
}

// creating a new object of type Car
Vehicle mFirstCar = new Vehicle("Civic");
```

That is a good start, but we can create a subclass of __Vehicle__ to get a more specific Vehicle.

So instead lets create a `class` __Car__ with all the properties we want:

```java
public class Car extends Vehicle {
    private boolean mIsManual;
    private String mModel;

    public Car(String modelName, String ownerName, boolean isManual) {
        super(ownerName);
        mModel = modelName;
        mIsManual = isManual;
    }

    public int getManual(){return mIsManual;}

    public String getModel(){return mModel;}

    @Override
    public void goFaster(){
      setSpeed(getSpeed() + 10);
    }
}
```

Why can we call the method goFaster in Car the same thing as Vehicle? This is called overriding a method, and is a key concept in OOP. Sometimes we want subclasses to have behavior that is different from its parent. If we call goFaster on a car, it will increase the speed by 10, but if we call it on a Vehicle it will only increase the speed by 5.

The Override annotation isn't required, but is a useful check to make sure you are properly overriding the parent method (same name and parameters).

Java provides us with an important concept in OOP. Inheritance. When we subclass the __Vehicle__ our __Car__ class will **inherit** all the methods and variables contained within:

```java
public class Main {
  public static void main(String[] args){
    Car myCar = new Car("Civic","Drew",false);
    myCar.goFaster();
    System.out.println(myCar.getSpeed());
  }
}  

```

We call the constructor of __Car__ with our model name and owner name using the method call `super()`. This way now every `new` Car object will have its model name and owner name set correctly.

In practice, we can now use Car everywhere we use Vehicle but not the other way around. Think of it in the way all Squares are Shapes but not all Shapes are Squares.

```java

Vehicle myCar2 = new Car("CR-V","Drew");

```

To use Car's methods, we need to cast it.

```java
System.out.println("Is Manual: "+((Car)myCar2).isManual());

```

```java
List<Vehicle> myVehicles = new ArrayList<>();

Car car1 = new Car("Civic","Drew");
myVehicles.add(car1);

Vehicle vehicle1 = new Vehicle("Bob");
myVehicles.add(vehicle1);

for (int i = 0; i < myVehicles.size(); i++) {
    myVehicles.get(i).isManual();
}
```


<a name="ind-practice"></a>
## Independent Practice: Subclassing Cards (15 minutes)

> Instructor Note: This can be a pair programming activity.

Now, you are going to try implementing your own class and subclasses. Create a new project:

- create a superclass Card and subclasses DebitCard and CreditCard
- give your superclass the properties "nameOnCard" and "cardBrand" (Visa, Mastercard, etc.)
- CreditCard should contain the property "cardLimit", and DebitCard should have the property "accountBalance"
- Add any other properties you want
- Instantiate your Classes and print out their member variables in a main method



<a name="conclusion"></a>
## Conclusion (5 mins)

Today we gained a further understanding of how multiple classes can fit together to make a useful system that reduces code duplication and makes your code much easier to understand. You can have many levels of subclasses beyond the simple two-level examples we saw today. Hopefully the concepts you learned today helps you to create more complex and better structured apps.

### ADDITIONAL RESOURCES
- [Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
