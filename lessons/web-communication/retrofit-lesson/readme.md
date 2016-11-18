---
title: Retrofit
duration: "0:55"
creator:
    name: Jean Weatherwax
    city: San Francisco
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Retrofit

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain what Retrofit is
- Make a POJO model class from a JSON schema
- Make a service interface with Retrofit
- Use Retrofit and GSONConverterFactory to display API data using a service interface

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Work with JSON
- Start a background thread using AsyncTask

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
## Opening (5 mins)

[Retrofit](http://square.github.io/retrofit/) is a library from Square that gives us a REST HTTP client for Android and Java. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with [OkHttp](http://square.github.io/okhttp/), another Square library.

Retrofit can also work with converter libraries like GSON to make objects out of the data you get back from API calls. You can think of Retrofit as a wrapper that pulls together the functionality of both OkHttp and GSON. It's very widely used to download JSON and XML data from APIs.

> Check:  Ask students what Retrofit is used for in their own words.

## Setup (5 mins): 

You can follow along as we code a basic Retrofit example using the GitHub API. Please open the [starter code project](starter-code].

To use Retrofit and incorporate GSON with it you'll need to add the following dependencies to your gradle:

```gradle
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
```

This compiles the additional libraries we need.

## Making a POJO model (10 mins)

We'll want to make a model class, in this case, a User model based on the user information from the [GitHub API](https://developer.github.com/v3/). There are a couple of ways to do this. The first way is the manual approach, which requires you to make good use of the [Gson](https://github.com/google/gson) library. The second approach auto-generating the Java classes you need by capturing the JSON output and using [jsonschema2pojo](http://www.jsonschema2pojo.org/). It's good to know the manual Gson way, but often in practice using jsonschema2pojo is very efficient. We'll be using this second method for this lesson.

On the jsonschema2pojo site, select the option of *JSON* for Source Type and Annotation style as *GSON*. Then, enter in the API URL to transform (for example, https://api.github.com/users/jeanmw):

```json
{
  "login": "jeanmw",
  "id": 11809238,
  "avatar_url": "https://avatars.githubusercontent.com/u/11809238?v=3",
  "gravatar_id": "",
  "url": "https://api.github.com/users/jeanmw",
  "html_url": "https://github.com/jeanmw",
  "followers_url": "https://api.github.com/users/jeanmw/followers",
  "following_url": "https://api.github.com/users/jeanmw/following{/other_user}",
  "gists_url": "https://api.github.com/users/jeanmw/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/jeanmw/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/jeanmw/subscriptions",
  "organizations_url": "https://api.github.com/users/jeanmw/orgs",
  "repos_url": "https://api.github.com/users/jeanmw/repos",
  "events_url": "https://api.github.com/users/jeanmw/events{/privacy}",
  "received_events_url": "https://api.github.com/users/jeanmw/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Jean Weatherwax",
  "company": "General Assembly",
  "blog": null,
  "location": "San Francisco",
  "email": null,
  "hireable": null,
  "bio": null,
  "public_repos": 4,
  "public_gists": 0,
  "followers": 0,
  "following": 0,
  "created_at": "2015-04-05T19:02:55Z",
  "updated_at": "2016-07-12T23:02:00Z"
}
```

You can then create a class in your project 'User' and paste the resultant methods from the converter that will generate a model for our GitHub User. You can put this class in a *models* folder for organization purposes.

## Guided Practice: Making a service interface and using it with Retrofit (30 mins)

The next step is to create an interface to use with our endpoint and Retrofit. 

```java

package com.example.jeanweatherwax.retrofitgithubexample;


import com.example.jeanweatherwax.retrofitgithubexample.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubService {
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
```

This interface:

1. Specifies the API endpoint (we'll append this to our base URL in the MainActivity) and the type of HTTP request
2. Declares a method that returns a Call Object that takes in a User model type, with the path specified to be a username String input. We'll fill in this input with actual user input in the MainActivity.


Next, in the MainActivity, we'll use this interface. First, create a variable to store our base API URL:


```java
private static String baseUrl = "https://api.github.com/";
```

Then, we create a Retrofit service in our MainActivity, and add GsonConverter for JSON parsing:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Next, we get an instance of our service and get Call<User> :

```java
GitHubService service = retrofit.create(GitHubService.class);

Call<User> call = service.getUser(userName);
```

And then, we execute the call we've created and perform updates to our textviews to display data. 

```java
call.enqueue(new Callback<User>() {
	@Override
        public void onResponse(Call<User> call, Response<User> response) {
		try {
			String userName = response.body().getName();

                        String location = response.body().getLocation();

                        String company = response.body().getCompany();

                        nameView.setText("GitHub Name: " + userName);
                        locationView.setText("location: " + location);
                        companyView.setText("Company: " + company);

		} catch (Exception e) {
                        e.printStackTrace();
		}
	}

	@Override
	public void onFailure(Call<User> call, Throwable t) {

       	}
});
```

This whole block is wrapped in a method *getUserInfo()* that we will call when a button is clicked. We also make sure to check for network connectivity as previously mentioned:

```java
protected void getUserInfo(String userName) {
        Log.d("MainActivity: ", "getting github info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubService service = retrofit.create(GitHubService.class);

            Call<User> call = service.getUser(userName);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    try {

                        String userName = response.body().getName();

                        String location = response.body().getLocation();

                        String company = response.body().getCompany();

                        nameView.setText("GitHub Name: " + userName);
                        locationView.setText("location: " + location);
                        companyView.setText("Company: " + company);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
			Toast.makeText(MainActivity.this, "Network request failed", Toast.LENGTH_LONG).show();
                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
```

>Instructor note: explain each step in the above


## Conclusion (5 mins)

- What is the main use case of Retrofit in Android?
- What permissions should be added to the Manifest file to establish network connection?
- What are the steps to use Retrofit to display API data in your Android app?
