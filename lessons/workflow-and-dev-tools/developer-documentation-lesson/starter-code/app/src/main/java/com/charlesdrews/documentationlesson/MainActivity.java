package com.charlesdrews.documentationlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firstButton = (Button) findViewById(R.id.button1);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update the text
                EditText text = (EditText) findViewById(R.id.text);
                text.setText("You clicked the button!");

                // change the button's color
                view.setBackgroundColor(R.color.colorAccent);
            }
        });

        Button secondButton = (Button) findViewById(R.id.button2);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // reset the text
                text.setText("Hello world!");

                // launch second activity
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
