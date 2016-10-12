package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        findViewById(R.id.buyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something here when the "buy" button is clicked
                Log.d("TAG", "onClick: buy");
            }
        });

        findViewById(R.id.likeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something here when the "like" button is clicked
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something here when the "save" button is clicked
            }
        });

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something here when the "send" button is clicked
            }
        });
    }
}
