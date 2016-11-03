---
# Provide a list of projects,
#   each should have a number, name, url, due-date, due-time,
#   and set solution-posted to true if applicable

projects:
  - number: 0
    name: Rock Paper Scissors
    url: https://github.com/ga-adi-macaron/project-0
    due-date: Friday, 10/7
    due-time: 4:00 pm
    solution-posted: true
  - number: 1
    name: To-Do Lists
    url: https://github.com/ga-adi-macaron/project-1
    due-date: Friday, 10/21
    due-time: 3:30 pm
    solution-posted: true
  - number: 2
    name: Mobile Commerce App
    url: https://github.com/ga-adi-macaron/project-2
    due-date: Thursday, 11/10
    due-time: 4:00 pm
    solution-posted: false
  - number: 3
    name: Team Project
    url: 
    due-date: 
    due-time: 
    solution-posted: false
  - number: 4
    name: Final Project
    url: 
    due-date: 
    due-time: 
    solution-posted: false
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Projects

&#x2705; = solution code posted

<table>
<tr><td><b>Project</b></td><td><b>Due Date</b></td>
{% for project in page.projects %}
  <tr>
    <td>
      {% if project.url %}
        <a href="{{project.url}}">{{project.number}}: {{project.name}}</a>
      {% else %}
        {{project.number}}: {{project.name}}
      {% endif %}
      {% if project.solution-posted %}
        &#x2705;
      {% endif %}
    </td>
    <td>
      {{project.due-date}}
      {% if project.due-time %}
        @ {{project.due-time}}
      {% endif %}
    </td>
  </tr>
{% endfor %}
</table>


---

#### Suggestions for how to approach your projects:

- Write user stories - know exactly what features you plan to implement
- Draw a paper prototype & list out all the XML files you'll need
- Plan the custom Java classes you'll need to hold your app's data, and the corresponding database tables (if applicable)
- List all the adapters, fragments, view holders, etc. you'll need to make each screen work
- _**Prioritize your features - don't work on bonuses before your main requirements are met!**_
- _**Before working on a new feature, make sure your app builds and runs successfully - don't start working on feature #2 if feature #1 is still crashing!**_


---

#### How to download soution code posted after you made your fork:

1. Navigate to your local repo from the command line
1. Run `git remote -v` and note there is only one remote listed, your fork with the name `origin`
1. Run `git remote add upstream <url of original repo, not your fork>` to add an additional remote named `upstream` which points to the original repo
1. Run `git remote -v` again to confirm that you now have two remotes, with `upstream` linked to the original repo
1. Run `git pull upstream master` to pull in changes from the `upstream` remote's `master` branch
1. You shouldn't encounter merge conflicts, but if you do, [resolve them](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line/) and do a commit after the resolution
1. Run `git push origin master` to push the changes you got from	`upstream` out to your fork on Github
