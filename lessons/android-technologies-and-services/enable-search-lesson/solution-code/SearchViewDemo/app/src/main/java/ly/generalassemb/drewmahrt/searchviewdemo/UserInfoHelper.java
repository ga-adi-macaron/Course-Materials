package ly.generalassemb.drewmahrt.searchviewdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drewmahrt on 12/30/15.
 */
public class UserInfoHelper extends SQLiteOpenHelper {
    private static final String TAG = UserInfoHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_info.db";
    public static final String NUMBERS_TABLE_NAME = "people";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";

    public static final String[] NUMBERS_COLUMNS = {COL_ID, COL_NAME, COL_AGE};

    private static final String CREATE_NUMBERS_TABLE =
            "CREATE TABLE " + NUMBERS_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_NAME + " TEXT," +
                    COL_AGE + "INT)";


    private static UserInfoHelper instance;

    public static UserInfoHelper getInstance(Context context){
        if(instance == null){
            instance = new UserInfoHelper(context.getApplicationContext());
        }
        return instance;
    }

    private UserInfoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NUMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NUMBERS_TABLE_NAME);
        onCreate(db);
    }

    public List<Person> searchForOlderPeople(String query){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NUMBERS_TABLE_NAME, // a. table
                NUMBERS_COLUMNS, // b. column names
                COL_AGE +" > ?", // c. selections
                new String[]{query}, // d. selections args
                null, // e. group by
                null, // f. having
                COL_AGE, // g. order by
                null); // h. limit

        List<Person> people = new ArrayList<>();

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Person p = new Person(cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getInt(cursor.getColumnIndex(COL_AGE)));
                people.add(p);
                cursor.moveToNext();
            }
        }

        return people;
    }

    public List<Person> searchSimilarNames(String query){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NUMBERS_TABLE_NAME, // a. table
                NUMBERS_COLUMNS, // b. column names
                COL_NAME +" LIKE ?", // c. selections
                new String[]{query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        List<Person> people = new ArrayList<>();

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Person p = new Person(cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getInt(cursor.getColumnIndex(COL_AGE)));
                people.add(p);

                cursor.moveToNext();
            }
        }

        return people;
    }
}
