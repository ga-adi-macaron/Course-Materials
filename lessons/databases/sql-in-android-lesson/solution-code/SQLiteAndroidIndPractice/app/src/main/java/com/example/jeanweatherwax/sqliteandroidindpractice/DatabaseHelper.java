package com.example.jeanweatherwax.sqliteandroidindpractice;

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
    public static final String DATABASE_NAME = "store.db";

    public static final String TABLE_TELEVISIONS = "televisions";

    public static final String COL_ID = "id";
    public static final String COL_BRAND = "brand";
    public static final String COL_SIZE = "size";
    public static final String COL_PRICE = "price";

    // Define SQL statements to create television table
    public static final String SQL_CREATE_TELEVISION_TABLE =
            "CREATE TABLE televisions ( "
                    + COL_ID+" INTEGER PRIMARY KEY,"
                    + COL_BRAND +" TEXT,"
                    + COL_SIZE+" TEXT,"
                    + COL_PRICE+" REAL)";

    public static final String SQL_DROP_TELEVISION_TABLE = "DROP TABLE IF EXISTS "+TABLE_TELEVISIONS;

    private static DatabaseHelper sInstance;

    public static DatabaseHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the games table when the database is created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TELEVISION_TABLE);
    }

    // When the database is upgraded, the old data isn't needed. Delete the television
    // table and recreate the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TELEVISION_TABLE);
        onCreate(db);
    }

    //INSERT INTO televisions VALUES ('Sony', '40"', '300');
    public void insert(String brand, String size, double price){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put(COL_BRAND, brand);
        values.put(COL_SIZE, size);
        values.put(COL_PRICE, price);

        // Insert the row into the games table
        db.insert(TABLE_TELEVISIONS, null, values);

        db.close();
    }

    //SELECT id, brand, size, price FROM televisions WHERE id = 10;
    public Television getTV(int id){
        // Get a reference to the database
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection, which tells the query to return only the columns mentioned
        // similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{ COL_ID, COL_BRAND, COL_SIZE, COL_PRICE };

        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
        // similar to "WHERE x < 23", only without the value; "WHERE x < ?"
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(id) };

        // Make the query, getting the cursor object
        Cursor cursor = db.query(TABLE_TELEVISIONS, projection, selection, selectionArgs, null, null, null, null);

        // With the cursor, create a new game object and return it
        if(cursor.moveToFirst()) {

            String brand = cursor.getString(cursor.getColumnIndex(COL_BRAND));
            String size = cursor.getString(cursor.getColumnIndex(COL_SIZE));
            Double price = cursor.getDouble(cursor.getColumnIndex(COL_PRICE));

            return new Television(id, brand, size, price);
        }
        return null;
    }

    //DELETE FROM televisions WHERE id = 10;
    public void delete(int id){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection, or the where
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(id) };

        // Delete everything that satisfies the selection
        db.delete("televisions", selection, selectionArgs);

        db.close();
    }
}
