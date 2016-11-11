---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 3
days:
  - date: Monday, 10/17
    lessons:
      - name: Outcomes - Intro to Tech Industry
        url: https://github.com/ga-adi-macaron/Course-Materials/blob/master/lessons/outcomes/intro-to-tech-industry/
      - name: Whiteboarding 101
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-lesson
      - name: Layouts
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/layouts-lesson
      - name: ListViews
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/listviews-list-adapters-lesson
    assignments:
      - name: ListViews Lab
        url: https://github.com/ga-adi-macaron/ListViews-ListAdapters-Lab
        solutionPosted: true
      - name: ListViews HW
        url: https://github.com/ga-adi-macaron/listview-and-listadapter-hw
        solutionPosted: true

  - date: Tuesday, 10/18
    lessons:
      - name: Whiteboarding Practice 1
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-1
      - name: RecyclerViews
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/recyclerview-lesson
      - name: Paper Prototyping
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/paper-prototyping
      - name: Introduce Project 1
        url: https://github.com/ga-adi-macaron/project-1
      - name: Exit Ticket
        url: https://goo.gl/forms/rkBZcMdzWNeyNCV92
    assignments:
      - name: RecyclerViews Lab
        url: https://github.com/ga-adi-macaron/RecyclerView-Lab
        solutionPosted: true

  - date: Wednesday, 10/19
    lessons:
      - name: "Whiteboarding Practice 2: Recursion"
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-2-recursion
      - name: Start Activity for Result
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson#demo-passing-data-back-in-the-result-20-mins
      - name: Developer Documentation
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/developer-documentation-lesson
    assignments:
      - name: None

  - date: Thursday, 10/20
    lessons:
      - name: "Outcomes: Branding"
      - name: "1:1 Check-Ins"
        url: https://docs.google.com/spreadsheets/d/1YABj9ZaNxLymnWsgcf2Qew3sGzPqNb0grlpg-DECS-8/edit?usp=sharing
      - name: Project 1 Workshop
        url: https://github.com/ga-adi-macaron/project-1
    assignments:
      - name: Outcomes Circuit Unit 3
        url: https://circuits.generalassemb.ly
      - name: Brand Statement (due 10/17)

  - date: Friday, 10/21
    lessons:
      - name: Reflection Survey & Discussion
        url: https://goo.gl/forms/7KSSrnzn6jWoyQmQ2
      - name: Project 1 Workshop & Presentations
        url: https://github.com/ga-adi-macaron/project-1
    assignments:
      - name: Tic Tac Toe HW
        url: https://github.com/ga-adi-macaron/tic-tac-toe-hw
        solutionPosted: true
      - name: Install SQLite on your computer
        url: https://www.tutorialspoint.com/sqlite/sqlite_installation.htm
        note: (no deliverable)
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Week {{page.week}}

Assignments must be submitted via pull request by 9:00 am the next class day.

&#x2705; = solution code posted

<table>
<tr><td><b>Date</b></td><td><b>Lessons</b></td><td><b>Assignments</b></td></tr>
{% for day in page.days %}
  <tr>
    <td>
      {{day.date}}
    </td>
    <td>
      <ul>
        {% for lesson in day.lessons %}
          <li>
            {% if lesson.url %}
              <a href="{{lesson.url}}">{{lesson.name}}</a>
            {% else %}
              {{lesson.name}}
            {% endif %}
          </li>
        {% endfor %}
      </ul>
    </td>
    <td>
      <ul>
        {% for assignment in day.assignments %}
          <li>
            {% if assignment.url %}
              <a href="{{assignment.url}}">{{assignment.name}}</a>
            {% else %}
              {{assignment.name}}
            {% endif %}
            {% if assignment.solutionPosted %}
              &#x2705;
            {% endif %}
            {{assignment.note}}
          </li>
        {% endfor %}
      </ul>
    </td>
  </tr>
{% endfor %}
</table>
