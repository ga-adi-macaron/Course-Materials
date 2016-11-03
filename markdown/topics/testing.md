---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Testing
lessons:
  - name: Intro to Testing
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/intro-to-testing
    date: Wednesday, 10/26
  - name: Unit Testing
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/unit-testing
    date: Wednesday, 10/26
  - name: Espresso
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/espresso-lesson
    date: Thursday, 11/3
  - name: Usability Testing
    url: 
    date: Wednesday, 11/9
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
