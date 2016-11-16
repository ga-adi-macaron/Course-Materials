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
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/usability-testing
    date: Tuesday, 11/8
  - name: Design Thinking and UX
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/design-thinking-and-ux-lesson
    date: Wednesday, 11/16
  - name: User Research
    url: 
    date: Friday, 11/18
  - name: Competitor Research
    url: 
    date: Friday, 11/18
  - name: User Goals and User Flows
    url: 
    date: Friday, 11/18
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
