package generalassembly.yuliyakaleda.independentpracticesolution;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LayoutAnimationActivity extends AppCompatActivity implements View.OnClickListener{
  private ViewGroup viewGroup;
  private Button add;
  private Button delete;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_animation_activity);
    LayoutTransition l = new LayoutTransition();
    l.enableTransitionType(LayoutTransition.CHANGING);
    viewGroup = (ViewGroup) findViewById(R.id.ll);
    viewGroup.setLayoutTransition(l);

    add = (Button) findViewById(R.id.add);
    delete = (Button) findViewById(R.id.delete);
    add.setOnClickListener(this);
    delete.setOnClickListener(this);
  }

  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.add:
        viewGroup.addView(new Button(this));
        break;
      case R.id.delete:
        viewGroup.removeViewAt(0);
        break;
    }
  }
}
