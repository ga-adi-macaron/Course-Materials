package ly.generalassemb.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ly.generalassemb.serviceexample.services.CustomIntentService;
import ly.generalassemb.serviceexample.services.CustomService;

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
         * Make sure to destroy any running services or they will run indefinitely
         * because we did not bind to them but started them!
         */
        Intent serviceIntent = new Intent(MainActivity.this, CustomService.class);
        stopService(serviceIntent);

        serviceIntent = new Intent(MainActivity.this, CustomIntentService.class);
        stopService(serviceIntent);
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
                Intent serviceIntent = new Intent(MainActivity.this, CustomService.class);
                startService(serviceIntent);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, CustomService.class);
                stopService(serviceIntent);
            }
        });
    }

    private void setIntentServiceViews(){
        Button startButton = (Button) findViewById(R.id.button_start_intent_service);
        Button stopButton = (Button) findViewById(R.id.button_stop_intent_service);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, CustomIntentService.class);
                startService(serviceIntent);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, CustomIntentService.class);
                stopService(serviceIntent);
            }
        });
    }
}
