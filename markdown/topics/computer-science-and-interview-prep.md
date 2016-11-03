---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Computer Science and Interview Preparation
lessons:
  - name: Whiteboarding 101
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-lesson
    date: Monday, 10/17
  - name: Whiteboard Morning Exercise 1
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-morning-exercise-1
    date: Tuesday, 10/18
  - name: Whiteboard Morning Exercise 2 - Recursion
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/recursion-morning-exercise
    date: Wednesday, 10/19
  - name: Whiteboard Morning Exercise 3
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-3
    date: Thursday, 10/27
  - name: Whiteboard Morning Exercise 4
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-4
    date: Monday, 10/31
  - name: Whiteboard Morning Exercise 5
    url: 
    date: Monday, 11/7
  - name: Whiteboard Morning Exercise 6
    url: 
    date: 
  - name: Whiteboard Morning Exercise 7
    url: 
    date: 
  - name: Arrays and Lists
    url: 
    date: 
  - name: Sorting Algorithms
    url: 
    date: 
  - name: Whiteboard Morning Exercise 8
    url: 
    date: 
  - name: Merge Sort
    url: 
    date: 
  - name: Whiteboard Morning Exercise 9
    url: 
    date: 
  - name: Binary Search
    url: 
    date: 
  - name: Big O Notation
    url: 
    date: 
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
