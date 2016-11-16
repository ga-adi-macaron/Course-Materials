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
