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
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/services-lesson
      - name: Notifications
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/notifications-lesson
    assignments:
      - name: Services Lab
        url: https://github.com/ga-adi-macaron/services-lab
        solutionPosted: true
      - name: Notifications Lab
        url: https://github.com/ga-adi-macaron/notifications-lab
        solutionPosted: true
      - name: Volley HW
        url: https://github.com/ga-adi-macaron/volley-hw
        solutionPosted: true

  - date: Tuesday, 11/22
    lessons:
      - name: "Outcomes: Interviews"
      - name: Google Play Services
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/google-play-services-lesson
      - name: Feature Prioritization
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/feature-prioritization
      - name: Exit Ticket
        url: https://goo.gl/forms/TBjsm5ed2weGVQbl1
    assignments:
      - name: Google Play Services Lab
        url: https://github.com/ga-adi-macaron/google-play-services-lab
      - name: Project 3 Pitch Lab
        url: https://github.com/ga-adi-macaron/project-3-pitch-lab
      - name: Git Branching Reading
        url: https://www.atlassian.com/git/tutorials/using-branches
        note: (no deliverable)

  - date: Wednesday, 11/23
    lessons:
      - name: Git Team Workflow 1
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/git-team-workflow-1
      - name: Git Team Workflow 2
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/git-team-workflow-2
    assignments:
      - name: Trello Reading
        url: http://buildbettersoftware.com/trello-for-software-development
        note: (no deliverable)
      - name: OPTIONAL Email Client Mini-Project
        url: https://github.com/ga-adi-macaron/optional-email-client-lab

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
