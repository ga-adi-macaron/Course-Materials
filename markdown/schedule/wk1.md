---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 1
days:
  - date: Monday, 10/3
    lessons:
      - name: Welcome to ADI!
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/orientation-materials/welcome-to-adi
      - name: Command Line
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/os-navigation-lesson
      - name: Git & GitHub
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/git-github-lesson

    assignments:
      - name: Command Line Lab
        url: https://github.com/ga-adi-macaron/command-line-lab
      - name: Git & GitHub Lab
        url: https://github.com/ga-adi-macaron/github-lab
      - name: Android SDK Installation
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/workflow-and-dev-tools/sdk-installation
        note: (no deliverable)

  - date: Tuesday, 10/4
    lessons:
      - name: Intro to Android
        url: https://github.com/ga-adi-gelato/Course-Materials/tree/master/lessons/orientation-materials/android-intro-lesson
      - name: Data Types & Variables
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-types-and-variables
      - name: Functions & Scope
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/functions-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/cB8Jhr4pxvRR9Ps82
    assignments:
      - name: Data Types & Variables HW
        url: https://github.com/ga-adi-macaron/data-types-and-variables-hw
        solutionPosted: true
      - name: Functions & Scope Lab
        url: https://github.com/ga-adi-macaron/functions-lab
        solutionPosted: true
      - name: Functions & Scope HW
        url: https://github.com/ga-adi-macaron/functions-and-scope-hw
        solutionPosted: true

  - date: Wednesday, 10/5
    lessons:
      - name: Control Flow
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/control-flow
    assignments:
      - name: Advanced Functions Lab
        url: https://github.com/ga-adi-macaron/advanced-functions-lab
        solutionPosted: true
      - name: Functions Practice HW
        url: https://github.com/ga-adi-macaron/functions-practice-hw
        solutionPosted: true

  - date: Thursday, 10/6
    lessons:
      - name: Data Collections
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/data-collections
      - name: Debugging Fundamentals
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/debugging-fundamentals-in-java-lesson
      - name: Introduce Project 0
        url: https://github.com/ga-adi-macaron/project-0
      - name: Exit Ticket
        url: https://goo.gl/forms/46MZum6u4gUuC6vK2
    assignments:
      - name: Data Collections Lab
        url: https://github.com/ga-adi-macaron/data-collections-lab
        solutionPosted: true

  - date: Friday, 10/7
    lessons:
      - name: Reflection Survey & Discussion
        url: https://goo.gl/forms/xWTRoRaqnK4DrSgm1
      - name: Project 0 Workshop & Presentations
        url: https://github.com/ga-adi-macaron/project-0
    assignments:
      - name: More Functions Practice HW
        url: https://github.com/ga-adi-macaron/more-functions-practice-hw
        solutionPosted: true
      - name: "Reading: Intro to OOP Concepts"
        url: https://docs.oracle.com/javase/tutorial/java/concepts/index.html
        note: (no deliverable)
---

{% include "./week-table.md" %}
