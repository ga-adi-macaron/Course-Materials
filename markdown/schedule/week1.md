---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

# When solution code is posted, put "&#x2705;" (with the "") in the assignment's note.

week: 1
days:
  - date: Monday, 10/3
    lessons:
      - name: Command Line
        url: 

      - name: Git & GitHub
        url: 

    assignments:
      - name: Command Line Lab
        url: 
        note: 

      - name: Git & GitHub Lab
        url: 
        note:

      - name: Android SDK Installation
        url: 
        note: (no deliverable)

      - name: Optional command line setup
        url:
        note: (no deliverable)

  - date: Tuesday, 10/4
    lessons:
      - name: Intro to Android
      - name: Data Types & Variables
      - name: Functions & Scope
    assignments:
      - name: Data Types & Variables Lab
      - name: Functions & Scope Lab
      - name: Functions & Scope HW

  - date: Wednesday, 10/5
    lessons:
      - name: Control Flow
    assignments:
      - name: Advanced Functions Lab
      - name: Functions Practice HW

  - date: Thursday, 10/6
    lessons:
      - name: Debugging Fundamentals
      - name: Data Collections
    assignments:
      - name: Data Collections Lab

  - date: Friday, 10/7
    lessons:
      - name: None (Project 0 Workshop)
    assignments:
      - name: More Functions Practice HW
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Week {{page.week}}

Assignments must be submitted via pull request by 9:00 am the next class day.

&#x2705; = solution posted

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
