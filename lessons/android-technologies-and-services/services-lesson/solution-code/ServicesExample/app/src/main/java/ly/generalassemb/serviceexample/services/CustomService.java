package ly.generalassemb.serviceexample.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by alex on 4/13/16.
 */
public class CustomService extends Service {
    private static final String TAG = "CustomService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Started, should do some work");

        // create thread and pass in a runnable task
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep the thread for 10 seconds then we will show toast
                    Thread.sleep(10000);
                    Log.i(TAG,"Service is done working!");
                    //Optional to call stopSelf() here since this service should be stopped in
                    //onStop of MainActivity
                    //stopSelf();
                } catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });

        // start the thread
        thread.start();

        // toast after the "work" was finished
        Toast.makeText(getApplicationContext(), "Service work is happening", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service Destroyed");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }
}
