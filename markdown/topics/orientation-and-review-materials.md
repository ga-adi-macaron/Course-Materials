---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Orientation and Review Materials
lessons:
  - name: Your Learning Experience
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/orientation-materials/welcome-to-adi
    date: Monday, 10/3
  - name: Intro to Android
    url: https://github.com/ga-adi-gelato/Course-Materials/tree/master/lessons/orientation-materials/android-intro-lesson
    date: Tuesday, 10/4
  - name: Week 1 Review - Jeopardy
    url: https://www.jeopardy.rocks/adigelatoweek1
    date: Tuesday, 10/11
  - name: Unit 1 Review - Jeopardy
    url: https://www.jeopardy.rocks/adiunit1review
    date: Monday, 10/24
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) {{page.title}}

<ul>
  {% for lesson in page.lessons %}
  <li>
    {% if lesson.url %}
      <a href="{{lesson.url}}">{{lesson.name}}</a> ({{lesson.date}})
    {% else %}
      {{lesson.name}} ({{lesson.date}})
    {% endif %}</li>
  </li>
  {% endfor %}
</ul>
