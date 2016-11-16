package drewmahrt.generalassemb.ly.divisionexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mNumerator, mDivisor;
    TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumerator = (EditText)findViewById(R.id.numeratorText);
        mDivisor = (EditText)findViewById(R.id.divisorText);

        mResultText = (TextView)findViewById(R.id.resultText);

        Button button = (Button)findViewById(R.id.divideButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numerator = Integer.parseInt(mNumerator.getText().toString());
                int divisor = Integer.parseInt(mDivisor.getText().toString());
                int result = numerator/divisor;
                mResultText.setText("Result: "+result);
            }
        });
    }
}
