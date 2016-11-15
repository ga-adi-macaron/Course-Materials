---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Web Communication
lessons:
  - name: JSON
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/json-lesson
    date: Monday, 11/14
  - name: HTTP and REST
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/http-rest-lesson
    date: Monday, 11/14
  - name: API Introduction
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/api-intro-lesson
    date: Tuesday, 11/15
  - name: API Documentation
    url: 
    date: Wednesday, 11/16
  - name: Networking in Android
    url: 
    date: Thursday, 11/17
  - name: OAuth
    url: 
    date: Thursday, 11/17
  - name: GSON
    url: 
    date: Monday, 11/21
  - name: Retrofit
    url: 
    date: 
  - name: Sync Adapters
    url: 
    date: 
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
