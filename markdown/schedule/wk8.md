---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 8
days:
  - date: Monday, 11/21
    lessons:
      - name: User Personas
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/user-personas
      - name: Services
        url: 
      - name: Notifications
        url: 
    assignments:
      - name: Services Lab
        url: 
        solutionPosted: false
      - name: Notifications Lab
        url: 
        solutionPosted: false
      - name: Volley HW
        url: 
        solutionPosted: false

  - date: Tuesday, 11/22
    lessons:
      - name: "Outcomes: Interviews & Negotiations"
        url: 
      - name: Google Play Services
        url: 
      - name: Prioritization & Proposal
        url: 
      - name: Exit Ticket
        url: 
    assignments:
      - name: Google Play Services Lab
        url: 
      - name: Project 3 Pitch Lab
        url: 
      - name: Git Branching Reading
        url: 
        note: (no deliverable)

  - date: Wednesday, 11/23
    lessons:
      - name: Git Team Workflow 1
        url: 
      - name: Git Team Workflow 2
        url: 
    assignments:
      - name: Trello Reading
        url: 
        note: (no deliverable)
      - name: OPTIONAL Email Client Mini-Project
        url: 

  - date: Thursday, 11/24
    lessons:
      - name: Thanksgiving Day (no classes)
    assignments:
      - name: <img src="https://render.bitstrips.com/v2/cpanel/10211581-205539203_12-s1-v1.png?transparent=1">

  - date: Friday, 11/25
    lessons:
      - name: Day After Thanksgiving (no classes)
    assignments:
      - name: <img src="https://render.bitstrips.com/v2/cpanel/10211583-205539203_12-s1-v1.png?transparent=1">
---

{% include "./week-template.md" %}
