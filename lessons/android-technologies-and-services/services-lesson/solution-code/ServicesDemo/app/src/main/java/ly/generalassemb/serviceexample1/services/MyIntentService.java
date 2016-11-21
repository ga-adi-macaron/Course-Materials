package ly.generalassemb.serviceexample1.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by drewmahrt on 8/7/16.
 */
public class MyIntentService extends IntentService{
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String name = intent.getStringExtra("name");
        Log.i(TAG, "The intent service is doing something...");
        try {
            //Sleep the thread for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "The name in the intent is: " + name);
    }
}
