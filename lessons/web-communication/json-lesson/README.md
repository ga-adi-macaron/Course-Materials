title | type | duration | creator
----- | ---- | -------- | -------
JSON | lesson | 1:15 | Yuliya Kaleda (New York)

--

<!-- OUTSTANDING

1. There should be more examples of structuring JSON data in APIs: http://stackoverflow.com/questions/12806386/standard-json-api-response-format
 -->

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) JSON


### Objectives
*After this lesson, students will be able to:*  
- Identify JSON syntax
- Describe why data is stored in JSON objects
- Identify nested collections in a JSON object

### Preparation
*Before this lesson, students should already be able to:*
- Identify and use such a data structure as an array

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-why-json-5-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-what-is-json-10-mins)  | What is JSON? |
| 10 min  | [Demo](#demo-json-structure-and-syntax-10-mins)  | JSON structure and syntax |
| 10 min  | [Guided Practice](#guided-practice-add-elements-to-the-array-10-mins)  | Add elements to the array |
| 5 min  | [Introduction](#introduction-nesting-json-data-5-mins)  | Nesting JSON Data |
| 10 min  | [Demo](#demo-nesting-json-data-10-mins)  | Nesting JSON Data |
| 10 min  | [Guided Practice](#guided-practice-nesting-json-data-10-mins)  | Nesting JSON Data |
| 10 min  | [Independent Practice](#independent-practice-validate-json-10-mins)  | Validate JSON |
| 5 min  | [Conclusion (5 mins)](#conclusion-5-mins)  |  |

## Opening: Why JSON (5 mins)
Many sites and applications are sharing data using JSON in addition to RSS feeds nowadays, and with good reason: JSON feeds can be loaded asynchronously much more easily than XML/RSS.

Let's identify some important vocabulary before we continue:

RSS stands for "Really Simple Syndication". It is a way to easily distribute a list of headlines, update notices, and sometimes content to a wide number of people. It is used by computer programs that organize those headlines and notices for easy reading.

## Introduction: What is JSON? (10 mins)  

JSON is short for JavaScript Object Notation, and is a way to store information in an organized, easy-to-access manner. In a nutshell, it gives us a human-readable collection of data that we can access in a really logical manner.

JSON is built on two structures:

* **A collection of name/value pairs.** In various languages, this is realized as an object, record, struct, dictionary, hash table, keyed list, or associative array.
* **An ordered list of values**. In most languages, this is realized as an array, vector, list, or sequence.

These are universal data structures. Virtually all modern programming languages support them in one form or another. It makes sense that a data format that is interchangeable with programming languages also be based on these structures.

##### Objects

An object is an unordered set of name/value pairs. An object begins with `{` (left brace) and ends with `}` (right brace). Each name is followed by `:` (colon) and the name/value pairs are separated by `,` (comma).

The syntax is as follows:

```
{ string : value, .......}
```

##### Array

As we know, an array is an ordered collection of values. An array starts and ends with `[` and `]`. Between them, a number of values can reside. If there are more than one values reside, they are separated by `,`.


The syntax is as follows:

```
[ value, .......]
```

We know that data can be stored as a string in double quotes, or a number, or true or false or null, or an object or an array.


## Demo: JSON structure and syntax (10 mins)

```
{
	"state" : "New York",
	"country" : "USA"
}
```

The above snippet creates an object. By enclosing the variable's value in curly braces, we're indicating that the value is an *object*. Inside the object, we can declare any number of properties using a `"name": "value"` pairing, separated by commas. To access the information stored in this object, we can simply refer to the name of the property we need.

```
[{
    "state" : "Arizona",
    "country" : "USA"
},
{
    "state" : "Delaware",
    "country" : "USA"
}]
```

The reason we quickly reviewed those datatypes before was because these datatypes and structures can be nested.

As we can see from the example above this is a slightly more complicated structure that stores two states together. We enclose multiple objects in square brackets, which signifies an array.


## Guided Practice: Add elements to the array (10 mins)  

* create a new array, similar to the one above containing:
	* your favorite state you have visited
	* a state you have never visited
* add another attribute (State Abbreviation) to each object in the array


```
[{
    "state" : "California",
    "country" : "USA",
    "code" : "CA"
},
{
    "state" : "Delaware",
    "country" : "USA",
    "code" : "DE"
}]
```


## Introduction: Nesting JSON Data (5 mins)

Nested JSON and arrays can be combined as needed to store as much data as necessary. When you’re nesting objects, you have to give each object a name. In arrays, on the other hand, you have the option of giving each index a name or not. If you don’t define a key name, then JavaScript will automatically assign each key with numbers (see at the example above, each object does not have a name).

## Demo: Nesting JSON Data (10 mins)

```
{
    "key1" : {
        "key2" : "Val1",
    	"key3" : "Val2"
    },
    "key4" : {
        "key2" : "Val3",
    	"key3" : "Val4"
    }
}
```


As we can see in our example, there are two object ("first", "second") united in the top/root object. Each inner object has two values:

* name
* language

## Guided Practice: Nesting JSON Data (10 mins)

Let's restructure the array elements you created in the last exercise (Guided Practice: Add elements to the array) and create nested JSON with two objects (states) united in a top/root object. Assign a key value you think would be appropriate.


```
{
    "favorite" : {
      	"state" : "California",
    	"country" : "USA",
	"code" : "CA"
    },
    "never-visited" : {
      	"state" : "Delaware",
    	"country" : "USA",
	"code" : "DE"
    }
}
```


## Independent Practice: Validate JSON (10 mins)
JSON is very simple to use if correctly structured. One of the resources to validate JSON and check if the syntax is correct is [JSON Viewer](http://codebeautify.org/jsonviewer).


For this exercise, copy JSON data from the [starter-code](starter-code) and insert it in the web app above, click "Beautify". If your JSON is invalid, you should see an error. If not, you will see a more readable way of JSON.

* first, correct errors if there are any
* then, work in pairs to identify the structure of the JSON:

	- Where does the root element start?
	- Are there any arrays?
	- How many objects are there?
	- What are the keys of the most deeply nested object?


## Conclusion (5 mins):
Object oriented programming has exploded over the years so we could spend many hours talking about the benefits of using objects. Using JSON objects means your data has a strict, standardized structure. With this strict structure in place there is less chance for errors. The application receiving the JSON data knows what to expect and how to receive the data. Having this structure in place can also aid the developer in providing solid cross browser solutions, which most developers will know can be a really problem especially now there are so many different browsers thanks to tablets and mobile devices.

-  What does JSON stand for?
-  What are 2 main structures JSON is built on?
-  What is a way/data structure a property of an object is stored as?
