---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Activities and Fragments
lessons:
  - name: Activities and Intents
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson
    date: Friday, 10/14
  - name: Activity Lifecycle (Part 1)
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activity-life-cycle-1-lesson
    date: Monday, 10/31
  - name: Activity Lifecycle (Part 2)
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activity-life-cycle-2-lesson
    date: Monday, 10/31
  - name: Intro to Fragments and ViewPager
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/fragments-1-lesson
    date: Tuesday, 11/1
  - name: Fragment Communication
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/fragments-2-lesson
    date: Tuesday, 11/1
  - name: Master/Detail Flow
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/master-detail-flow
    date: Wednesday, 11/2
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
