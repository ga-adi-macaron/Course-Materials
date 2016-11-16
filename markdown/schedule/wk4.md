---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 4
days:
  - date: Monday, 10/24
    lessons:
      - name: Unit 1 Review Jeopardy
        url: https://www.jeopardy.rocks/adiunit1review
      - name: Intro to Databases
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/databases-intro-lesson
      - name: SQL and SQLite
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/sqlite-lesson
      - name: Intro to Cursors
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/cursors-intro-lesson
    assignments:
      - name: SQLite Lab
        url: https://github.com/ga-adi-macaron/sqlite-lab
        solutionPosted: true
      - name: SQL Practice HW
        url: https://github.com/ga-adi-macaron/sql-practice-hw
        solutionPosted: true

  - date: Tuesday, 10/25
    lessons:
      - name: "Outcomes: Resumes & Cover Letters"
      - name: SQLite in Android
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/sql-in-android-lesson
      - name: Databases w/ RecyclerViews
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/database-recyclerview-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/hxnPvGLjagL4s3T22
    assignments:
      - name: Databases w/ RecyclerViews Lab
        url: https://github.com/ga-adi-macaron/databases-with-recyclerview-lab
        solutionPosted: true
      - name: Outcomes Circuit Unit 4
        url: https://circuits.generalassemb.ly
      - name: Brand Statement & Peer Reviews (due Thursday, 10/27)
      - name: Cover Letter & Resume (due Monday, 10/31)

  - date: Wednesday, 10/26
    lessons:
      - name: Intro to Testing
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/intro-to-testing
      - name: Unit Testing
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/testing/unit-testing
    assignments:
      - name: Unit Testing Lab
        url: https://github.com/ga-adi-macaron/unit-testing-lab
        solutionPosted: true
      - name: User Stories HW
        url: https://github.com/ga-adi-macaron/user-stories-hw
      - name: Prep for Enabling Search HW
        url: https://github.com/ga-adi-macaron/Enable-Search-Prework

  - date: Thursday, 10/27
    lessons:
      - name: Whiteboarding Practice 3
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-3
      - name: Enabling Search
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/enable-search-lesson
      - name: Detail Views
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/detail-view-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/s7ldzNtaFAZfGgn02
    assignments:
      - name: Enabling Search Lab
        url: https://github.com/ga-adi-macaron/enable-search-lab
        solutionPosted: true
      - name: Detail Views Lab
        url: https://github.com/ga-adi-macaron/detail-view-lab
        solutionPosted: true

  - date: Friday, 10/28
    lessons:
      - name: Reflection Survey & Discussion
        url: https://goo.gl/forms/5FlwZVBVyrFUc89W2
      - name: SQL Joins
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/databases/joins-lesson
      - name: Constraint Layout
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/user-interface/constraint-layout-lesson
    assignments:
      - name: SQL Joins Lab
        url: https://github.com/ga-adi-macaron/joins-lab
        solutionPosted: true
      - name: Constraint Layout Lab
        url: https://github.com/ga-adi-macaron/constraint-layout-lab
      - name: Database Relationships HW
        url: https://github.com/ga-adi-macaron/database-tables-hw
        solutionPosted: true
---

{% include "./week-template.md" %}
