---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Programming Fundamentals in Java
lessons:
  - name: Data Types and Variables
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-types-and-variables
    date: Tuesday, 10/4
  - name: Functions and Scope
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/functions-lesson
    date: Tuesday, 10/4
  - name: Control Flow
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/control-flow
    date: Wednesday, 10/5
  - name: Data Collections
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-collections
    date: Thursday, 10/6
  - name: Organizing Information
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/organizing-info-lesson
    date: Tuesday, 10/11
  - name: Classes
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/classes-lesson
    date: Tuesday, 10/11
  - name: Singleton Design Pattern
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/singleton-design-pattern
    date: Wednesday, 10/12
  - name: Functions Morning Exercise
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/functions-morning-exercise
    date: Thursday, 10/13
  - name: Subclasses
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/subclassing-lesson
    date: Thursday, 10/13
  - name: Interfaces & Abstract Classes
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/interfaces-and-abstract-classes
    date: Thursday, 10/13
  - name: Recursion
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/recursion-morning-exercise
    date: Wednesday, 10/19
  - name: Error Handling with Try/Catch
    url: 
    date: Thursday, 11/17
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) {{page.title}}

<ul>
  {% for lesson in page.lessons %}
  <li>
    {% if lesson.url %}
      <a href="{{lesson.url}}">{{lesson.name}}</a>
    {% else %}
      {{lesson.name}}
    {% endif %}
    {% if lesson.date %}
      ({{lesson.date}})
    {% endif %}
  </li>
  {% endfor %}
</ul>

