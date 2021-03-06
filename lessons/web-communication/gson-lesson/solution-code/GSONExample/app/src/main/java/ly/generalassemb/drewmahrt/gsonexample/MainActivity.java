package ly.generalassemb.drewmahrt.gsonexample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    //TODO: Insert your API Key into the URL
    private static String mUrl = "http://api.walmartlabs.com/v1/search?apiKey=g5p3xscxuhc7v4bgecnckwkp&query=";

    private WalmartAsyncTask mTask;
    private List<WalmartItem> mItems;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.results_list);
        mItems = new ArrayList<>();
        mAdapter = new WalmartItemRvAdapter(mItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);

        // Set up search button
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    if (mTask != null && (mTask.getStatus() != AsyncTask.Status.FINISHED)) {
                        mTask.cancel(true);
                    }
                    mTask = new WalmartAsyncTask();
                    String query = ((EditText)findViewById(R.id.search_text)).getText().toString();
                    mTask.execute(mUrl+query);
                } else {
                    Toast.makeText(MainActivity.this, "No network connection detected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class WalmartAsyncTask extends AsyncTask<String, Void, WalmartSearchResult> {

        @Override
        protected WalmartSearchResult doInBackground(String... params) {
            WalmartSearchResult result = null;

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(params[0])
                    .build();

            try {
                Response response = client.newCall(request).execute();

                Gson gson = new Gson();

                result = gson.fromJson(response.body().string(), WalmartSearchResult.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(WalmartSearchResult s) {
            super.onPostExecute(s);
            mItems.clear();
            mItems.addAll(s.getItems());
            mAdapter.notifyDataSetChanged();
        }
    }
}
