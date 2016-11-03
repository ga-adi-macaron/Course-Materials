---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Databases
lessons:
  - name: Databases Intro
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/databases-intro-lesson
    date: Monday, 10/24
  - name: SQL and SQLite
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/sqlite-lesson
    date: Monday, 10/24
  - name: Intro to Cursors
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/cursors-intro-lesson
    date: Monday, 10/24
  - name: SQLite in Android
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/sql-in-android-lesson
    date: Tuesday, 10/25
  - name: Databases w/ RecyclerViews
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/database-recyclerview-lesson
    date: Tuesday, 10/25
  - name: Detail View Lesson
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/detail-view-lesson
    date: Thursday, 10/27
  - name: SQL Joins
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/joins-lesson
    date: Friday, 10/28
  - name: Content Providers
    url: 
    date: 
  - name: External Content Providers
    url: 
    date: 
  - name: Firebase
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
