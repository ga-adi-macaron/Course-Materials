package drewmahrt.generalassemb.ly.activityresultindependentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_REQUEST = 20;
    private static final int SUBTRACT_REQUEST = 21;

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.result_text);

        Button addButton = (Button)findViewById(R.id.add_button);
        Button subtractButton = (Button)findViewById(R.id.subtract_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,CalculateActivity.class),ADD_REQUEST);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,CalculateActivity.class),SUBTRACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_REQUEST){
            if(resultCode == RESULT_OK){
                int num1 = data.getIntExtra("num1",Integer.MIN_VALUE);
                int num2 = data.getIntExtra("num2",Integer.MIN_VALUE);
                mTextView.setText("Sum: "+(num1+num2));
            }
        } else if(requestCode == SUBTRACT_REQUEST){
            if(resultCode == RESULT_OK){
                int num1 = data.getIntExtra("num1",Integer.MIN_VALUE);
                int num2 = data.getIntExtra("num2",Integer.MIN_VALUE);
                mTextView.setText("Difference: "+(num1-num2));
            }
        }
    }
}
