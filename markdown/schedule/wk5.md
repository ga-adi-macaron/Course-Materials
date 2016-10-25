---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

# When solution code is posted, put "&#x2705;" (with the "") in the assignment's note.

week: 5
days:
  - date: Monday, 10/31
    lessons:
      - name: Whiteboarding Practice 4
        url: 
      - name: Intro to Material Design
        url: 
      - name: Activity Lifecycle 1
        url: 
      - name: Activity Lifecycle 2
        url: 
      - name: Introduce Project 2
        url: 
    assignments:
      - name: Material Design HW
        url: 

  - date: Tuesday, 11/1
    lessons:
      - name: "Outcomes: Portfolio Websites"
        url: 
      - name: Intro to Fragments
        url: 
      - name: Fragments & ViewPager
        url:
      - name: Exit Ticket
        url: 
    assignments:
      - name: Fragments Lab
        url:
      - name: ViewPager Lab
        url:
      - name: Outcomes Circuit Unit 5
        url: https://circuits.generalassemb.ly

  - date: Wednesday, 11/2
    lessons:
      - name: Usability Testing
        url:
      - name: Master/Detail Flow
        url:
    assignments:
      - name: Usability Testing Lab
        url:

  - date: Thursday, 11/3
    lessons:
      - name: Drag & Swipe w/ RecyclerView
        url:
      - name: Espresso Testing
        url:
      - name: Toolbars & Menus
        url:
      - name: Exit Ticket
        url: 
    assignments:
      - name: Espresso Lab
        url:
      - name: Toolbars & Menus Lab
        url:

  - date: Friday, 11/4
    lessons:
      - name: Reflection Survey
        url: 
      - name: Simple Animations
        url:
      - name: Multiple Devices
        url:
    assignments:
      - name: Simple Animations Lab
        url:
      - name: Multiple Devices Lab
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
