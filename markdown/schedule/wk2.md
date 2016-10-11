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
        url: 
      - name: Exit Ticket
        url: 
    assignments:
      - name: Organizing Information Lab
        url: https://github.com/ga-adi-macaron/Organizing-Info-Lab
      - name: Classes Lab
        url: 
      - name: Classes HW
        url: 

  - date: Wednesday, 10/12
    lessons:
      - name: Debugging in Android Studio
        url: 
      - name: Intro to XML
        url: 
    assignments:
      - name: XML HW
        url: 

  - date: Thursday, 10/13
    lessons:
      - name: Singleton Design Pattern
        url: 
      - name: Subclassing
        url: 
      - name: Interfaces & Abstract Classes
        url: 
      - name: Exit Ticket
        url: 
    assignments:
      - name: Subclassing Lab
        url: 
      - name: Interfaces & Abstract Classes Lab
        url: 
      - name: Subclasses, Abstract Classes, Interfaces HW
        url: 

  - date: Friday, 10/14
    lessons:
      - name: End of Week Exit Ticket
        url: 
      - name: Views 101
        url: 
      - name: Views 102
        url: 
      - name: Activities & Intents
        url: 
    assignments:
      - name: Views Lab
        url: 
      - name: Activities & Intents Lab
        url: 
      - name: OOP Assessment
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
