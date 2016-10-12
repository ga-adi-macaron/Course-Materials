---
title: Singleton Design Pattern
duration: "1:00"
creator:
    name: Charlie Drews
    city: NYC

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Singleton Design Pattern Mini-Lesson

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain the motivation for using the Singleton Design Pattern
- Implement the Singleton Design Pattern

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create classes and subclasses

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---

<a name="opening"></a>
## Opening (5 mins)

We've learned the basic syntax of Java and the mechanisms of inheritance, but now it's time to dive into *design patterns*, which are not a language-specific syntax, but instead a conceptual approach that developers can implement in any object-oriented language.

The *singleton* design pattern is useful when you need to access an instance of a class from multiple scopes, or different sections of your app, but you want changes made in one scope to persist to the other scope. It is also useful when you are dealing with a class that includes a large amount of data that must be loaded into memory each time an instance of the class is created. What might happen to your phones memory and performance if you create many instances of such a class? Would it be beneficial to limit the number of instances?

## Introduction: Static vs Non-Static (10 mins)

In Java, you will occasionally see a modifier on variables and methods called `static`. This means two different things depending on if it's used on a method or variable.

#### Static methods

A static method makes that method accessible without instantiating an object first. We have seen an example of this when using methods from the Math class:

``` java
double myAnswer = Math.sqrt("2");
```

`sqrt()` is a static method within Math.

#### Static variables

Static variables are variables that are only created once in memory across all instances of a class. We will see an example of this in the next demo.

> Check: Ask the students to give an example of a static variable we've used.


<a name="demo"></a>
## Demo: Singleton Design Pattern (20 mins)

One example of using both static methods and variables is in a design pattern called a Singleton. A singleton is a class whose data is only loaded once into memory, but is accessible anywhere an instance of the class is loaded.

Let's pretend a town only has one School, a class we will make that contains teachers and students. We only want one instance of the school.

``` java
public class School{
  private static School school = null;
  private static LinkedList<String> teachers;
  private static LinkedList<String> students;

  private School(){
    teachers = new LinkedList<String>();
    students = new LinkedList<String>();
  
  
  }

  public static School getInstance(){
    if(school == null){
      school = new School();
    
      
    }
    return school;
  
  
  }

  public void addTeacher(String teacher){
    teachers.add(teacher);
  
  
  }

  public void addStudent(String student){
    students.add(student);
  
  
  }

  public LinkedList<String> getStudents(){
    return students;
  
  
  }

  public LinkedList<String> getTeachers(){
      return teachers;
  
  
  }


}
```

```Java
public static void main(String[] args) {
    School school = School.getInstance();
    school.addStudent("Bobby");

    addAnotherStudent();

    System.out.println(school.getStudents());


}

public static void addAnotherStudent(){
    School school = School.getInstance();
    school.addStudent("Joe");


}
```

> Check: Ask the students what would happen if we made addTeacher or addStudent static.

<a name="ind-practice"></a>
## Independent Practice: Make your own Singleton (20 minutes)

Now we are going to practice what we learned today and implement the singleton design pattern. Work alone or in small groups, and create a Singleton class - you can be creative and have it represent a real-world concept, or simply call it "MySingleton" - that's up to you.

In your singleton class:
- Follow the pattern of the *constructor* and `getInstance()` methods in the demo code above
- You don't need to add linked list member variables like the demo, but add a private String member variable and include a getter and setter method for it

Create a Main class:
- Create a `main()` method
- Create a method named `addMessage()`
  - In this method, create an instance of the singleton class
  - Use the object's setter method to save a message to its String variable
- Create a method named `viewMessage()`
  - In this method, create another instance of the singleton class
  - Use the object's getter method to access, then print the value from its String variable
- Finally, in your `main()` method, call both `addMessage()` and `viewMessage()`. Remember that those methods each have their own *scope*. Does the value printed in `viewMessage()` match what you added in `addMessage()` even though they operate in different scopes?

Here, we demonstrated how a singleton can persist data across different *scopes*. In Android, we will use the same approach to persist data across different screens or sections within the app.

> Check: Were students able to create the desired deliverable?

<a name="conclusion"></a>
## Conclusion (5 mins)

You will use the singleton concept frequently in your Android apps. There are many times you will want only 1 instance of a particular class in order to persist data across screens, or sections of your app. In addition, some objects in Android are very large and take up a lot of memory, so limiting them to 1 instance can make your app perform better.
