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
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-4
      - name: Material Design Intro
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/material-design-intro
      - name: Activity Lifecycle 1
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activity-life-cycle-1-lesson
      - name: Activity Lifecycle 2
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activity-life-cycle-2-lesson
      - name: Introduce Project 2
        url: https://github.com/ga-adi-macaron/project-2
    assignments:
      - name: Material Design HW
        url: https://github.com/ga-adi-macaron/material-design-hw

  - date: Tuesday, 11/1
    lessons:
      - name: "Outcomes: Portfolio Websites"
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/outcomes/portfolio-website
      - name: Intro to Fragments & ViewPager
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/fragments-1-lesson
      - name: Fragment Communication
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/fragments-2-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/93FIuI5uRrnnLvK92
    assignments:
      - name: ViewPager Lab
        url: https://github.com/ga-adi-macaron/ViewPager-Lab
        note: "&#x2705;"
      - name: Fragment Communication Lab
        url: https://github.com/ga-adi-macaron/Fragments-Communications-Lab
        note: "&#x2705;"
      - name: Outcomes Circuit Unit 5
        url: https://circuits.generalassemb.ly

  - date: Wednesday, 11/2
    lessons:
      - name: Master/Detail Flow
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/master-detail-flow
    assignments:
      - name: Master/Detail Flow Lab
        url: https://github.com/ga-adi-macaron/master-detail-flow-lab
        note: "&#x2705;"

  - date: Thursday, 11/3
    lessons:
      - name: Drag & Swipe w/ RecyclerView
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/drag-and-swipe-with-recyclerview
      - name: Espresso Testing
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/espresso-lesson
      - name: Toolbars & Menus
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/toolbars-and-menus-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/r09DUY2ImZx7aPCE3
    assignments:
      - name: Espresso Lab
        url: https://github.com/ga-adi-macaron/espresso-lab
        note: "&#x2705;"
      - name: Toolbars & Menus Lab
        url: https://github.com/ga-adi-macaron/toolbars-and-menus-lab

  - date: Friday, 11/4
    lessons:
      - name: Mid-Course Survey (link will be emailed)
      - name: Simple Animations
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/simple-animation
      - name: Pizza Lunch!
      - name: Multiple Devices
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/multiple-devices-lesson
    assignments:
      - name: Simple Animations Lab
        url: https://github.com/ga-adi-macaron/simple-animation-lab
        note: "&#x2705;"
      - name: Multiple Devices Lab
        url: https://github.com/ga-adi-macaron/multiple-devices-lab
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
