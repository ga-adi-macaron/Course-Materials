package drewmahrt.generalassemb.ly.activityresultindependentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculateActivity extends AppCompatActivity {
    private EditText mNumOneText, mNumTwoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        mNumOneText = (EditText)findViewById(R.id.num_one);
        mNumTwoText = (EditText)findViewById(R.id.num_two);

        Button button = (Button)findViewById(R.id.sum_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();

                int num1 = Integer.parseInt(mNumOneText.getText().toString());
                int num2 = Integer.parseInt(mNumTwoText.getText().toString());

                resultIntent.putExtra("num1",num1);
                resultIntent.putExtra("num2",num2);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }
}
