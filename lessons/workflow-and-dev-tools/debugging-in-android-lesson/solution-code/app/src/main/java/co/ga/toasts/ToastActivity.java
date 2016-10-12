package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                Toast.makeText(ToastActivity.this, "Something bought!", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.likeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "You liked this button!", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "The world was saved.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "Something was sent!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
