package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify.NamesDBHelper;
import drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify.NamesRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private NamesDBHelper mDBHelper;
    private NamesRecyclerViewAdapter mAdapter;
    private AsyncTask<Integer, Integer, List<String>> mTask;

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
        switch (v.getId()) {

            case R.id.button_add:
                addDatabaseItems(1000);
                break;

            case R.id.button_remove:
                removeDatabaseItems();
                break;
        }
    }

    private void removeDatabaseItems() {
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            Toast.makeText(this, "Still adding data to the database. Please wait",
                    Toast.LENGTH_LONG).show();
        } else {
            mDBHelper.removeAll();

            int count = mDBHelper.getItemCount();
            mTextView.setText("Current item count: " + count);

            mAdapter.updateNames(mDBHelper.getFirstHundred());
        }
    }

    public void addDatabaseItems(int numItemsToAdd) {

        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            Toast.makeText(this, "Still adding data to the database. Please wait",
                    Toast.LENGTH_LONG).show();
        } else {
            mTask = new AsyncTask<Integer, Integer, List<String>>() {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    mTextView.setText("Adding items to database...");
                    mProgressBar.setVisibility(View.VISIBLE);
                }

                @Override
                protected List<String> doInBackground(Integer... integers) {
                    for (int i = 1; i <= integers[0]; i++) {
                        mDBHelper.addName("John", "Doe " + i);
                        publishProgress(i);
                    }
                    return mDBHelper.getFirstHundred();
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
                    super.onProgressUpdate(values);
                    mTextView.setText("Adding items to database... " + values[0]);
                }

                @Override
                protected void onPostExecute(List<String> strings) {
                    super.onPostExecute(strings);

                    mProgressBar.setVisibility(View.INVISIBLE);

                    int count = mDBHelper.getItemCount();
                    mTextView.setText("All items added to database! Current item count: " + count);

                    mAdapter.updateNames(mDBHelper.getFirstHundred());
                }
            };

            mTask.execute(numItemsToAdd);
        }
    }
}
