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

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    DictionaryRecyclerViewAdapter mAdapter;

    private static final int WORD_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView dictionaryRecyclerView = (RecyclerView)findViewById(R.id.dictionary_list);
        dictionaryRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter = new DictionaryRecyclerViewAdapter(new ArrayList<String>());
        dictionaryRecyclerView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(WORD_LOADER,null,this);

        Button button = (Button)findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.new_word_text);

                //Manual

                //Create an object to contain the new values to insert
//                ContentValues newValues = new ContentValues();
//                newValues.put(UserDictionary.Words.APP_ID, getApplicationInfo().uid);
//                newValues.put(UserDictionary.Words.LOCALE, "en_US");
//                newValues.put(UserDictionary.Words.WORD, editText.getText().toString());
//                newValues.put(UserDictionary.Words.FREQUENCY, "100");
//
//
//                getContentResolver().insert(
//                        UserDictionary.Words.CONTENT_URI,
//                        newValues
//                );

                //Using helper method

                UserDictionary.Words.addWord(
                        MainActivity.this,
                        editText.getText().toString(),
                        100,
                        null,
                        Locale.US
                );

                editText.setText("");
                Toast.makeText(MainActivity.this,"New word added to dictionary",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id){
            case WORD_LOADER:
                return new CursorLoader(this,
                        UserDictionary.Words.CONTENT_URI,
                        new String[]{UserDictionary.Words.WORD},
                        null,
                        null,
                        null
                );
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.swapData(cursor);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        mAdapter.swapData(null);
    }
}
