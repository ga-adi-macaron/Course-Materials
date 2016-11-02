package com.charlesdrews.dragandswipe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.charlesdrews.dragandswipe.model.MyDataModel;
import com.charlesdrews.dragandswipe.presenters.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NUMBER_OF_LIST_ITEMS = 15;

    private List<MyDataModel> mListItems;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListItems = new ArrayList<>(NUMBER_OF_LIST_ITEMS);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetListItems();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mListItems.addAll(generateListItems(NUMBER_OF_LIST_ITEMS));
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAdapter = new MyRecyclerViewAdapter(mListItems);
        mRecyclerView.setAdapter(mAdapter);
    }

    // helper method to empty out the list and recreate it from scratch
    public void resetListItems() {
        mListItems.clear();
        mListItems.addAll(generateListItems(NUMBER_OF_LIST_ITEMS));
        mAdapter.notifyDataSetChanged();
    }

    // helper method to generate objects to populate the list
    public List<MyDataModel> generateListItems(int count) {
        List<MyDataModel> items = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            items.add(new MyDataModel(i));
        }

        return items;
    }
}
