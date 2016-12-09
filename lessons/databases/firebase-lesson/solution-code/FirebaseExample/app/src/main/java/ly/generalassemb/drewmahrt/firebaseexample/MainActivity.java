package ly.generalassemb.drewmahrt.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button mSubmitButton;
    EditText mNewText;
    TextView mCurrentText;
    RecyclerView mRecyclerView;

    List<String> mList;

    TextRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitButton = (Button)findViewById(R.id.submit_button);
        mNewText = (EditText)findViewById(R.id.edit_text);
        //mCurrentText = (TextView)findViewById(R.id.current_text);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mList = new ArrayList<>();
        mAdapter = new TextRecyclerViewAdapter(mList);
//        mRecyclerView.setAdapter(mAdapter);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("currentText");

        FirebaseRecyclerAdapter firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<String, TextRecyclerViewAdapter.TextViewHolder>(String.class, android.R.layout.simple_list_item_1, TextRecyclerViewAdapter.TextViewHolder.class, myRef) {
            @Override
            public void populateViewHolder(TextRecyclerViewAdapter.TextViewHolder textViewHolder, String text, int position) {
                textViewHolder.mTextView.setText(text);
            }
        };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);

//        mSubmitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myRef.setValue(mNewText.getText().toString());
//            }
//        });


//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                mCurrentText.setText(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError firebaseError) {
//
//            }
//        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue(mNewText.getText().toString());
            }
        });

//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                mList.add(dataSnapshot.getValue(String.class));
//                mAdapter.notifyItemInserted(mList.size()-1);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }
}
