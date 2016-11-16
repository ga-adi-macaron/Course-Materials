---
title: GSON
duration: "0:50"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) GSON

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what GSON is used for
- Incorporate GSON into your app

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Make network requests on Android

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Run the solution code and look at the source code to make sure you agree with its implementation

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 5 min  | [Introduction](#introduction-what-is-gson-5-mins)  | What is GSON? |
| 15 min  | [Demo](#demo-using-gson-15-mins)  | Using GSON |
| 20 min  | [Independent Practice](#independent-practice-topic-20-mins)  | Implement User Interface |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

<a name="opening"></a>
## Opening (5 mins)

Our previous experience with networking has simply involved getting a JSON object and manually manipulating it. While this can work fine, alternatives exist to take out some of that manual effort. One such tool is a library called GSON.

***

<a name="introduction"></a>
## Introduction: What is GSON? (5 mins)

When we look at a JSON object, it is relatively simple to see how we could translate it into a Java object. The key-value pairs in JSON can directly correspond to member variables in a Java object. With the simple addition of assigning strict types in Java, there really isn't much of a difference. Since Java is all about working with objects, the GSON library handily does two things:

- Converts JSON objects to Java objects with the method **fromJson()**
- Converts Java objects to JSON with the method **toJson()**

As you will see in the upcoming demo, this is a rather simple process, but makes working with more complicated data much easier.


***

<a name="demo"></a>
## Demo: Using GSON (15 mins)


We're going to be using the [Walmart API](https://developer.walmartlabs.com/docs/read/Search_API) for our example in this exercise. Open the starter-code, and replace the API key with yours in the URL variable.

The first step is to add GSON to your gradle:

```
compile 'com.google.code.gson:gson:2.7'
```

Next, we will create a Java objects to represent our search result, and the items in the search result.

```java
public class WalmartItem {
    private String name;
    private String shortDescription;

    public String getName(){return name;}

    public String getShortDescription(){return shortDescription;}

    public void setName(String name){this.name = name;}

    public void setShortDescription(String description){this.shortDescription = description;}

    @Override
    public String toString() {
        return name;
    }
}
```

```java
public class WalmartSearchResult {
    private WalmartItem[] items;

    public void setItems(WalmartItem[] items){this.items = items;}

    public WalmartItem[] getItems(){return items;}

    @Override
    public String toString() {
        return items.length+" item(s) in the search result";
    }
}
```

The last step is simply to call `fromJson`:

```java
Gson gson = new Gson();
WalmartSearchResult result = gson.fromJson(data, WalmartSearchResult.class);
```

From here we can easily do whatever we want with the search results, such as printing out the name of the item.

We can also easily convert objects back to JSON:

```java
String json = gson.toJson(result);
```

***

<a name="ind-practice"></a>
## Independent Practice: Implement User Interface (20 mins)

Now it's time to practice. In pairs, add an EditText, a Button, and a ListView so you can search for an item using the Walmart API, and display the names of the items in your ListView. Use the objects GSON creates for you to populate the ListView.


***

<a name="conclusion"></a>
## Conclusion (5 mins)

GSON is an extremely helpful tool for more complicated JSON data, but it can be overkill for simple tasks. Being able to easily convert between JSON and Java is a nice feature to have, and can make data transfer code much cleaner.

***

### ADDITIONAL RESOURCES
- [GSON](https://github.com/google/gson)
