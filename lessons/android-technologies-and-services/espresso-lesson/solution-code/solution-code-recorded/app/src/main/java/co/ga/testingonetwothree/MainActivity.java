package co.ga.testingonetwothree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final TextView textView = (TextView) findViewById(R.id.answerTextView);

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();

                if (TextUtils.isEmpty(value1)){
                    editText1.setError("Missing value!");
                } else if (TextUtils.isEmpty(value2)){
                    editText2.setError("Missing value!");
                } else {
                    float answer = Float.parseFloat(value1) + Float.parseFloat(value2);
                    String answerString = DecimalFormat.getCurrencyInstance().format(answer);

                    textView.setText(answerString);
                }
            }
        });
    }
}
