---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

# When solution code is posted, put "&#x2705;" (with the "") in the assignment's note.

week: 3
days:
  - date: Monday, 10/17
    lessons:
      - name: Outcomes - Intro to Tech Industry
        url: https://github.com/ga-adi-macaron/Course-Materials/blob/master/lessons/outcomes/intro-to-tech-industry/ADI-Intro-to-Tech-Industry.pdf
      - name: Whiteboarding 101
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-lesson
      - name: Layouts
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/layouts-lesson
      - name: ListViews
        url:
    assignments:
      - name: ListViews Lab
        url:
      - name: ListViews HW
        url:

  - date: Tuesday, 10/18
    lessons:
      - name: Whiteboard Morning Exercise
        url:
      - name: RecyclerViews
        url:
      - name: Exit Ticket
        url:
    assignments:
      - name: RecyclerViews Lab
        url:

  - date: Wednesday, 10/19
    lessons:
      - name: Recursion & Whiteboarding Practice
        url:
      - name: Developer Documentation
        url:
    assignments:

  - date: Thursday, 10/20
    lessons:
      - name: Outcomes - Branding
      - name: Project 1 Workshop
      - name: Exit Ticket
        url:
    assignments:
      - name: Outcomes Circuit Unit 3
        url: https://circuits.generalassemb.ly

  - date: Friday, 10/21
    lessons:
      - name: End of Week Reflection Survey
        url:
      - name: Project 1 Workshop
    assignments:
      - name: Tic Tac Toe HW
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
