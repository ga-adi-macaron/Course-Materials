package com.example.g.activitytransitionsdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Request the content transitions feature
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // Set exit and enter transitions
        getWindow().setExitTransition(new Explode());
//        getWindow().setEnterTransition(new Fade());

        // Set shared element transitions as a set
//        TransitionSet transition = new TransitionSet();
//        transition.addTransition(new ChangeTransform());
//
//        getWindow().setSharedElementEnterTransition(transition);
//        getWindow().setSharedElementReturnTransition(transition);

        // Inflate the activity's views and set up the toolbar
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Create the view/transitionName pairs for the shared element transition
                Pair<View, String> pair1 = Pair.create(findViewById(R.id.image1),
                        getString(R.string.image_one_transition_name));

                Pair<View, String> pair2 = Pair.create(findViewById(R.id.image6),
                        getString(R.string.image_two_transition_name));

                Pair<View, String> pair3 = Pair.create(findViewById(R.id.appBar),
                        getString(R.string.app_bar_transition_name));

                // Create the animation options to pass to startActivity()
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
//                        pair1, pair2, pair3);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);

                // Start the new activity
                startActivity(intent, options.toBundle());
            }
        });
    }

}
