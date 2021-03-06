---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 6
days:
  - date: Monday, 11/7
    lessons:
      - name: Whiteboarding Practice 5
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-5
      - name: Accessibility
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/accessible-apps-lesson
      - name: "1:1 Check-Ins"
        url: https://docs.google.com/spreadsheets/d/1YABj9ZaNxLymnWsgcf2Qew3sGzPqNb0grlpg-DECS-8/edit?usp=sharing
      - name: Project 2 Workshop
        url: https://github.com/ga-adi-macaron/project-2
    assignments:
      - name: Accessibility Lab
        url: https://github.com/ga-adi-macaron/accessibility-testing-lab

  - date: Tuesday, 11/8
    lessons:
      - name: "Outcomes: Qualifications Checkpoint"
      - name: Mid-Course Survey (link will be emailed)
      - name: Usability Testing
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/usability-testing
      - name: Project 2 Workshop
        url: https://github.com/ga-adi-macaron/project-2
    assignments:
      - name: Outcomes Circuit Unit 6
        url: https://circuits.generalassemb.ly
        note: (final circuit assignment)
      - name: Revised Cover Letter & Resume
        note: due 11/15; hand in both new and original drafts

  - date: Wednesday, 11/9
    lessons:
      - name: Project 2 Workshop
        url: https://github.com/ga-adi-macaron/project-2
    assignments:
      - name: None

  - date: Thursday, 11/10
    lessons:
      - name: Project 2 Workshop & Presentations
        url: https://github.com/ga-adi-macaron/project-2
    assignments:
      - name: None

  - date: Friday, 11/11
    lessons:
      - name: Veterans Day (no classes)
    assignments:
      - name: None
---

{% include "./week-template.md" %}
