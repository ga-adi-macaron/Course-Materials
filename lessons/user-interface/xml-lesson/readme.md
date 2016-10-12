---
title: Intro to XML
type: Lesson
duration: "0:30"
creator:
    name: Yuliya Kaleda
    city: LA
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Intro to XML

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Identify what XML is and what it is used for
- Describe the basics parts of XML: elements, attributes, XML namespace
- Describe how an element can contain child elements
- Describe how empty elements work
- Create a basic XML file

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Edit files in a text editor


---

## Opening (5 min)
To create an Android app you need not only Java, but XML as well. XML is the language that is used to write:

* a Manifest file (the contract where all components of the app are registered), which is located in the folder manifests/
* layout and values files that can be found in the folder res/

Let's go over some simple vocabulary that we'll need to know:

*Parser* - a program, usually part of a compiler, that receives input in the form of sequential source program instructions, interactive online commands, markup tags, or some other defined interface and breaks them up into parts (for example, the nouns (objects), verbs (methods), and their attributes or options) that can then be managed by other programming (for example, other components in a compiler).

*Extensible* - a quality of something, such as a program, programming language, or protocol, that is designed so that users or developers can expand or add to its capabilities.


## Introduction: What is XML? (15 min)

* XML stands for Extensible Markup Language
* XML is a markup language much like HTML
* XML was designed to store and transport data
* XML was designed to be self-descriptive

#### Elements

The simplest XML elements contain an opening tag, a closing tag, and some content.
The opening tag begins with a left angle bracket (<), followed by an element name that contains letters and numbers (but no spaces), and finishes with a right angle bracket (>)
In XML, content is usually parsed character data.
It could consist of plain text, other XML elements, and more exotic things like XML entities, comments, and processing instructions.
Following the content is the closing tag, which exhibits the same spelling and capitalization as your opening tag, but with one tiny change: a `/` appears right before the element name.

```xml
<elements>
    <myelement>one</myelement>
    <myelement>two</myelement>
 </elements>
 ```


A tag – either opening or closing – is used to mark the start or end of an element.
In the above example we have 3 elements: "elements" and 2 "myelement".
Pay attention that the element names are case sensitive and in our example mean different things.

#### Attributes

Inside the tag, following the element name, there can be some data (e.g. myAttribute="Main element").
This is called an attribute.
You can think of attributes as adjectives – they provide additional information about the element that may not make any sense as content.
If we modify our example and add attributes to each element, our example will look like this:

```xml
<elements="parentElement">
    <subElement elementId="childElement1">one</myelement>
    <subElement elementId="childElement2">two</myelement>
 </elements>
 ```

#### Namespaces

One of the features of xml is that you can define your own elements, which provides flexibility and scope.
But it also creates the strong possibility that, when combining XML content from different sources, you’ll experience clashes between code in which the same element names serve very different purposes.
For example, if you’re running a bookstore, your use of <element> tags in XML may be used to track books.
A mortgage broker would use `<element>` in a different way – perhaps to track a deed.
A dentist or doctor might use `<element>` to refer to chemical solution.
Here is where problems can arise.
To solve this ambiguity XML namespaces attempt to keep different semantic usages of the same XML elements separate.
In our example, each person could define their own namespace and then prepend the name of their namespace to specific tags:  `<book:element>` is different from `<broker:element>` and `<medrec:element>`.
A Namespace is a set of unique names. A namespace is declared as follows:

 ```xml
<elements xmlns:pfx="http://www.example.com"></elements>
 ```

In the attribute xmlns:pfx, xmlns is like a reserved word, which is used only to declare a namespace.
In other words, xmlns is used for binding namespaces.
A namespace has a prefix, in our example it is "pfx", and URI, "http://www.example.com".
Although a namespace usually looks like a URL, that doesn't mean that one must be connected to the Internet to actually declare and use namespaces.
Our full example would look like this:

 ```xml
<elements xmlns:pfx="http://www.example.com">
    <subElement pfx:elementId="childElement1">one</subElement>
    <subElement pfx:elementId="childElement2">two</subElement>
</elements>
 ```

The attributes `elementId` are associated with the namespace "http://www.example.com".

##### Nesting

As you might notice from our example there is a special structure of the xml code and indentation is different.
The tag `<elements>` closes after nested elements `<subElement>`.
Thus, `<subElement>` parts are considered to be children of the parent `<elements>`.

Some XML elements are said to be empty – they contain no content whatsoever.
Remember that in XML all opening tags must be matched by a closing tag.
For empty elements, you can use a single empty-element tag to replace this:

 ```xml
<myEmptyElement></myEmptyElement>
 ```

with this:

```xml
 <myEmptyElement/>
 ```

The `/` at the end of this tag basically tells the parser that the element starts and ends right here.
It’s an efficient shorthand method that you can use to mark up empty elements quickly.



## Independent Practice: Look at an XML file (5 min)

Look at the following code/file and answer the questions below:  

```xml
 <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="generalassembly.yuliyakaleda.supportdifferentdevices">

  <application
      android:allowBackup="true"
      android:icon="@mipmap/ic_launcher"
      android:label="@string/app_name"
      android:supportsRtl="true"
      android:theme="@style/AppTheme">
    <activity android:name=".MainActivity">
      <intent-filter>
        <action android:name="android.intent.action.MAIN" />

        <category android:name="android.intent.category.LAUNCHER" />
      </intent-filter>
    </activity>
    <activity android:name=".InformationActivity" />

    <service
        android:name=".QuickService"
        android:enabled="true">
    </service>
  </application>

</manifest>
```

1. How many elements does this xml file have?
2. What is a namespace in this example?
3. Name parent and children elements.
4. Find and name empty elements (the ones that do not have content).


## Conclusion (5 mins)

XML provides a structured way to specify data, with elements, child elements, attributes, and name spaces. XML files are important in Android to specify various types of data about how the system should treat your app, and how the app should look on the screen.
