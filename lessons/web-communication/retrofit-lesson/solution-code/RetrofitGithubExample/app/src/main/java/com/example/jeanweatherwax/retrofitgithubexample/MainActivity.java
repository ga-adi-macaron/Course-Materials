package com.example.jeanweatherwax.retrofitgithubexample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeanweatherwax.retrofitgithubexample.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String baseUrl = "https://api.github.com/";
    EditText editText;
    Button button;
    TextView nameView, locationView, companyView;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_user);
        button = (Button) findViewById(R.id.button);

        nameView = (TextView) findViewById(R.id.name);
        locationView = (TextView) findViewById(R.id.email);
        companyView = (TextView) findViewById(R.id.company);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editText.getText().toString();
                getUserInfo(userName);
            }
        });
    }

    protected void getUserInfo(String userName) {
        Log.d("MainActivity: ", "getting github info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubService service = retrofit.create(GitHubService.class);

            Call<User> call = service.getUser(userName);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    try {
                        String userName = response.body().getName();

                        String location = response.body().getLocation();

                        String company = response.body().getCompany();

                        nameView.setText("GitHub Name: " + userName);
                        locationView.setText("location: " + location);
                        companyView.setText("Company: " + company);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
