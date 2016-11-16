package drewmahrt.generalassemb.ly.arrayoutofbounds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] mStringArray;
    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.text);
        mEditText = (EditText)findViewById(R.id.input);

        mStringArray = new String[]{"joe","bob","jane"};

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(mEditText.getText().toString());
                mTextView.setText("Name: " + mStringArray[index]);
            }
        });
    }
}
