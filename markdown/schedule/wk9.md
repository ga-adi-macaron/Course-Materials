---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 9
days:
  - date: Monday, 11/28
    lessons:
      - name: Activity Transitions
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/activity-transitions
      - name: Creating a Content Provider
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/content-provider-lesson
      - name: External Content Providers
        url: 
    assignments:
      - name: Creating a Content Provider Lab
        url: https://github.com/ga-adi-macaron/content-providers-lab
        solutionPosted: false
      - name: External Content Providers Lab
        url: https://github.com/ga-adi-macaron/external-content-providers-lab
        solutionPosted: false

  - date: Tuesday, 11/29
    lessons:
      - name: Whiteboard Practice 7
        url: 
      - name: Job Scheduler
        url: 
      - name: "Outcomes: Ask the Experts Panel"
        url: 
      - name: MVP Architecture
        url: 
      - name: Project 3 Workshop
        url: https://github.com/ga-adi-macaron/project-3
      - name: Exit Ticket
        url: 
    assignments:
      - name: Job Scheduler Lab
        url: 

  - date: Wednesday, 11/30
    lessons:
      - name: Project 3 Workshop
        url: https://github.com/ga-adi-macaron/project-3
    assignments:
      - name: None

  - date: Thursday, 12/1
    lessons:
      - name: Project 3 Workshop
        url: https://github.com/ga-adi-macaron/project-3
      - name: 1:1 Check-Ins
        url: https://docs.google.com/spreadsheets/d/1YABj9ZaNxLymnWsgcf2Qew3sGzPqNb0grlpg-DECS-8/edit?usp=sharing
    assignments:
      - name: None

  - date: Friday, 12/2
    lessons:
      - name: Reflection Survey & Discussion
        url: 
      - name: Project 3 Workshop
        url: https://github.com/ga-adi-macaron/project-3
    assignments:
      - name: None
---

{% include "./week-template.md" %}
