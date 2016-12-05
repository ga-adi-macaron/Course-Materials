---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 14
days:
  - date: Monday, 1/2
    lessons:
      - name: Holiday Break (no classes)
    assignments:
      - name: None

  - date: Tuesday, 1/3
    lessons:
      - name: Releasing Your App
        url: 
      - name: Project 4 Workshop
        url: 
    assignments:
      - name: None

  - date: Wednesday, 1/4
    lessons:
      - name: Project 4 Workshop
        url: 
    assignments:
      - name: None

  - date: Thursday, 1/5
    lessons:
      - name: Project 4 Workshop
        url: 
    assignments:
      - name: None

  - date: Friday, 1/6
    lessons:
      - name: Project 4 Workshop
        url: 
    assignments:
      - name: None
---

{% include "./week-template.md" %}
