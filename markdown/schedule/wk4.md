---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

# When solution code is posted, put "&#x2705;" (with the "") in the assignment's note.

week: 4
days:
  - date: Monday, 10/24
    lessons:
      - name: Unit 1 Review Jeopardy
        url: https://www.jeopardy.rocks/adiunit1review
      - name: Intro to Databases
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/databases-intro-lesson
      - name: SQL and SQLite
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/sqlite-lesson
      - name: Intro to Cursors
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/cursors-intro-lesson
    assignments:
      - name: SQLite Lab
        url: https://github.com/ga-adi-macaron/sqlite-lab
      - name: SQL Practice HW
        url: 

  - date: Tuesday, 10/25
    lessons:
      - name: Outcomes - Resumes & Cover Letters
        url: 
      - name: SQLite in Android
        url: 
      - name: Databases w/ RecyclerViews
        url: 
    assignments:
      - name: Databases w/ RecyclerViews Lab
        url: 
      - name: Outcomes Circuit Unit 4
        url: https://circuits.generalassemb.ly

  - date: Wednesday, 10/26
    lessons:
      - name: Intro to Testing
        url: 
      - name: Unit Testing
        url: 
    assignments:
      - name: Unit Testing Lab
        url: 
      - name: User Stories HW
        url: 
      - name: Prep for Enabling Search HW
        url: 

  - date: Thursday, 10/27
    lessons:
      - name: Whiteboarding Morning Exercise
        url: 
      - name: Enabling Search
        url: 
      - name: Detail Views
        url: 
    assignments:
      - name: Enabling Search Lab
        url: 
      - name: Detail Views Lab
        url: 

  - date: Friday, 10/28
    lessons:
      - name: SQL Joins
        url: 
      - name: Constraint Layout
        url: 
    assignments:
      - name: SQL Joins Lab
        url: 
      - name: Constraint Layout Lab
        url: 
      - name: Database Relationships HW
        url: 
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Week {{page.week}}

Assignments must be submitted via pull request by 9:00 am the next class day.

&#x2705; = solution code posted

<table>
<tr><td><b>Date</b></td><td><b>Lessons</b></td><td><b>Assignments</b></td></tr>
{% for day in page.days %}
  <tr>
    <td>{{day.date}}</td>
    <td><ul>{% for lesson in day.lessons %}
      <li>{% if lesson.url %}
        <a href="{{lesson.url}}">{{lesson.name}}</a>
      {% else %}
        {{lesson.name}}
      {% endif %}</li>
    {% endfor %}</ul></td>
    <td><ul>{% for assignment in day.assignments %}
      <li>{% if assignment.url %}
        <a href="{{assignment.url}}">{{assignment.name}}</a>
      {% else %}
        {{assignment.name}}
      {% endif %}{{assignment.note}}</li>
    {% endfor %}</ul></td>
  </tr>
{% endfor %}
</table>
