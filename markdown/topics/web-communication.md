---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Web Communication
lessons:
  - name: JSON
    url: 
    date: 
  - name: HTTP and REST
    url: 
    date: 
  - name: API Introduction
    url: 
    date: 
  - name: API Documentation
    url: 
    date: 
  - name: Networking in Android
    url: 
    date: 
  - name: OAuth
    url: 
    date: 
  - name: GSON
    url: 
    date: 
  - name: Retrofit
    url: 
    date: 
  - name: Sync Adapters Lesson
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
