package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = DatabaseHelper.getInstance(this);
        db.insert("Sony", "40", 299.99);
        db.insert("Hitachi", "40", 349.99);
        db.insert("Sony", "80", 499.99);
        db.insert("Sharp", "29", 149.99);
        db.insert("LG", "30", 99.99);

        Television addedTV = db.getTV(4);
        printTV(addedTV);

        db.delete(1);
        db.delete(4);

        Television deletedTV = db.getTV(4);
        printTV(deletedTV);

    }

    public void printTV(Television tv){
        if(tv == null){
            Log.d(TAG, "onCreate: NULL TV");
        }else{
            Log.d(TAG, "onCreate: "+tv.getBrand());
        }
    }
}
