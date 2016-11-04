package generalassembly.yuliyakaleda.viewanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private TextView text;
  private Button scale;
  private Button rotate;
  private Button fade;
  private Button translate;
  private Button complex;
  private Button nextActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    text = (TextView) findViewById(R.id.text);
    scale = (Button) findViewById(R.id.scale);
    rotate = (Button) findViewById(R.id.rotate);
    fade = (Button) findViewById(R.id.fade);
    translate = (Button) findViewById(R.id.translate);
    complex = (Button) findViewById(R.id.comlex);
    nextActivity = (Button) findViewById(R.id.next_activity_button);

    scale.setOnClickListener(this);
    rotate.setOnClickListener(this);
    fade.setOnClickListener(this);
    translate.setOnClickListener(this);
    complex.setOnClickListener(this);
    nextActivity.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Animation animation = null;
    switch (v.getId()){
      case R.id.scale:
        animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        text.startAnimation(animation);
        break;
      case R.id.rotate:
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        text.startAnimation(animation);
        break;
      case R.id.fade:
        animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        text.startAnimation(animation);
        break;
      case R.id.translate:
        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        text.startAnimation(animation);
        break;
      case R.id.comlex:
        animation = AnimationUtils.loadAnimation(this, R.anim.complex_animation);
        text.startAnimation(animation);
        break;
      case R.id.next_activity_button:
        Intent intent = new Intent(this, LayoutAnimationActivity.class);
        startActivity(intent);
      default:
        break;
    }
  }
}
