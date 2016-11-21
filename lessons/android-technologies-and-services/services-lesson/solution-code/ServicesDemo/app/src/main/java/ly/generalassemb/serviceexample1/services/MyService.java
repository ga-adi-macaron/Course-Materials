package ly.generalassemb.serviceexample1.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by drewmahrt on 8/7/16.
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");

        //Create and start a HandlerThread
        mHandlerThread = new HandlerThread("My Thread");
        mHandlerThread.start();

        //Get the Looper from the new HandlerThread, and create a new Handler with it
        Looper looper = mHandlerThread.getLooper();
        mHandler = new Handler(looper) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                //Get the name string from the Message
                String name = (String) msg.obj;
                Log.i(TAG, "The handler is doing something...");
                try {
                    //Sleep the thread for 5 seconds
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "The name in the message is: " + name);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");

        Message msg = mHandler.obtainMessage();
        msg.obj = intent.getStringExtra("name");
        mHandler.sendMessage(msg);

        Toast.makeText(MyService.this, "Hello from the MyService!", Toast.LENGTH_SHORT).show();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Service is being destroyed");
        super.onDestroy();
    }
}
