package com.charlesdrews.documentationlesson;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare "text" here so that it is in scope for both on-click listeners
        //final EditText text = (EditText) findViewById(R.id.text);

        // java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.EditText.setText(java.lang.CharSequence)' on a null object reference
        // wrong id specified! should be text1
        //final EditText text = (EditText) findViewById(R.id.text1);

        // java.lang.ClassCastException: android.support.v7.widget.AppCompatTextView cannot be cast to android.widget.EditText
        // should be TextView, not EditText!
        final TextView text = (TextView) findViewById(R.id.text1);

        Button firstButton = (Button) findViewById(R.id.button1);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update the text

                // Error:(47, 17) error: cannot find symbol variable text
                // move this declaration up so it's in scope for both on-click listeners
                //EditText text = (EditText) findViewById(R.id.text);

                text.setText("You clicked the button!");

                // change the button's color

                // hmm, button just turns gray, not pink
                // When we hover over the red squiggly lines Android Studio says "Should pass resolved color instead of resource here"
                // StackOverflow gives a variety of solutions, none of which work quite right
                // Look at the official reference:https://developer.android.com/reference/android/view/View.html
                // Notice that in addition to setBackgroundColor() there is also setBackgroundResource()
                //view.setBackgroundColor(R.color.colorAccent);
                view.setBackgroundResource(R.color.colorAccent);
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

                //Error message:
                // android.content.ActivityNotFoundException: Unable to find explicit activity class {com.charlesdrews.documentationlesson/com.charlesdrews.documentationlesson.SecondActivity};
                // have you declared this activity in your AndroidManifest.xml?

                // to the manifest!
            }
        });

        Button thirdButton = (Button) findViewById(R.id.button3);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Here is my title")
                        .setMessage("Here is my message")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "you clicked OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "you clicked Cancel", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
