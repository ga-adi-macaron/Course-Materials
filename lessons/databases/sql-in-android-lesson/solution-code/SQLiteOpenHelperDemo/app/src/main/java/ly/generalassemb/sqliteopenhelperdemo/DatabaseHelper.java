package ly.generalassemb.sqliteopenhelperdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by drewmahrt on 7/12/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "favorites.db";
    public static final String FAVORITES_TABLE_NAME = "favoritesTable";

    public static final String COL_ID = "_id";
    public static final String COL_GAME_NAME = "game_name";
    public static final String COL_GAME_YEAR = "year";

    public static final String mCreateString = "CREATE TABLE " + FAVORITES_TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY, " +
            COL_GAME_NAME + " TEXT, " +
            COL_GAME_YEAR + " INT )";

    private static DatabaseHelper sInstance;

    public static DatabaseHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // create the SQLiteDatabase's constructor, and override onCreate, and onUpgrade
    private DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mCreateString);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + FAVORITES_TABLE_NAME);
            onCreate(db);
    }

    public void addFavorite(String name,int year){
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
