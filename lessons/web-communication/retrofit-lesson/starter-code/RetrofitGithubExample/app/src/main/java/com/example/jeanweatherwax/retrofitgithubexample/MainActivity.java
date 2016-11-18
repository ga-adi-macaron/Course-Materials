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

    //declare baseUrl

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
                //call getUserInfo on button click
            }
        });


    }

    protected void getUserInfo(String userName) {

        Log.d("MainActivity: ", "getting github info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            //Get a Retrofit.Builder()
            //set .baseURL
            //set .addConverterFactory with Gson and .create it
            //.build() the retrofit

            //get an instance of GitHubService


            //Get a Call of type User with the service and getUser method

            //use .enqueue to get the response.
            //use a try/catch to get the userName, location, and company and display them
        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
}
