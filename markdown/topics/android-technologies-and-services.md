---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Android Technologies and Services
lessons:
  - name: Enabling Search
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/enable-search-lesson
    date: Thursday, 10/27
  - name: Designing for Multiple Devices
    url:
    date: Friday, 11/3
  - name: Accessibility
    url:
    date: Monday, 11/7
  - name: Threading
    url:
    date: 
  - name: Efficient Apps Morning Exercise
    url:
    date: 
  - name: Services
    url:
    date: 
  - name: Notifications
    url:
    date: 
  - name: Google Play Services
    url:
    date: 
  - name: JobSchedulers
    url:
    date: 
  - name: Sync Adapters
    url:
    date: 
  - name: Firebase
    url:
    date: 
  - name: Releasing Your App
    url:
    date: 
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
