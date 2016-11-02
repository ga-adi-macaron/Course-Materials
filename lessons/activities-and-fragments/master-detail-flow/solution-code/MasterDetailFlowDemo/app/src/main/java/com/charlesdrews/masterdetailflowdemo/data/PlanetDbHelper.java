package com.charlesdrews.masterdetailflowdemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Database helper class for our Planets database
 *
 * Created by charlie on 11/1/16.
 */

public class PlanetDbHelper extends SQLiteOpenHelper {

    //----------------------------------------------------------------------------------------
    // Database version and name
    //----------------------------------------------------------------------------------------
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "planets.db";


    //----------------------------------------------------------------------------------------
    // Planets table name, column names, and column data types
    //----------------------------------------------------------------------------------------
    private static final String PLANETS_TABLE_NAME = "planets";

    private static final String PLANETS_COL_ID = "_id";
    private static final String PLANETS_COL_ID_TYPE = "INTEGER PRIMARY KEY";

    private static final String PLANETS_COL_NAME = "name";
    private static final String PLANETS_COL_NAME_TYPE = "TEXT";

    // Diameter in km
    private static final String PLANETS_COL_DIAMETER = "diameter";
    private static final String PLANETS_COL_DIAMETER_TYPE = "INTEGER";

    // Average (mean) temperature in Celsius
    private static final String PLANETS_COL_TEMPERATURE = "temperature";
    private static final String PLANETS_COL_TEMPERATURE_TYPE = "INTEGER";

    // Has rings? No boolean type in SQLite, so 1 = true, 0 = false
    private static final String PLANETS_COL_RINGED = "ringed";
    private static final String PLANETS_COL_RINGED_TYPE = "INTEGER";

    // Number of moons
    private static final String PLANETS_COL_MOONS = "moons";
    private static final String PLANETS_COL_MOONS_TYPE = "INTEGER";

    // Is marked as a "favorite" by the user? No boolean type in SQLite, so 1 = true, 0 = false
    private static final String PLANETS_COL_FAVORITE = "favorite";
    private static final String PLANETS_COL_FAVORITE_TYPE = "INTEGER";

    // Create and drop SQL statements
    private static final String PLANETS_CREATE_STATEMENT = "CREATE TABLE " + PLANETS_TABLE_NAME +
            " (" + PLANETS_COL_ID   + " " + PLANETS_COL_ID_TYPE             + ", " +
            PLANETS_COL_NAME        + " " + PLANETS_COL_NAME_TYPE           + ", " +
            PLANETS_COL_DIAMETER    + " " + PLANETS_COL_DIAMETER_TYPE       + ", " +
            PLANETS_COL_TEMPERATURE + " " + PLANETS_COL_TEMPERATURE_TYPE    + ", " +
            PLANETS_COL_RINGED      + " " + PLANETS_COL_RINGED_TYPE         + ", " +
            PLANETS_COL_MOONS       + " " + PLANETS_COL_MOONS_TYPE          + ", " +
            PLANETS_COL_FAVORITE    + " " + PLANETS_COL_FAVORITE_TYPE       + ")";

    private static final String PLANETS_DROP_STATEMENT = "DROP TABLE IF EXISTS " + PLANETS_TABLE_NAME;


    //----------------------------------------------------------------------------------------
    // Singleton instance, getInstance() method, and private constructor
    //----------------------------------------------------------------------------------------
    private static PlanetDbHelper sInstance;

    public static PlanetDbHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PlanetDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private PlanetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //----------------------------------------------------------------------------------------
    // Mandatory onCreate() and onDestroy() - and a method to populate the new database
    //----------------------------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PLANETS_CREATE_STATEMENT);

        populatePlanetsTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(PLANETS_DROP_STATEMENT);
        onCreate(sqLiteDatabase);
    }

    // In a "real" app in the App Store you'd pre-package a populated database file into
    // your APK rather thank manually insert rows like this. This is just an example.
    private void populatePlanetsTable(SQLiteDatabase db) {

        // Data is from http://nssdc.gsfc.nasa.gov/planetary/factsheet/
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Mercury", 4879, 167, false, 0));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Venus", 12_104, 464, false, 0));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Earth", 12_756, 15, false, 1));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Mars", 6792, -65, false, 2));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Jupiter", 142_984, -110, true, 67));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Saturn", 120_536, -140, true, 62));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Uranus", 51_118, -195, true, 27));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Neptune", 49_528, -200, true, 14));
        db.insert(PLANETS_TABLE_NAME, null, getPlanetAsDbValues("Pluto", 2370, -225, false, 5));
    }

    private ContentValues getPlanetAsDbValues(String name, int diameterInKm, int avgTempInC,
                                              boolean hasRings, int numMoons) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANETS_COL_NAME, name);
        contentValues.put(PLANETS_COL_DIAMETER, diameterInKm);
        contentValues.put(PLANETS_COL_TEMPERATURE, avgTempInC);
        contentValues.put(PLANETS_COL_RINGED, (hasRings ? 1 : 0));
        contentValues.put(PLANETS_COL_MOONS, numMoons);
        return contentValues;
    }


    //----------------------------------------------------------------------------------------
    // Methods to query the database
    //----------------------------------------------------------------------------------------
    public List<Planet> getAllPlanets() {
        SQLiteDatabase db = getReadableDatabase();

        // Equivalent of `SELECT * FROM planets;`
        Cursor cursor = db.query(PLANETS_TABLE_NAME,
                null, null, null, null, null, null);

        List<Planet> planets = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Planet planet = getPlanetFromCursor(cursor);
                planets.add(planet);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();
        return planets;
    }

    public Planet getPlanetById(int planetId) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(PLANETS_TABLE_NAME,
                null,                                   // columns (null here means *)
                PLANETS_COL_ID + " = ?",                // selection statement (WHERE clause)
                new String[]{String.valueOf(planetId)}, // selection args
                null, null, null);                      // group by, having, order by

        Planet planet = null;
        if (cursor.moveToFirst()) {
            planet = getPlanetFromCursor(cursor);
        }
        cursor.close();
        db.close();
        return planet;
    }

    private Planet getPlanetFromCursor(Cursor cursor) {
        return new Planet(
                cursor.getInt(cursor.getColumnIndex(PLANETS_COL_ID)),
                cursor.getString(cursor.getColumnIndex(PLANETS_COL_NAME)),
                cursor.getInt(cursor.getColumnIndex(PLANETS_COL_DIAMETER)),
                cursor.getInt(cursor.getColumnIndex(PLANETS_COL_TEMPERATURE)),
                cursor.getInt(cursor.getColumnIndex(PLANETS_COL_MOONS)),
                // Convert the int value (0 or 1) to a boolean for "hasRings" & "isFavorite"
                (cursor.getInt(cursor.getColumnIndex(PLANETS_COL_RINGED)) == 1),
                (cursor.getInt(cursor.getColumnIndex(PLANETS_COL_FAVORITE)) == 1)
        );
    }

    //----------------------------------------------------------------------------------------
    // Method to update the "favorite" status of a planet
    //----------------------------------------------------------------------------------------
    public void updatePlanetFavoriteStatus(int planetId, boolean isAFavorite) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANETS_COL_FAVORITE, isAFavorite ? 1 : 0);
        db.update(
                PLANETS_TABLE_NAME,                     // Table to update
                contentValues,                          // Columns & values to update
                PLANETS_COL_ID + " = ?",                // Selection (WHERE clause)
                new String[]{String.valueOf(planetId)}  // Selection arguments
        );
        db.close();
    }
}
