---
# Provide values for an array of days,
#   within each day an array of lessons, each with name and url,
#   and an array of assignments, each with name, url, solutionPosted (boolean) and note.

# If no lessons one day, enter one with name None and url blank.
# If no assignments one day, enter one with either name or note None and url blank.

week: 7
days:
  - date: Monday, 11/14
    lessons:
      - name: Whiteboarding Practice 6
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/computer-science-and-interview-prep/whiteboarding-practice-6
      - name: JSON
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/json-lesson
      - name: HTTP & REST
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/http-rest-lesson
    assignments:
      - name: JSON Lab
        url: https://github.com/ga-adi-macaron/json-lab/
        solutionPosted: true
      - name: HTTP Lab
        url: https://github.com/ga-adi-macaron/http-lab/
      - name: Heterogeneous RecyclerView HW
        url: https://github.com/ga-adi-macaron/heterogeneous-recyclerview-hw
        solutionPosted: true

  - date: Tuesday, 11/15
    lessons:
      - name: "Outcomes: GA Profiles"
        url: https://profiles.generalassemb.ly/profiles
      - name: Threading w/ AsyncTask
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/android-technologies-and-services/threading-lesson
      - name: Introduction to APIs
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/api-intro-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/vEkotcWFnyHFP1Zz1
    assignments:
      - name: Update LinkedIn and GA Profiles
      - name: Threading Lab
        url: https://github.com/ga-adi-macaron/threading-lab
        solutionPosted: true
      - name: API Data Lab
        url: https://github.com/ga-adi-macaron/api-data-lab
        solutionPosted: true
      - name: Threading HW
        url: https://github.com/ga-adi-macaron/threading-hw
        note: "(extra day: due 9am Thursday)"

  - date: Wednesday, 11/16
    lessons:
      - name: Design Thinking & UX
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/design-thinking-and-ux-lesson
      - name: Error Handling w/ Try/Catch
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/programming-fundamentals-in-java/error-handling-with-try-catch
    assignments:
      - name: API Documentation HW
        url: https://github.com/ga-adi-macaron/api-documentation-hw
        solutionPosted: true

  - date: Thursday, 11/17
    lessons:
      - name: Networking in Android
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/networking-in-android-lesson
      - name: GSON
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/gson-lesson
      - name: OAuth
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/oauth-lesson
      - name: Exit Ticket
        url: https://goo.gl/forms/Ei3k6V6Ux4SXmJen1
    assignments:
      - name: Networking in Android Lab
        url: https://github.com/ga-adi-macaron/networking-in-android-lab
        solutionPosted: true
      - name: OAuth Lab
        url: https://github.com/ga-adi-macaron/oauth-lab
        solutionPosted: true

  - date: Friday, 11/18
    lessons:
      - name: Reflection Survey & Discussion
        url: https://goo.gl/forms/0BDHHtfiUo5DwRbj2
      - name: Retrofit
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/web-communication/retrofit-lesson
      - name: User Research
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/user-research-lesson
      - name: Competitor Research
        url: https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/product-development/competitive-research-lesson
      - name: Introduce Project 3
        url: https://github.com/ga-adi-macaron/project-3
    assignments:
      - name: Retrofit Lab
        url: https://github.com/ga-adi-macaron/retrofit-lab
        solutionPosted: true
      - name: Research for Project 3
        url: https://github.com/ga-adi-macaron/research-for-project-3
---

{% include "./week-template.md" %}
