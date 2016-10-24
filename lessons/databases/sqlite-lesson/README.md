---
title: Databases, SQL, and SQLite
type: lesson
duration: "1:30"
creator: Jay Nappy (NYC)
updated by: James Davis (NYC)
---

# Databases, SQL, and SQLite

### Objectives

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe SQL
- Create a database table
- Insert, retrieve, update, and delete a row or rows into a database table

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Install **[SQLite](https://www.sqlite.org/)** on your computer
- Describe the relationship between tables, rows, and columns
- Explain the difference between table relationships

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-we-know-about-databases,-but-what-is-sql-10-mins)  | We know about Databases, but what is SQL?  |
| 10 min  | [Demo](#demo-create,-connect-to-a-database-10-mins)  | Create, Connect to a Database |
| 10 min  | [Guided Practice](#guided-practice-create-a-table-10-mins)  | Create a table |
| 10 min  | [Guided Practice](#guided-practice-create-a-student-table-and-insert-data-10-mins)  | Create a student table and insert data |
| 10 min  | [Insert Data - Independent Practice](#insert-data-independent-practice-10-mins)  |   |
| 20 min  | [Demo](#demo-whats-in-our-database-20-mins)  | What's in our database?  |
| 15 min  | [Independent Practice](#independent-practice-insert-some-more-data-15-mins)  | Insert Some More Data! |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening (5 mins)

Let's review: at it's simplest, a relational database is a mechanism to store and retrieve data in a tabular form.  Spreadsheets are a good analogy!  But how do we interact with our database: inserting data, updating data, retrieving data, and deleting data? That's where SQL comes in!

## Introduction: We know about Databases, but what is SQL?  (10 mins)

#### What is SQL?

SQL stands for Structured Query Language, and it is a language universally used and adapted to interact with relational databases.  When you use a SQL client and connect to a relational database that contains tables with data, the scope of what you can do with SQL commands includes:

- Inserting data
- Querying or retrieving data
- Updating or deleting data
- Creating new tables and entire databases
- Control permissions of who can have access to our data

Note that all these actions depend on what the database administrator sets for user permissions: a lot of times, as an analyst, for example, you'll only have access to retrieving company data; but as a developer, you could have access to all these commands and be in charge of setting the database permissions for your web or mobile application.

#### Why is SQL important?

Well, a database is just a repository to store the data and you need to use systems that dictate how the data will be stored and as a client to interact with the data.  We call these systems "Database Management Systems", they come in _many_ forms:

- MySQL
- SQLite (what we'll be using!)
- PostgreSQL

...and all of these management systems use SQL (or some adaptation of it) as a language to manage data in the system.



## Demo: Create, Connect to a Database (10 mins)

Let's make a database!  First, open up your terminal and move to your root directory.

Then, run the following command:

```bash
   $ sqlite3 name_of_your_database
```

This creates a new database in your current folder (or just opens it, if it already exists). This also opens the SQLite program, where you can manage the database.

You should see something like:

```bash
  sqlite>
```

> Check: Do students see this `sqlite>` prompt?

Great! Now, you can execute SQLite commands.

## Guided Practice: Create a table (10 mins)

Now that we have a database, let's create a table.

Take 5 minutes and work with the person next to you to get to the web and find the syntax needed to do the following:

- Create a table called "instructors"
- The table should have the following attributes:
  - an ID that is the primary key
  - a name that is text
  - an experience rating that is an integer
  - a website that is text

Feel free to write this on your desk!


Ok here is the answer:

```sql
CREATE TABLE instructors (
  ID  INTEGER PRIMARY KEY,
  NAME TEXT,
  EXPERIENCE INT,
  WEBSITE TEXT
);
```

#### Excel ~ Database

Think of a data table like Excel or Google Sheets; where you can have a bunch of spreadsheets (tables) inside a workbook (database).

When we paste the above block into SQLite:

```sql
sqlite> CREATE TABLE instructors (
   ...>   ID  INTEGER PRIMARY KEY,
   ...>   NAME TEXT,
   ...>   EXPERIENCE INT,
   ...>   WEBSITE TEXT
   ...> );
```

Quick note about the `...>` part: it indicates a new line. Although the code above is split up on different lines, it is one statement. It is the equivalent of `CREATE TABLE instructors (ID  INT PRIMARY KEY, NAME TEXT, EXPERIENCE INT, WEBSITE TEXT);`. You can enter it either way. However, they both have to end in a semi-colon for the statement to run. _This is true for all SQLite statements, not just CREATE TABLE_.

So, if you press enter and you see `...>` and not `sqlite>`, then you probably forgot a semicolon at the end of your statement. The following statement, for instance, is totally fine:

```sql
  sqlite> SELECT * FROM students
     ...> ;
```

--

Alright, let's look into the different parts of the statement:

```sql
  CREATE TABLE instructors (
```
This starts our table creation, it tells SQLite to create a table named "instructors"..

```sql
  ID    INTEGER   PRIMARY KEY,
  NAME  TEXT,
```

...then, each line after denotes a new column we're going to create for this table, what the column will be called, the data type, whether it's a primary key, and whether the database - when data is added - can allow data without missing values.

```sql
  ID        INTEGER   PRIMARY KEY NOT NULL,
  NAME      TEXT,
```

To make a field required (i.e. when adding data, make it mandatory to define a value), you add the words NOT NULL to the end of the line, before the comma if there is one.

## Guided Practice: Create a student table and insert data (10 mins)

Now that we've created a table to keep track of our instructors, let's create a table for students that collects information about:

- an id that cannot be left blank
- the students name that cannot be left blank
- their age
- and their address that cannot be left blank.

Remember the commands we just went over and work with the person next to you for 3 minutes to construct the query.



Here's what that query should have looked like:

```sql
  CREATE TABLE students (
    ID INTEGER PRIMARY KEY NOT NULL,
    NAME TEXT NOT NULL,
    AGE INT,
    ADDRESS TEXT
  );
```

In SQLite, that will look like:

```sqlite
  sqlite>   CREATE TABLE students (
     ...>       ID INTEGER PRIMARY KEY NOT NULL,
     ...>       NAME TEXT NOT NULL,
     ...>       AGE INT,
     ...>       ADDRESS TEXT
     ...>   );
```


Great job! Now let's finally _insert_ some data into that table - think about what cannot be left blank!

We'll insert five students, Jack, Jill, John, Jackie, and Voltron. The syntax is as follows:

```sql
  INSERT INTO TABLE_NAME VALUES (value1, value2, value3, etc...);
```

... where each value corresponds with the table's column.


In SQLite that will look like:

```sql
  sqlite> INSERT INTO students VALUES (1, 'Jack Sparrow', 28, '50 Main St, New York, NY');
```

Great, we have Jack Sparrow in our database! What happens if we type in another entry with the ID of 1? We get an error! Luckily, SQLite automatically helps us out with this. If we don't enter an ID in our insert statement, the database will generate one for us.

Now we can enter our data like this:

```sql
  sqlite> INSERT INTO students (name,age,address) VALUES ('Jack Sparrow', 28, '50 Main St, New York, NY');
```


## Insert Data - Independent Practice (10 mins)

Now, you try it for the other students, and pay attention to the order of Jack's parameters and the single quotes - they both matter.

- Jill's full name is Jilly Cakes; she's 30 years old, and lives at 123 Webdev Dr. Boston, MA
- Johns's full name is Johnny Bananas; hes 25 years old, and lives at 555 Five St, Fivetowns, NY
- Jackie's full name is Jackie Lackie; she's 101 years old, and lives at 2 OldForThis Ct, Fivetowns, NY
- Voltron's full name is Voltron; he's 31 and would not like to list his address.



```sql
INSERT INTO students (name,age,address) VALUES ('Jilly Cakes', 30, '123 Webdev Dr. Boston, MA');
INSERT INTO students (name,age,address) VALUES ('Johnny Bananas', 25, '555 Five St, Fivetowns, NY');
INSERT INTO students (name,age,address) VALUES ('Jackie Lackie', 101, '2 OldForThis Ct, Fivetowns, NY');
INSERT INTO students (name,age,address) VALUES ('Voltron', 31, null);
```


## Demo: What's in our database?  (20 mins)

So now that we have this data saved, we're going to need to access it at some point, right?  We're going to want to _select_ particular datapoints in our dataset provided certain conditions.  The SQLite SELECT statement is used to fetch the data from a database table that returns data in the form of result table. These result tables are called result-sets. The syntax is just what you would have guessed:

```sql
  SELECT column1, column2, columnN FROM table_name;
```
We can pass in what columns we want to look - like above - at or even get all our table records:

```sql
  SELECT * FROM table_name;
```

For us, we can get all the records back:

```sql
  sqlite> SELECT * FROM students;

  1|Jack Sparrow|28|50 Main St, New York, NY
  2|Jilly Cakes|30|123 Webdev Dr. Boston, MA
  3|Johnny Bananas|25|555 Five St, Fivetowns, NY
  4|Jackie Lackie|101|2 OldForThis Ct, Fivetowns, NY
  5|Voltron|31|
```

We can get just the name and ages of our students:

```sql
  sqlite> SELECT name, age FROM students;

  Jack Sparrow|28
  Jilly Cakes|30
  Johnny Bananas|25
  Jackie Lackie|101
  Voltron|31
```

#### Getting more specific

Just like in Java, all of our comparison and boolean operators can do work for us to select more specific data.

- I want the names of all the students who aren't dinosaurs - done:

```sql
  sqlite> SELECT name FROM students WHERE age < 100;

  Jack Sparrow
  Jilly Cakes
  Johnny Bananas
  Voltron
```

- How about the names of students ordered by age? Done:

```sql
  sqlite> SELECT name, age FROM students ORDER BY age;

  Johnny Bananas|25
  Jack Sparrow|28
  Jilly Cakes|30
  Voltron|31
  Jackie Lackie|101
```

- How about reversed? Ok:

```sql
  sqlite> SELECT name, age FROM students ORDER BY age DESC;

  Jackie Lackie|101
  Voltron|31
  Jilly Cakes|30
  Jack Sparrow|28
  Johnny Bananas|25
```

- How about those who live in Fivetowns? We can find strings within strings too!

```sql
  sqlite> SELECT * FROM students WHERE address LIKE '%Fivetowns%';

  3|Johnny Bananas|25|555 Five St, Fivetowns, NY
  4|Jackie Lackie|101|2 OldForThis Ct, Fivetowns, NY
```


#### Updates to our database

Ok, there are some mistakes we've made to our database, but that's cool, cause we can totally update it or delete information we don't like. Let's start by adding one more student:

```sql
  sqlite> INSERT INTO students (name,age,address) VALUES ('Miss Take', 500, 'asdfasdfasdf');
```

But oh no, we messed them up - Miss Take doesn't live at asdfasdfasdf, she lives at 100 Main St., New York, NY.  


Let's fix it:  

```sql
  sqlite> UPDATE students SET address = '100 Main St., New York, NY' where address = 'asdfasdfasdf';

  sqlite> SELECT * FROM students;

  1|Jack Sparrow|28|50 Main St, New York, NY
  2|Jilly Cakes|30|123 Webdev Dr. Boston, MA
  3|Johnny Bananas|25|555 Five St, Fivetowns, NY
  4|Jackie Lackie|101|2 OldForThis Ct, Fivetowns, NY
  5|Voltron|31|
  6|Miss Take|500|100 Main St., New York, NY
```

But wait, actually, she just cancelled - no big!

```sql
  sqlite> DELETE FROM students where name = 'Miss Take';

  sqlite> SELECT * FROM students;

  1|Jack Sparrow|28|50 Main St, New York, NY
  2|Jilly Cakes|30|123 Webdev Dr. Boston, MA
  3|Johnny Bananas|25|555 Five St, Fivetowns, NY
  4|Jackie Lackie|101|2 OldForThis Ct, Fivetowns, NY
  5|Voltron|31|

```

## Independent Practice: Insert Some More Data! (15 mins)

There's _no way_ you're going to remember the exact syntax of everything we just did, but let's practice a habit you should have been doing since week 1: finding and reading documentation. Checkout [this SQLite tutorial](http://www.tutorialspoint.com/sqlite/) and using the same database and data table of users, get through a many of these SQL challenges as possible in the next 10 minutes:

- Insert five more students:
  - Nancy Gong is 40 and lives at 200 Horton Ave., Lynbrook, NY
  - Laura Rossi is 70 and listed her address as "Unlisted"
  - David Daniele is 28 and lives at 300 Dannington Ln., Washington, DC.
  - Greg Fitzgerald is 25 and did not list an address
  - Randi Fitz is 28 and lives in Oceanside, NY

- Randi wants her address to be corrected to 25 Broadway, New York, NY
- Get a list of student names and addresses who are older than 30 and order them by their address alphabetically
- Get a list of students whose first name begins with the letter "J"
- Get a list of student names who live in NY or MA

Test your work by doing a `SELECT *` statement after each challenge is completed.


## Conclusion (5 mins)

- How does SQL relate to relational databases?
- What kinds of boolean and conditional operators can we use in SQL?

### ADDITIONAL RESOURCES

Here are a list of some common SQLite commands that you might need:

- .tables - Lists names of tables
- .schema - shows the CREATE statement of all tables in the database
  - .schema table_name - show the CREATE statement for a particular database
- .quit - quits SQLite!
- .help - a full list of the commands that can be used
