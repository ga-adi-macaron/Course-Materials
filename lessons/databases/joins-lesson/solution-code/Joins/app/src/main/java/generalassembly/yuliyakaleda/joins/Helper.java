package generalassembly.yuliyakaleda.joins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class Helper extends SQLiteOpenHelper {
  public static final String EMPLOYEE_TABLE_NAME = "employee";
  public static final String COL_ID = "id";
  public static final String COL_NAME = "name";
  public static final String COL_AGE = "age";
  public static final String COL_ADDRESS = "address";
  public static final String COL_SALARY = "salary";

  public static final String DEPARTMENT_TABLE_NAME = "department";
  public static final String COL_DEPARTMENT = "department";
  public static final String COL_EMP_ID = "emp_id";



  private Helper(Context context) {
    super(context, "db", null, 1);
  }

  private static Helper INSTANCE;

  public static synchronized Helper getInstance(Context context) {
    if (INSTANCE == null)
      INSTANCE = new Helper(context.getApplicationContext());
    return INSTANCE;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(SQL_CREATE_ENTRIES_EMPLOYEE);
    db.execSQL(SQL_CREATE_ENTRIES_DEPARTMENT);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEE);
    db.execSQL(SQL_DELETE_ENTRIES_DEPARTMENT);
    onCreate(db);
  }

  private static final String SQL_CREATE_ENTRIES_EMPLOYEE = "CREATE TABLE " +
      EMPLOYEE_TABLE_NAME + " (" +
      COL_ID + " INTEGER PRIMARY KEY," +
      COL_NAME + " TEXT," +
      COL_AGE + " INTEGER," +
      COL_ADDRESS + " TEXT," +
      COL_SALARY + " INTEGER" + ")";

  private static final String SQL_CREATE_ENTRIES_DEPARTMENT = "CREATE TABLE " +
      DEPARTMENT_TABLE_NAME + " (" +
      COL_ID + " INTEGER PRIMARY KEY," +
      COL_DEPARTMENT + " TEXT," +
      COL_EMP_ID + " INTEGER" + ")";

  private static final String SQL_DELETE_ENTRIES_EMPLOYEE = "DROP TABLE IF EXISTS " +
      EMPLOYEE_TABLE_NAME;
  private static final String SQL_DELETE_ENTRIES_DEPARTMENT = "DROP TABLE IF EXISTS " +
      DEPARTMENT_TABLE_NAME;

  public void insertRow(Employee employee) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COL_NAME, employee.getName());
    values.put(COL_AGE, employee.getAge());
    values.put(COL_ADDRESS, employee.getAddress());
    values.put(COL_SALARY, employee.getSalary());
    db.insertOrThrow(EMPLOYEE_TABLE_NAME, null, values);
  }

  public void insertRowDepartment(Department department) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COL_DEPARTMENT, department.getDept());
    values.put(COL_EMP_ID, department.getEmpId());
    db.insertOrThrow(DEPARTMENT_TABLE_NAME, null, values);
  }

  public List<String> getNameJoins() {
    //TODO: add the code from the lesson.
    SQLiteDatabase db = getWritableDatabase();
    // Building query using INNER JOIN keyword.
    String query = "SELECT "+COL_NAME+" FROM "+EMPLOYEE_TABLE_NAME+
            " INNER JOIN "+DEPARTMENT_TABLE_NAME+" ON "+
            EMPLOYEE_TABLE_NAME+"."+COL_ID+" = "+
            DEPARTMENT_TABLE_NAME+"."+COL_EMP_ID;

    Cursor cursor = db.rawQuery(query, null);

    List<String> list = new ArrayList<>();

    if (cursor.moveToFirst()){
      while (!cursor.isAfterLast()) {
        list.add(cursor.getString(cursor.getColumnIndex(COL_NAME)));
        cursor.moveToNext();
      }
    }
    cursor.close();
    return list;
  }

  //This method is the solution for the independent part of the lesson
  public List<String> getFullInformation() {
    //TODO: add the code from the lesson.
    SQLiteDatabase db = getWritableDatabase();
    // Building query using INNER JOIN keyword.
    String query = "SELECT "+COL_NAME+", "+COL_ADDRESS+", "+COL_AGE+", "+COL_SALARY+", "+COL_DEPARTMENT+" FROM "+EMPLOYEE_TABLE_NAME+" INNER JOIN " +
            DEPARTMENT_TABLE_NAME+" ON " +
            EMPLOYEE_TABLE_NAME+"."+COL_ID+" = "+DEPARTMENT_TABLE_NAME+"."+COL_EMP_ID;

    Cursor cursor = db.rawQuery(query, null);

    List<String> mInfoList = new ArrayList<>();

    if(cursor.moveToFirst()){
      while(!cursor.isAfterLast()) {
        mInfoList.add(cursor.getString(cursor.getColumnIndex(COL_NAME)) +
                ", who is " + cursor.getString(cursor.getColumnIndex(COL_AGE)) +
                " years old, lives in " + cursor.getString(cursor.getColumnIndex(COL_ADDRESS)) + ", earns $"+ cursor.getString(cursor.getColumnIndex(COL_SALARY)) + " working in the " + cursor.getString(cursor.getColumnIndex
                (COL_DEPARTMENT)) + " department.");
        cursor.moveToNext();
      }
    }
    cursor.close();

    return mInfoList;
  }
}

