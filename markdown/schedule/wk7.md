---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 7
days:
  - date: Monday, 11/14
    lessons:
      - name: Whiteboarding Practice 6
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-6
      - name: JSON
        url: 
      - name: HTTP & REST
        url: 
    assignments:
      - name: JSON Lab
        url: https://github.com/ga-adi-macaron/json-lab/subscription
      - name: HTTP Lab
        url: https://github.com/ga-adi-macaron/http-lab/subscription
      - name: HW TBD
        url: 

  - date: Tuesday, 11/15
    lessons:
      - name: "Outcomes: GA Profiles"
      - name: Introduction to APIs
        url: 
      - name: Threading w/ AsyncTask
        url: 
    assignments:
      - name: APIs Lab
        url: 
      - name: Threading Lab
        url: 
      - name: Threading HW
        url: 
        note: "(extra day: due 9am Thursday)"

  - date: Wednesday, 11/16
    lessons:
      - name: Design Thinking & UX
        url: 
      - name: API Documentation
        url: 
    assignments:
      - name: API Documentation HW
        url: 

  - date: Thursday, 11/17
    lessons:
      - name: Error Handling w/ Try/Catch
        url: 
      - name: Networking in Android
        url: 
      - name: OAuth
        url: 
    assignments:
      - name: Networking in Android Lab
        url:
      - name: OAuth Lab
        url: 

  - date: Friday, 11/18
    lessons:
      - name: User Research
        url: 
      - name: Competitor Research
        url: 
      - name: User Goals & Flows
        url: 
      - name: Introduce Project 3
        url: 
    assignments:
      - name: Research for Project 3
        url:
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
