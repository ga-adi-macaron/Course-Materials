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
