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
      - name: Git & GitHub Lab
        url: https://github.com/ga-adi-macaron/github-lab
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
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/functions-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/cB8Jhr4pxvRR9Ps82
    assignments:
      - name: Data Types & Variables HW
        url: https://github.com/ga-adi-macaron/data-types-and-variables-hw
        note: "&#x2705;"
      - name: Functions & Scope Lab
        url: https://github.com/ga-adi-macaron/functions-lab
        note: "&#x2705;"
      - name: Functions & Scope HW
        url: https://github.com/ga-adi-macaron/functions-and-scope-hw
        note: "&#x2705;"

  - date: Wednesday, 10/5
    lessons:
      - name: Control Flow
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/control-flow
    assignments:
      - name: Advanced Functions Lab
        url: https://github.com/ga-adi-macaron/advanced-functions-lab
        note: "&#x2705;"
      - name: Functions Practice HW
        url: https://github.com/ga-adi-macaron/functions-practice-hw
        note: "&#x2705;"

  - date: Thursday, 10/6
    lessons:
      - name: Data Collections
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-collections
      - name: Debugging Fundamentals
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/debugging-fundamentals-in-java-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/46MZum6u4gUuC6vK2
    assignments:
      - name: Data Collections Lab
        url: https://github.com/ga-adi-macaron/data-collections-lab
        note: "&#x2705;"

  - date: Friday, 10/7
    lessons:
      - name: End of Week Exit Ticket
        url: https://goo.gl/forms/xWTRoRaqnK4DrSgm1
      - name: Project 0 Workshop
    assignments:
      - name: More Functions Practice HW
        url: https://github.com/ga-adi-macaron/more-functions-practice-hw
      - name: "Reading: Intro to OOP Concepts"
        url: https://docs.oracle.com/javase/tutorial/java/concepts/index.html
        note: (no deliverable)
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
