---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Product Development
lessons:
  - name: Paper Prototyping
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/paper-prototyping
    date: Tuesday, 10/18
  - name: User Stories
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/intro-to-testing
    date: Wednesday, 10/26
  - name: Usability Testing
    url: 
    date: Wednesday, 11/9
  - name: Design Thinking and UX
    url: 
    date: 
  - name: User Research
    url: 
    date: 
  - name: Competitor Research
    url: 
    date: 
  - name: User Goals and User Flows
    url: 
    date: 
  - name: User Personas
    url: 
    date: 
  - name: Feature Prioritization
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
