package ly.generalassemb.drewmahrt.saveactivitycreationtime;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String mTimeStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeStarted = Calendar.getInstance().getTime().toString();

        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(mTimeStarted);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mTimeStarted = savedInstanceState.getString("timeStarted");
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(mTimeStarted);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("timeStarted",mTimeStarted);
        super.onSaveInstanceState(outState);
    }
}
