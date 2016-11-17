package generalassembly.yuliyakaleda.downloaddata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
  public static final String URL = "http://httpbin.org/get?x=10&y=hello";
  public static final String POST_URL = "http://httpbin.org/post";
  private TextView mDataTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mDataTextView = (TextView) findViewById(R.id.text);

    ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      Toast.makeText(MainActivity.this, "Network is active", Toast.LENGTH_SHORT).show();

      githubRepos();

      //performPostRequest();

      //performGetRequest();

      //new DownloadTask().execute(URL);
    } else {
      Toast.makeText(this, R.string.check_network, Toast.LENGTH_LONG).show();
    }
  }

  private void githubRepos(){
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://api.github.com/users/[YOUR USERNAME]/repos")
            .build();

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if(!response.isSuccessful()){
          throw new IOException("Unexpected code: "+response);
        }

        try {
          final StringBuilder repoList = new StringBuilder();
          JSONArray array = new JSONArray(response.body().string());
          for (int i = 0; i < array.length(); i++) {
            JSONObject repo = array.getJSONObject(i);
            String repoName = repo.getString("name");
            repoList.append(repoName + " \n");
          }

          MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
              mDataTextView.setText(repoList.toString());
            }
          });

        }catch (JSONException e){
          e.printStackTrace();
        }

      }
    });
  }

  private void performGetRequest(){
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url(URL)
            .build();

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if(!response.isSuccessful()){
          throw new IOException("Unexpected code: "+response);
        }

        try {
          JSONObject json = new JSONObject(response.body().string());
          JSONObject args = json.getJSONObject("args");
          final String x = args.getString("x");
          final String y = args.getString("y");

          MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
              mDataTextView.setText(x+" "+y);
            }
          });
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }
    });
  }

  private void performPostRequest(){
    OkHttpClient client = new OkHttpClient();

    RequestBody body = new FormBody.Builder()
            .add("username","drew")
            .add("password","12345")
            .build();

    Request request = new Request.Builder()
            .url(POST_URL)
            .post(body)
            .build();

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if(!response.isSuccessful()){
          throw new IOException("Unexpected code: "+response);
        }

        final String body = response.body().string();
        MainActivity.this.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            mDataTextView.setText(body);
          }
        });

      }
    });
  }

  private class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder()
              .url(strings[0])
              .build();

      try {
        Response response = client.newCall(request).execute();
        return response.body().string();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return null;
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String s) {

      try {
        JSONObject json = new JSONObject(s);
        JSONObject args = json.getJSONObject("args");
        String x = args.getString("x");
        String y = args.getString("y");
        mDataTextView.setText(x+" "+y);
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
  }
}
