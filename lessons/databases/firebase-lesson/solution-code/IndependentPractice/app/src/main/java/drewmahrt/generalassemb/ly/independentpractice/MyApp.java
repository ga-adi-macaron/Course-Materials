package drewmahrt.generalassemb.ly.independentpractice;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by drewmahrt on 3/23/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
