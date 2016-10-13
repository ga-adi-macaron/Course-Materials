---
title: Interfaces and Abstract Classes
duration: "1:30"
creator:
    name: Alan Caceres
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Classes

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the difference between interfaces and abstract classes
- Describe why we would choose an interface over an abstract class and vice versa.
- Declare and extend an abstract class
- Declare an interface and implement it's required methods.

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
* Recall basic knowledge of Classes
* Recall basic knowledge of method creation

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---

## Opening: Interfaces and Abstract Classes; what are they? (5 minutes)

When we created our classes in the previous lesson we had to implement everything.
We had to set up the template of member variables, the constructors, and the methods.
What if we wanted to just set up the template and not have to do all the work right then and there?
What if we wanted to set it up in a way that allows us to implement multiple classes that do some
logic, just in a different way for each class?
Interfaces and Abstract Classes allow us to do that.



## Introduction: What are Abstract Classes? (20 minutes)

Abstract classes are basically classes that do a bunch of work for us but also asks the developer
to do some work as well.

Let's take a look at an example:


```Java
public class Animal{
  protected String mName = "";
  protected int mNumOfLegs = 4;

  public Animal(String name){
    mName = name;
  }

  public int getNumOfLegs(){
    return mNumOfLegs;
  }

  public void setNumOfLegs(int numOfLegs){
    mNumOfLegs = numOfLegs;
  }

}
```

Let's instantiate this in the main method.



```Java
public class Main{

  public static void main(String[] args){

    Animal aCat = new Animal("cat");
    int numOfLegs = aCat.getNumOfLegs();

  }

}
```

What if we wanted to also find out the sound that the animal makes?
We could just add a method `setSound(String sound)` then have another method to print out the sound. A better way would be to make
the class an abstract class and allow other classes to handle what sound the animal makes.

```Java
public abstract class Animal{

  protected String mName;
  protected int mNumOfLegs;

  public Animal(String name){
    mName = name;
  }

  public int getNumOfLegs(){
    return mNumOfLegs;
  }

  public void setNumOfLegs(int numOfLegs){
    mNumOfLegs = numOfLegs;
  }

  public abstract void speak();

}
```

If we extend this abstract class we will see that we need to implement those abstract methods.
This is the subclassing you learned earlier today, but this makes it slightly more robust.

```Java
public class Dog extends Animal {

    public Dog(){
      super("dog");
    }

    public Dog(String name){
      super(name);
    }

    @Override
    public void speak(){
      System.out.println("woof");
    }

}
```

### Independent Practice(15 min)


Let's go back to the main method and instantiate this Cat class.

```Java
public class Main{

  public static void main(String[] args){

    Animal theAnimal = new Cat();
    int numOfLegs = theAnimal.getNumOfLegs();
    theAnimal.speak(); //This will print out meow
    theAnimal = new Dog();
    theAnimal.speak(); //This can print out woof
  }

}
```

Let's create a few more classes that extend `Animal`.



### What are Interfaces(20 min)

Interfaces are a way to make another programmer do all the work for you. This makes heavy use of a concept called polymorphism.

Unlike classes, interfaces **generally** only contain method stubs, not any actual implementation. By definition, all methods in an interface are abstract. In addition, any fields in an interface must be declared as static and final.

```java
public interface MyInterface {
  void sayHello();
  void sayGoodbye();
}

public class MyClass implements MyInterface{
  //constructors
  ...

  public void sayHello(){
    System.out.println("Hi!");
  }

  public void sayGoodbye(){
    System.out.println("Bye!");
  }
}
```

In Java 8, the concept of default implementations was added. Suppose you created an interface that is used by many classes in a large program, but later on you wanted to add a new method to the interface. If you did this, every single class using this interface would break because they don't have the new method. Instead, you could add a basic default implementation in case the other classes decide not to implement it.

So why we don't just use classes and make all of the methods abstract? One major reason is that you can only extend one class, but you can implement as many interfaces as you want.

The other reason stems from the idea behind why interfaces exist. Subclasses are meant to share common functionality with its parent classes, but have some differentiation between them. Interfaces are a contract for functionality of what a class should be able to do, but two different classes implementing the same interface can be completely unrelated.

You cannot instantiate an interface, but a class that implements one can be considered to be that type of object, just like a subclass can be considered the same type of object as its parent.

Let's take a look at an example:

```Java
public interface Flyable{

 boolean canFly();

}
```

```Java
public interface Swimmable{

  boolean canSwim();

}
```

```Java
public abstract class Animal implements Flyable, Swimmable{
  ...
}

public class Dog extends Animal {
  ...
  public boolean canSwim(){
    return true;
  }

  public boolean canFly(){
    return false;
  }
}
```

Polymorphism is a concept in computer programming that allows a program to ignore what class exactly is calling a method. It does not care what that class is, just that it implements certain methods.

Let's look at another example:

```Java
public class Main{

  public static void main(String[] args){

    List<Animal> animals = new ArrayList<>();

    animals.add(new Dog());
    animals.add(new Cat());
    animals.add(new Bird());
    animals.add(new Mouse());
    animals.add(new Cow());
    animals.add(new Frog());
    animals.add(new Elephant());
    animals.add(new Duck());
    animals.add(new Fish());
    animals.add(new Seal());
    animals.add(new Fox());

    for(Animal animal: animals){
      animal.speak();
      animal.canSwim();
      animal.canFly();
    }

  }

}
```



### Independent practice (15 min)



### Conclusion (5 min)

We created classes, and learned how to subclass other classes for our own purposes in the previous lesson.
In this lesson we learned how to architect our classes in a way that makes subclassing more robust.
We also learned when and why we would use an abstract class over an interface. These are important concepts for everyone to understand and be able to explain the differences between them. Questions regarding polymorphism are standard practice in most programming interviews.
