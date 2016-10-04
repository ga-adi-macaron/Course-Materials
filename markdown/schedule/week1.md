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
      - name: Welcome to ADI!
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/orientation-materials/welcome-to-adi
      - name: Command Line
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/os-navigation-lesson
      - name: Git & GitHub
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/git-github-lesson

    assignments:
      - name: Command Line Lab
        url: https://github.com/ga-adi-macaron/command-line-lab
        note:
      - name: Git & GitHub Lab
        url: https://github.com/ga-adi-macaron/github-lab
        note:
      - name: Android SDK Installation
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/sdk-installation
        note: (no deliverable)

  - date: Tuesday, 10/4
    lessons:
      - name: Intro to Android
        url: https://github.com/ga-adi-gelato/Course-Materials/tree/master/lessons/orientation-materials/android-intro-lesson
      - name: Data Types & Variables
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-types-and-variables
      - name: Functions & Scope
        url:
    assignments:
      - name: Data Types & Variables HW
        url:
      - name: Functions & Scope Lab
        url:
      - name: Functions & Scope HW
        url:

  - date: Wednesday, 10/5
    lessons:
      - name: Outcomes
      - name: Control Flow
        url:
    assignments:
      - name: Advanced Functions Lab
        url:
      - name: Functions Practice HW
        url:

  - date: Thursday, 10/6
    lessons:
      - name: Debugging Fundamentals
        url:
      - name: Data Collections
        url:
    assignments:
      - name: Data Collections Lab
        url:

  - date: Friday, 10/7
    lessons:
      - name: None (Project 0 Workshop)
        url:
    assignments:
      - name: More Functions Practice HW
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
