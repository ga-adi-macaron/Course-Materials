package drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class NamesDBHelper extends SQLiteOpenHelper {

    /**
     * DO NOT MODIFY THIS CLASS
     *
     * Your threading will be done in MainActivity for this app, not here
     */

    private static final String TAG = NamesDBHelper.class.getName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "names.db";
    public static final String TEST_TABLE_NAME = "names_table";

    public static final String COL_ID = "_id";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";

    public static final String[] COLUMNS = {COL_ID, COL_FIRST_NAME, COL_LAST_NAME};

    private static final String CREATE_TEST_TABLE = "CREATE TABLE " + TEST_TABLE_NAME + "(" +
            COL_ID + " INTEGER PRIMARY KEY, " +
            COL_FIRST_NAME + " TEXT," +
            COL_LAST_NAME + " TEXT )";


    private static NamesDBHelper instance;

    public static NamesDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new NamesDBHelper(context.getApplicationContext());
        }
        return instance;
    }

    private NamesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TEST_TABLE_NAME);
        this.onCreate(db);
    }

    public long addName(String first, String last) {
        ContentValues values = new ContentValues();
        values.put(COL_FIRST_NAME, first);
        values.put(COL_LAST_NAME, last);

        SQLiteDatabase db = getWritableDatabase();
        long idOfNewlyInsertedRow = db.insert(TEST_TABLE_NAME, null, values);

        db.close();
        return idOfNewlyInsertedRow;
    }

    public void removeAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TEST_TABLE_NAME, null, null);
        db.close();
    }

    public int getItemCount() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TEST_TABLE_NAME, // a. table
                COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        int count = cursor.getCount();

        cursor.close();
        return count;
    }

    public List<String> getFirstHundred() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TEST_TABLE_NAME, // a. table
                COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                "100"); // h. limit

        List<String> names = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_LAST_NAME));
                names.add(name);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return names;
    }
}
