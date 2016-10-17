---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

# When solution code is posted, put "&#x2705;" (with the "") in the assignment's note.

week: 2
days:
  - date: Monday, 10/10
    lessons:
      - name: Columbus Day

  - date: Tuesday, 10/11
    lessons:
      - name: Week 1 Review
        url: https://www.jeopardy.rocks/adigelatoweek1
      - name: Organizing Information
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/organizing-info-lesson
      - name: Classes
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/classes-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/emSEAkLL78whkIjh1
    assignments:
      - name: Organizing Information Lab
        url: https://github.com/ga-adi-macaron/Organizing-Info-Lab
        note: "&#x2705;"
      - name: Classes Lab
        url: https://github.com/ga-adi-macaron/classes-lab
        note: "&#x2705;"
      - name: Classes HW
        url: https://github.com/ga-adi-macaron/classes-hw
        note: "&#x2705;"

  - date: Wednesday, 10/12
    lessons:
      - name: Singleton Design Pattern
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/singleton-design-pattern
      - name: Debugging in Android Studio
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/debugging-in-android-lesson
      - name: Intro to XML
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/xml-lesson
    assignments:
      - name: XML HW
        url: https://github.com/ga-adi-macaron/xml-intro-hw
        note: "&#x2705;"

  - date: Thursday, 10/13
    lessons:
      - name: Functions Morning Exercise
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/functions-morning-exercise
      - name: Subclassing
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/subclassing-lesson
      - name: Interfaces & Abstract Classes
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/interfaces-and-abstract-classes
      - name: Exit Ticket
        url: https://goo.gl/forms/dimWrh9eTxrv6gd02
    assignments:
      - name: Subclassing Lab
        url: https://github.com/ga-adi-macaron/subclassing-lab/
        note: "&#x2705;"
      - name: Interfaces & Abstract Classes Lab
        url: https://github.com/ga-adi-macaron/abstract-classes-and-interfaces-lab/
        note: "&#x2705;"
      - name: Subclasses, Abstract Classes, Interfaces HW
        url: https://github.com/ga-adi-macaron/subclasses-abstract-classes-interfaces-hw
        note: "&#x2705;"
      - name: Outcomes Circuit Unit 1
        url: https://circuits.generalassemb.ly

  - date: Friday, 10/14
    lessons:
      - name: End of Week Reflection Survey
        url: https://goo.gl/forms/tlz8cFz1i76Cz1wF3
      - name: Views 101
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/views-101-lesson
      - name: Views 102
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/views-102-lesson
      - name: Activities & Intents
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson
    assignments:
      - name: Views Lab
        url: https://github.com/ga-adi-macaron/Views-Lab
        note: "&#x2705;"
      - name: Activities & Intents Lab
        url: https://github.com/ga-adi-macaron/activities-and-intents-lab
        note: "&#x2705;"
      - name: OOP Assessment HW
        url: https://github.com/ga-adi-macaron/oop-assessment
        note: "&#x2705;"
      - name: Outcomes Circuit Unit 2
        url: https://circuits.generalassemb.ly
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
