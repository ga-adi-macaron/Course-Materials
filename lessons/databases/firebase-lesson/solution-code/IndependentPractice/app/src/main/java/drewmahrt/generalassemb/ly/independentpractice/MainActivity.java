package drewmahrt.generalassemb.ly.independentpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity {
    Firebase mRef;

    EditText mBox1, mBox2, mBox3, mBox4, mBox5, mBox6, mBox7, mBox8, mBox9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRef = new Firebase("https://tictactoedrew.firebaseio.com/picks");

        mBox1 = (EditText)findViewById(R.id.box1);
        mBox2 = (EditText)findViewById(R.id.box2);
        mBox3 = (EditText)findViewById(R.id.box3);
        mBox4 = (EditText)findViewById(R.id.box4);
        mBox5 = (EditText)findViewById(R.id.box5);
        mBox6 = (EditText)findViewById(R.id.box6);
        mBox7 = (EditText)findViewById(R.id.box7);
        mBox8 = (EditText)findViewById(R.id.box8);
        mBox9 = (EditText)findViewById(R.id.box9);

        setupEditTexts();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String pickValue = dataSnapshot.getValue(String.class);
                switch (dataSnapshot.getKey()){
                    case "box1": mBox1.setText(pickValue); break;
                    case "box2": mBox2.setText(pickValue); break;
                    case "box3": mBox3.setText(pickValue); break;
                    case "box4": mBox4.setText(pickValue); break;
                    case "box5": mBox5.setText(pickValue); break;
                    case "box6": mBox6.setText(pickValue); break;
                    case "box7": mBox7.setText(pickValue); break;
                    case "box8": mBox8.setText(pickValue); break;
                    case "box9": mBox9.setText(pickValue); break;
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String pickValue = dataSnapshot.getValue(String.class);
                switch (dataSnapshot.getKey()){
                    case "box1": mBox1.setText(pickValue); break;
                    case "box2": mBox2.setText(pickValue); break;
                    case "box3": mBox3.setText(pickValue); break;
                    case "box4": mBox4.setText(pickValue); break;
                    case "box5": mBox5.setText(pickValue); break;
                    case "box6": mBox6.setText(pickValue); break;
                    case "box7": mBox7.setText(pickValue); break;
                    case "box8": mBox8.setText(pickValue); break;
                    case "box9": mBox9.setText(pickValue); break;
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void setupEditTexts(){
        mBox1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box1").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box2").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box3").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box4").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box5").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box6").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box7").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box8").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBox9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("box1: "+s);
                mRef.child("/box9").setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
