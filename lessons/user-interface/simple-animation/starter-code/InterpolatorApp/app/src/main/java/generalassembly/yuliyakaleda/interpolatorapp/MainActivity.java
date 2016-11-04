package generalassembly.yuliyakaleda.interpolatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView) findViewById(R.id.animated_view);

        Button animate = (Button) findViewById(R.id.animate_button);
        animate.setOnClickListener(this);

        Button transition = (Button) findViewById(R.id.transition_button);
        transition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.animate_button:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.down_and_back);
                mText.startAnimation(animation);
                break;

            case R.id.transition_button:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                // SecondActivity comes in from left, MainActivity goes out to right
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                break;
        }
    }
}
