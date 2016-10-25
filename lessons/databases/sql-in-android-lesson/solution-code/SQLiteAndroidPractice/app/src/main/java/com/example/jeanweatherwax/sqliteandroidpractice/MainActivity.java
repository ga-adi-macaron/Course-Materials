package com.example.jeanweatherwax.sqliteandroidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Super Mario", "1985");
        db.insert(2, "Legend of Zelda", "1986");

        Game retrievedGame = db.getGame(2);
    }

}
