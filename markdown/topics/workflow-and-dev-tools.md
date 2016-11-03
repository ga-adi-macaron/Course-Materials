---
# Provide values for an array of lessons,
#   with each lesson having a name, url, and date

title: Workflow and Developer Tools
lessons:
  - name: Command Line
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/os-navigation-lesson
    date: Monday, 10/3
  - name: Git & Github
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/git-github-lesson
    date: Monday, 10/3
  - name: Debugging Fundamentals in Java
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/debugging-fundamentals-in-java-lesson
    date: Thursday, 10/6
  - name: Debugging in Android Studio
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/debugging-in-android-lesson
    date: Wednesday, 10/12
  - name: Developer Documentation
    url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/developer-documentation-lesson
    date: Wednesday, 10/19
  - name: Git Team Workflow Part 1
    url: 
    date: 
  - name: Git Team Workflow Part 2
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
