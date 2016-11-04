package generalassembly.yuliyakaleda.viewanimation;


import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LayoutAnimationActivity extends AppCompatActivity implements View.OnClickListener{
  private ViewGroup viewGroup;
  private Button add;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_animation_activity);
    LayoutTransition l = new LayoutTransition();
    l.enableTransitionType(LayoutTransition.CHANGING);
    viewGroup = (ViewGroup) findViewById(R.id.ll);
    viewGroup.setLayoutTransition(l);

    add = (Button) findViewById(R.id.add);
    add.setOnClickListener(this);
  }

  public void onClick(View view) {
    viewGroup.addView(new Button(this));
  }
}
