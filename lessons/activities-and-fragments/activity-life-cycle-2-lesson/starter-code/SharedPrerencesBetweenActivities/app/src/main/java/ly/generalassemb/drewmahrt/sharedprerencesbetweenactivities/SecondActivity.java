package ly.generalassemb.drewmahrt.sharedprerencesbetweenactivities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView)findViewById(R.id.message_text_view);

        //TODO: Retrieve the text from SharedPreferences and set it to the String variable "message"

        textView.setText("Message from MainActivity: "+message);
    }
}
