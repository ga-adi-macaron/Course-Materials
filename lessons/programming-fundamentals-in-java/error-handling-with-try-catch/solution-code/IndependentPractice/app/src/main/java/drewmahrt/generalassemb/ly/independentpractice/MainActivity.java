package drewmahrt.generalassemb.ly.independentpractice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText)findViewById(R.id.editText);

        readFromFile();

        Button button = (Button)findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(MainActivity.this.openFileOutput("config.txt", Context.MODE_PRIVATE));
                    outputStreamWriter.write(mEditText.getText().toString());
                    outputStreamWriter.close();
                }
                catch (IOException e) {
                    Log.e("Exception", "File write failed");
                    e.printStackTrace();
                }
            }
        });
    }

    private void readFromFile() {

        try {
            String value = "";
            InputStream inputStream = openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                value = stringBuilder.toString();

                mEditText.setText(value);
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("login activity", "Can not read file");
            e.printStackTrace();
        }
    }
}
