---
title: What is an API?
type: lesson
duration: "1:25"
creator: Gerry Mathe (London)
edited by: James Davis (NYC)
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) What is an API?

### Objectives
*After this lesson, students will be able to:*

- Describe APIs & how we'll cover them in the next unit
- Download data from an API call using Postman
- Explain what an API key is

### Preparation
*Before this lesson, students should already be able to:*,

- Describe JSON objects
- Explain HTTP

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction-what-is-an-api-5-mins)  | What is an API? |
| 15 min  | [Demo](#demo-curl-15-mins)  | cURL |
| 15 min  | [Guided Practice](#guided-practice-get-data-from-an-api-15-mins)  | Get data from an API |
| 20 min  | [Independent Practice](#independent-practice-20-mins)  |   |
| 10 min  | [Introduction](#introduction-what-is-an-api-key-10-mins)  | What is an API key? |
| 20 min  | [Independent Practice](#independent-practice-20-mins)  |   |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening (5 mins)

Let's kick things off with a [video](http://www.youtube.com/watch?feature=player_embedded&v=s7wmiS2mSXY)

## Introduction: What is an API? (5 mins)


Taken from HowStuffWorks.com:

"An application-programming interface (API) is a set of programming instructions and standards for accessing a Web-based software application or Web tool. A software company releases its API to the public so that other software developers can design products that are powered by its service...[it] is a software-to-software interface, not a user interface. With APIs, applications talk to each other without any user knowledge or intervention."

The Guardian is a popular open-source platform used to access all the content the Guardian creates, categorized by tag and section. With over one and a half million items available, from as far back as 1999, Guardian created an API, making it possible to access all the data available on the website a simple web request.  We can access it using [http://open-platform.theguardian.com/](http://open-platform.theguardian.com/)

If you remember, JSON objects are a type of data collection that we can use to store/send information as developers. Try to go on [http://content.guardianAPIs.com/search?API-key=test](http://content.guardianAPIs.com/search?API-key=test), and you'll notice the data rendered as JSON.  You can probably begin to think about how this will come in handy. Find some more documentation on [http://open-platform.theguardian.com/documentation/](http://open-platform.theguardian.com/documentation/)


## Demo: Get data from an API (15 mins)

We're going to query the OMDb servers to get movie information back.

First let's review how we create a GET request. How do we add parameters to our query?

#### Reading the API specifications



Go to the [OMDb API](http://www.omdbapi.com/) page.

To perform a search on the movie database, we have to use the right parameters. It's very similar to a query in SQL; to run a certain query, you would need to search using some params (like ID).

Look at the API webpage, and look at the required parameters to perform a search: [Link to it here](http://www.omdbapi.com/#parameters)


Search has a bunch of optional parameters, but requires the parameter *s* (the movie title to search for).

If we searched for the movie Die Hard, the search url would look like this: `http://www.omdbapi.com/?s=die+hard`


...it would return the following JSON response:

```json
{
  "Search": [
    {
      "Title": "Die Hard",
      "Year": "1988",
      "imdbID": "tt0095016",
      "Type": "movie",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTY4ODM0OTc2M15BMl5BanBnXkFtZTcwNzE0MTk3OA@@._V1_SX300.jpg"
    },
    {
      "Title": "Die Hard: With a Vengeance",
      "Year": "1995",
      "imdbID": "tt0112864",
      "Type": "movie",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BOTgyNDM4Mjg0OF5BMl5BanBnXkFtZTcwMjQxNTEzMQ@@._V1_SX300.jpg"
    },
    {
      "Title": "Die Hard 2",
      "Year": "1990",
      "imdbID": "tt0099423",
      "Type": "movie",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BNzM1MzMwNzY2OF5BMl5BanBnXkFtZTgwNzE1MzkyMTE@._V1_SX300.jpg"
    },
    {
      "Title": "Die Hard Dracula",
      "Year": "1998",
      "imdbID": "tt0162930",
      "Type": "movie",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTkwNTQwNDQ4MF5BMl5BanBnXkFtZTcwMDY2NjUyMQ@@._V1_SX300.jpg"
    }
  ],
  "totalResults": "56",
  "Response": "True"
}

```


## Independent Practice (20 mins)

_*Note:* This can be done as a pair programming exercise of alone._

Using the [OMDb API](http://www.omdbapi.com/) page as your guide, try to run the following searches:

* Find the movie with the id **tt0092099**.
* Get a list or things that have the word "Iron" in it
* Get a list of *television series* have the word "Iron" in it
* Get a list of *movies* made in the year 2001 that contain the word "the"


## Introduction: What is an API key? (10 mins)

The API we used above is public and needs no form of authentication. We ran the query, and there was nothing stopping us.

However, not all APIs are as publicly available. Some require you to register, and the people hosting the server can give you permission to access the API with a key.

An API Key is a secret token that is used to access private API calls. It's called a *key* for a reason.

The API Key is usually attached to a developer or company. So, whenever an API call is made, the server looks at the key, identifies that it is truly you and not someone else making the call.

Many APIs say to add the key as a parameter in the URL, like so:  `https://api.tumblr.com/v2/blog/ga.com/posts/link?api_key=PyezS3Q4Smivb24d9SzZGYSuh--IaMfAkE`

...where the API key is `PyezS3Q4Smivb24d9SzZGYSuh--IaMfAkE`.


## Independent Practice (20 mins)

Let's jump right in!

Using [Dark Sky weather API](https://darksky.net/dev/), sign up for an API key.

Once you get the key, get the current weather forecast for New York City from the Postman!

**NOTE:** APIs from different companies have different requirements when you call them. Pay attention to the documentation!


## Conclusion (5 mins)

- What is an API?
- How do API keys relate to API calls?
- What type of data is typically given back to you from an API call?
