package com.example.g.cardviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up transition animation
        TransitionSet transition = new TransitionSet();
        transition.addTransition(new ChangeTransform());
        getWindow().setSharedElementEnterTransition(transition);
        getWindow().setSharedElementReturnTransition(transition);

        // Inflate views and set up toolbar
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create some items to put in the RecyclerView
        List<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");

        // Set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CardRecyclerViewAdapter(items));
    }
}