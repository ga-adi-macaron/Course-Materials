package ly.generalassemb.serviceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * TODO NOTE:
         *
         * Make sure to destroy any running services or they will run indefinitely
         * because we did not bind to them but started them!
         *
         * Think what happens if we close the app or activity but never pressed the
         * stop service buttons.
         */
    }

    private void setViews(){
        setServiceViews();
        setIntentServiceViews();
    }

    private void setServiceViews(){
        Button startButton = (Button) findViewById(R.id.button_start);
        Button stopButton = (Button) findViewById(R.id.button_stop);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO START your CustomService here

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO STOP your CustomService here

            }
        });
    }

    private void setIntentServiceViews(){
        Button startButton = (Button) findViewById(R.id.button_start_intent_service);
        Button stopButton = (Button) findViewById(R.id.button_stop_intent_service);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO START your CustomIntentService here

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO STOP your CustomIntentService here

            }
        });
    }
}
