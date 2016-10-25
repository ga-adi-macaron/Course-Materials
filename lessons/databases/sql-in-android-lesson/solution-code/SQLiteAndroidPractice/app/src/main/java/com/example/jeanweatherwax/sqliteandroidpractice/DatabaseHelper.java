package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeanweatherwax on 6/21/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";

    // Define SQL statements to create and delete games table
    public static final String SQL_CREATE_GAME_TABLE =
            "CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

    public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXISTS games";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the games table when the database is created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAME_TABLE);
    }

    // When the database is upgraded, the old data isn't needed. Delete the games
    // table and recreate the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(db);
    }

    public void insert(int id, String name, String year){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("year", year);

        // Insert the row into the games table
        db.insert("games", null, values);
    }

    public Game getGame(int id){
        // Get a reference to the database
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection, which tells the query to return only the columns mentioned
        // similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{ "id", "name", "year" };

        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
        // similar to "WHERE x < 23", only without the value; "WHERE x < ?"
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(id) };

        // Make the query, getting the cursor object
        Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null);

        // With the cursor, create a new game object and return it
        cursor.moveToFirst();

        String name = cursor.getString( cursor.getColumnIndex("name") );
        String year = cursor.getString( cursor.getColumnIndex("year") );

        return new Game(id, name, year);
    }
}
