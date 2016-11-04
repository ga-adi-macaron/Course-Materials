package generalassembly.yuliyakaleda.interpolatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // MainActivity comes in from right, SecondActivity goes out to left
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }
}
