package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class ProductsDBHandler extends SQLiteOpenHelper {
  private static final String TAG = "ProductsDBHandler";

  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = "productDB.db";

  public static final String TABLE_PRODUCTS = ProductsContract.Products.TABLE_PRODUCTS;
  public static final String COLUMN_ID = BaseColumns._ID;
  public static final String COLUMN_PRODUCTNAME = ProductsContract.Products.COLUMN_PRODUCTNAME;
  public static final String COLUMN_QUANTITY = ProductsContract.Products.COLUMN_QUANTITY;

  private static ProductsDBHandler mInstance;

  public static ProductsDBHandler getInstance(Context context){
    if(mInstance == null){
      mInstance = new ProductsDBHandler(context);
    }
    return mInstance;
  }

  private ProductsDBHandler(Context context) {
    super(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_PRODUCTS_TABLE = "CREATE TABLE "
            + TABLE_PRODUCTS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_PRODUCTNAME + " TEXT,"
            + COLUMN_QUANTITY + " INTEGER" + ")";
    db.execSQL(CREATE_PRODUCTS_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
    onCreate(db);
  }

  public long addProduct(ContentValues values) {
    SQLiteDatabase db = getWritableDatabase();
    long insertedRow = db.insert(TABLE_PRODUCTS, null, values);
    db.close();
    return insertedRow;
  }

  public Cursor findProduct(String selection, String[] selectionArgs, String sortOrder, String id){

    SQLiteDatabase db = getReadableDatabase();

    Cursor cursor = null;

    if(id == null)
      cursor = db.query(TABLE_PRODUCTS,null,selection,selectionArgs,null,null,sortOrder);
    else
      cursor = db.query(TABLE_PRODUCTS,null,COLUMN_ID+" = ?",new String[]{id},null,null,sortOrder);

    return cursor;
  }

  public int deleteProduct(String selection, String[] selectionArgs, String id) {
    SQLiteDatabase db = getWritableDatabase();

    int rowsDeleted = 0;

    if(id == null)
      rowsDeleted = db.delete(TABLE_PRODUCTS,selection,selectionArgs);
    else
      rowsDeleted = db.delete(TABLE_PRODUCTS,COLUMN_ID+" = ?",new String[]{id});

    db.close();
    return rowsDeleted;
  }

  public int updateProduct(ContentValues values, String selection, String[] selectionArgs, String id){
    SQLiteDatabase db = getWritableDatabase();

    int updatedRows = 0;

    if(id == null)
      updatedRows = db.update(TABLE_PRODUCTS,values,selection,selectionArgs);
    else
      updatedRows = db.update(TABLE_PRODUCTS,values,COLUMN_ID+" = ?",new String[]{id});

    db.close();
    return updatedRows;
  }

}
