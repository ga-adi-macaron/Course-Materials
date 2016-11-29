package com.charlesdrews.trendingproductsmvpdemo.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper for local database of favorite products
 * <p>
 * Created by charlie on 11/10/16.
 */

public class FavoriteProductsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "favorites.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "favorite_products";
    private static final String COL_ID = "_id";
    private static final String COL_ID_TYPE = "INTEGER PRIMARY KEY";
    private static final String COL_NAME = "name";
    private static final String COL_NAME_TYPE = "TEXT";
    private static final String COL_BRAND = "brand";
    private static final String COL_BRAND_TYPE = "TEXT";
    private static final String COL_IMAGE_URL = "image_url";
    private static final String COL_IMAGE_URL_TYPE = "TEXT";
    private static final String COL_PRICE = "price";
    private static final String COL_PRICE_TYPE = "REAL";

    private static final String CREATE_STATEMENT = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " " + COL_ID_TYPE + ", " +
            COL_NAME + " " + COL_NAME_TYPE + ", " +
            COL_BRAND + " " + COL_BRAND_TYPE + ", " +
            COL_IMAGE_URL + " " + COL_IMAGE_URL_TYPE + ", " +
            COL_PRICE + " " + COL_PRICE_TYPE + ")";

    private static final String DROP_STATEMENT = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static FavoriteProductsDbHelper sInstance;

    public static FavoriteProductsDbHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new FavoriteProductsDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private FavoriteProductsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_STATEMENT);
        onCreate(sqLiteDatabase);
    }

    public List<Product> getFavoriteProducts() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String brand = cursor.getString(cursor.getColumnIndex(COL_BRAND));
                String imageUrl = cursor.getString(cursor.getColumnIndex(COL_IMAGE_URL));
                float price = cursor.getFloat(cursor.getColumnIndex(COL_PRICE));

                products.add(new Product(id, name, brand, imageUrl, price, true));

                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();
        return products;
    }

    public boolean isProductInFavorites(int productId) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null,
                COL_ID + " = ?",
                new String[]{String.valueOf(productId)},
                null, null, null);

        boolean productIsInFavorites = cursor.moveToFirst();
        cursor.close();
        db.close();
        return productIsInFavorites;
    }

    public void addProductToDb(Product product) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, product.getId());
        contentValues.put(COL_NAME, product.getName());
        contentValues.put(COL_BRAND, product.getBrand());
        contentValues.put(COL_IMAGE_URL, product.getThumbnailImageUrl());
        contentValues.put(COL_PRICE, product.getPrice());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void removeProductFromDb(int productId) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_NAME, COL_ID + " = ?", new String[]{String.valueOf(productId)});

        db.close();
    }
}
