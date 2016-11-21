package ly.generalassemb.serviceexample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ly.generalassemb.serviceexample1.services.MyIntentService;
import ly.generalassemb.serviceexample1.services.MyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this,MyService.class);
        intent.putExtra("name","Drew");
        startService(intent);

        Intent intent2 = new Intent(MainActivity.this, MyIntentService.class);
        intent2.putExtra("name","Drew");
        startService(intent2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(MainActivity.this,MyService.class));
    }
}
