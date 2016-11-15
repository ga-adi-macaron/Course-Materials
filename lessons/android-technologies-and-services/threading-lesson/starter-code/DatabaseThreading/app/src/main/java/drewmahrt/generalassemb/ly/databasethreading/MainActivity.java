package drewmahrt.generalassemb.ly.databasethreading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify.NamesDBHelper;
import drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify.NamesRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private NamesDBHelper mDBHelper;
    private NamesRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mTextView = (TextView) findViewById(R.id.text);

        mDBHelper = NamesDBHelper.getInstance(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> firstHundredNames = mDBHelper.getFirstHundred();

        mAdapter = new NamesRecyclerViewAdapter(firstHundredNames);
        recyclerView.setAdapter(mAdapter);

        Button addButton = (Button) findViewById(R.id.button_add);
        Button removeButton = (Button) findViewById(R.id.button_remove);

        addButton.setOnClickListener(this);
        removeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.button_add:
                addDatabaseItems(1000);
                break;

            case R.id.button_remove:
                removeDatabaseItems();
                break;
        }
    }

    private void addDatabaseItems(int numItemsToAdd){
        mTextView.setText("Adding items to database...");
        mProgressBar.setVisibility(View.VISIBLE);

        for (int i = 1; i <= numItemsToAdd; i++) {
            mDBHelper.addName("John", "Doe " + i);
        }

        int count = NamesDBHelper.getInstance(getApplicationContext()).getItemCount();
        mTextView.setText("All items added to database! Current item count: " + count);

        mProgressBar.setVisibility(View.INVISIBLE);

        mAdapter.updateNames(mDBHelper.getFirstHundred());
    }

    private void removeDatabaseItems() {
        mDBHelper.removeAll();

        int count = NamesDBHelper.getInstance(getApplicationContext()).getItemCount();
        mTextView.setText("Current item count: " + count);

        mAdapter.updateNames(mDBHelper.getFirstHundred());
    }
}
