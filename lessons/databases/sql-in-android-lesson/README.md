---
title: Building SQLite support in an Android app
duration: "1:25"
creator:
    name: James Davis
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Building SQLite support in an Android app


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Describe the purpose of SQLiteOpenHelper
* Create and query databases and tables with the SQLiteOpenHelper class

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- [Databases, tables, records, and columns](../databases-tables-records-columns-lesson)
- [SQL Setup, Insert, Update, and Delete](../sqlite-lesson)
- [Android Cursors](../android-cursors)

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
| 5 min  | [Introduction](#introduction-sql-vs-sqlite-vs-postgresql-5-mins)  | SQL vs. SQLite vs. PostgreSQL |
| 15 min  | [Demo](#demo-sqliteopenhelper-15-minutes)  | SQLiteOpenHelper |
| 25 min  | [Demo](#demo-inserting,-reading,-and-deleting-values-25-mins)  | Inserting, reading, and deleting values |
| 30 min  | [Independent Practice](#independent-practice-creating-a-subclass-of-sqliteopenhelper-30-minutes)  | Creating a subclass of SQLiteOpenHelper |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |

## Opening (5 mins)

Now that we've gotten the basics of SQL down, let's explore the __easy__ Android options for creating, inserting, updating, reading, and destroying content from the database.

> How did you handle creating/using databases in the previous cursors lesson?

## Introduction: SQLiteOpenHelper (5 mins)
*SQLite* is a library that gets embedded inside the application that makes use of. As a self-contained, file-based database, SQLite offers a set of tools to handle all sorts of data with much less constraint and ease compared to hosted, process based (server) relational databases.

When an application uses SQLite, the integration works with functional and direct calls made to a file holding the data (i.e. SQLite database) instead of communicating through an interface of sorts (i.e. ports, sockets). This makes SQLite extremely fast and efficient, and also powerful thanks to the library's underlying technology.

There's a class called `SQLiteOpenHelper` that is a helper class that manages database creation. This class handles opening databases if they exist and creating them if they do not. In addition, it automatically handles upgrading the database when you want changes made. Basically, it abstracts away the implementation of the database from the rest of your apps' code.

## Demo: SQLiteOpenHelper (15 minutes)

To use this new tool, you have to create your own subclass of `SQLiteOpenHelper`. We're going to make a database that contains our **favorite video games**, as well as **the years they were released**.

> Check: What columns should I make?

In it, we start defining two static member variables - the database's name and version. It's good to have the database's name in one place, at the top of the class, and the constructor is calling the superclass's constructor, using the database name and version we just defined

Next, we override two methods from SQLiteOpenHelper: onCreate and onUpgrade. onCreate is called when the database doesn't exist yet, or it needs to be re-created. onUpgrade is called when the database has been upgraded and needs to be changed.

Finally, we need to make a private constructor to handle initializing our database.

> Instructor Note: Students be given the option to follow along and do this on their machine as they will use this code in the final activity.

```java
public class DatabaseHelper extends SQLiteOpenHelper {
		// Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "favorites.db";

    // create the SQLiteDatabase's constructor, and override onCreate, and onUpgrade
    private DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
```


Alright, let's make a database with one table. This table will hold our favorite video games.

First, let's define the table columns. In SQLite, the statement used to create a new table is as follows:

```sqlite
CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year INT );
```

> What's something I could change here to make the code more flexible if things need to change in the future?

... and to delete the table would be:

```sqlite
DROP TABLE IF EXISTS games;
```

We will use this to create the *games* table in out database. So, we'll save them as static member variables in our database helper.

**Pro Tip:** Defining the SQL statements and names as member variables makes it easier to reference and change them. It's faster to look at the top of a class for your values in one place, as opposed to digging through the methods to find them and change them individually.

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";
    
    public static final String mCreateString = "CREATE TABLE " + FAVORITES_TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_GAME_NAME + " TEXT, " +
                COL_GAME_YEAR + " INT )";


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

		// Create the games table when the database is created
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(mCreateString);
    }

		// When the database is upgraded, the old data isn't needed. Delete the games
		// table and recreate the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // Simplest implementation is to drop all old tables and recreate them
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
    }
}
```

Last, we need to set up our singleton.

```java
private static DatabaseHelper sInstance;
    public static DatabaseHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
}
```

At this point, we have a class that helps us create and update the games table in the Favorites database. Let's use the helper to help us do CRUD operations: insert, read, update, and delete values.

> Check: Talk with the person next to you and discuss: why is it important to define the database name and version atop your class as two static member variables?

## Demo: Inserting, reading, and deleting values (25 mins)

> Check: Talk with the people at your table and try to identify actions you would want to do to data in a database. Take one minute and be ready to share!

You can: Create, Read, Update, and Destroy data (or CRUD, for short!)  We won't be using update in this example, but we will still be implementing it.

#### Inserting new data into table and content values

One option we have for inserting data is to use the execSQL method like above. For example:

```
INSERT INTO games VALUES (10,'Joe','2005');
```

There is, however, an easier, more flexible option to insert data in Android. Before we discuss this, we need to go over a new way to represent the data to store in the database. We use the `ContentValues` class to hold the data we will insert into a database. The [ContentValues](http://developer.android.com/reference/android/content/ContentValues.html) class is very similar to a bundle or a map where it is a data type that maps values to particular keys. The keys represent the table column names and the values are the newly inserted data.

In your `SQLiteOpenHelper` subclass, create the *insert* methods. (You are not overriding these methods but making them from scratch).

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

		public void insert(String name, String year){
				// Get a reference to the database
				SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put(COL_GAME_NAME, name);
        values.put(COL_GAME_YEAR, year);

        // Insert the row into the games table
        db.insert(FAVORITES_TABLE_NAME, null, values);

        db.close();
		}
}
```

By using ContentValues along with the insert method, we are making our interactions with the database much cleaner rather than forming sometimes very complicated SQL queries.

#### Reading data from database (Cursors)

In your subclass of `SQLiteOpenHelper`, we will add a method that helps us retrieve data from a table.

Essentially, you will run a query on the database and do operations on the cursor that is returned.

Again, we have the option of writing a raw SQL query:

```
SELECT id, name, year FROM games WHERE id = 10;
```

As you can see below, Android once again provides us with a handy query method.

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

    public Cursor getAllGames(){
            // Get a reference to the database
            SQLiteDatabase db = getReadableDatabase();

            // Make the query, getting the cursor object
            return db.query(FAVORITES_TABLE_NAME, null, null, null, null, null, null, null);
    }

    public int getGameCount(String name){
        // Get a reference to the database
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection, which tells the query to return only the columns mentioned
        // similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{ COL_GAME_YEAR, COL_GAME_YEAR };

        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
        // similar to "WHERE x < 23", only without the value; "WHERE x < ?"
        String selection = COL_GAME_NAME+" = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(name) };

        // Make the query, getting the cursor object
        Cursor cursor = db.query(FAVORITES_TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        int gameCount = cursor.getCount();

        return gameCount;
    }
}
```

#### Deleting rows from table

To delete a row with `SQLiteOpenHelper`, you have to define the WHERE clause and values that define what you want to delete. In this example, we want to delete a game with a certain id:

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

    public int deleteGameByName(String name){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection, or the where
        String selection = COL_GAME_NAME+" = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(name) };

        // Delete everything that satisfies the selection
        int rowsEffected = db.delete(FAVORITES_TABLE_NAME, selection, selectionArgs);
        db.close();
	
	return rowsEffected;
    }
}
```

The raw SQL option would look like this:

```
DELETE FROM games WHERE name = Doom;
```

#### Updating data

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

    public void updateGameYear(String name, int year){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection, or the where
        String selection = COL_GAME_NAME+" = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(name) };

        ContentValues values = new ContentValues();
        values.put(COL_GAME_YEAR,year);

        // Delete everything that satisfies the selection
        db.update(FAVORITES_TABLE_NAME,values, selection, selectionArgs);
        db.close();
    }
}
```

#### Using the subclass of `SQLiteOpenHelper`

Use this class from anywhere with access to a Context (i.e., an Activity):

```java
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    mAddGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gameName = mGameNameEditText.getText().toString();
                int gameYear = Integer.parseInt(mGameYearEditText.getText().toString());

                DatabaseHelper.getInstance(MainActivity.this).addFavorite(gameName,gameYear);

                Toast.makeText(MainActivity.this, "Game Added", Toast.LENGTH_SHORT).show();
            }
        });
}
```

## Independent Practice: Creating a subclass of SQLiteOpenHelper (10 minutes)

Finish the click listeners to handle deleting and getting the count of the games.

> Check: Take 3 minutes to review the solution with students.

## BONUS: Independent Practice: Creating a subclass of SQLiteOpenHelper (30 minutes)

Using what we've learned as guidance, create your own subclass of SQLiteOpenHelper that does the following:

* Creates a database, called "store"
* Creates a table called "televisions", with the columns:
	* id
	* brand
	* size (i.e. 40")
	* price (integer)
* In the main activity of your app, insert at least 5 televisions into the database
* Also, delete 2 of them
* Somehow test that your add and delete methods worked

In a commented line above each CRUD method of the SQLiteOpenHelper, write the equivalent raw SQL String you could use as an alternative.

Be sure to leverage documentation!

> Check: Take 3 minutes to review the solution with students.

## Conclusion (5 mins)

- What are the functions of the `SQLiteOpenHelper` class?

## Additional Resources

- [Saving Data in SQL Databases (Android Developers)](http://developer.android.com/training/basics/data-storage/databases.html)
- [Android SQLite Database Tutorial](http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/)
