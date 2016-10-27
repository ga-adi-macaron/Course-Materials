package ly.generalassemb.drewmahrt.detailviewdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class ExampleSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = ExampleSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TEST_DB";
    public static final String EXAMPLE_LIST_TABLE_NAME = "EXAMPLE_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";

    public static final String[] EXAMPLE_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_DESCRIPTION};

    private static final String CREATE_EXAMPLE_LIST_TABLE =
            "CREATE TABLE " + EXAMPLE_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT )";

    private static ExampleSQLiteOpenHelper mInstance;

    //TODO - convert this class to a singleton - DONE!
    public static ExampleSQLiteOpenHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new ExampleSQLiteOpenHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    private ExampleSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXAMPLE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXAMPLE_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public List<ExampleObject> getExampleList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(EXAMPLE_LIST_TABLE_NAME, // a. table
                EXAMPLE_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        List<ExampleObject> objects = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
                String description = cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));

                ExampleObject object = new ExampleObject(id, name, description);
                objects.add(object);

                cursor.moveToNext();
            }
        }

        cursor.close();
        return objects;
    }

    //TODO - Add a helper method to take an item's id and return the item's description - DONE!
    public String getDescriptionById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(EXAMPLE_LIST_TABLE_NAME,
                new String[]{COL_ITEM_DESCRIPTION},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);


        if(cursor.moveToFirst()){
            String description = cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
            cursor.close();
            return description;
        } else {
            cursor.close();
            return "No Description Found";
        }
    }
}
