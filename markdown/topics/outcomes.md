---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Outcomes
lessons:
  - name: Intro to Tech Industry
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/outcomes/intro-to-tech-industry
    date: Monday, 10/17
  - name: Portfolio Website Lesson
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/outcomes/portfolio-website
    date: Tuesday, 11/1
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
