package drewmahrt.generalassemb.ly.userdictionaryexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    DictionaryRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView dictionaryRecyclerView = (RecyclerView)findViewById(R.id.dictionary_list);
        dictionaryRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter = new DictionaryRecyclerViewAdapter(new ArrayList<String>());
        dictionaryRecyclerView.setAdapter(mAdapter);

        //TODO: Initialize the loader

        Button button = (Button)findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.new_word_text);

                //TODO: Independent Practice - Insert code to add a new word to the user dictionary

                editText.setText("");
                Toast.makeText(MainActivity.this,"New word added to dictionary",Toast.LENGTH_LONG).show();
            }
        });
    }

    //TODO: Complete onCreateLoader to retrieve words from the user dictionary

    //TODO: Complete onLoadFinished to swap in the updated data

    //TODO: Complete onLoaderReset, passing the swapData method 'null'
}
