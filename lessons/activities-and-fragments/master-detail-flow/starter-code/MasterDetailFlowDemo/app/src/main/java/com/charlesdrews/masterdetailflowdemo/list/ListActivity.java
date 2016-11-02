package com.charlesdrews.masterdetailflowdemo.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;
import com.charlesdrews.masterdetailflowdemo.data.PlanetDbHelper;
import com.charlesdrews.masterdetailflowdemo.detail.DetailActivity;

import java.util.List;

public class ListActivity extends AppCompatActivity
        implements PlanetRecyclerViewAdapter.OnPlanetSelectedListener {

    private PlanetDbHelper mPlanetDbHelper;
    private List<Planet> mPlanets;
    private PlanetRecyclerViewAdapter mPlanetListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //TODO - check if two pane or not

        // Set up planet recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.planet_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPlanetDbHelper = PlanetDbHelper.getInstance(this);
        mPlanets = mPlanetDbHelper.getAllPlanets();
        mPlanetListAdapter = new PlanetRecyclerViewAdapter(mPlanets, this);
        recyclerView.setAdapter(mPlanetListAdapter);
    }

    @Override
    public void onPlanetSelected(int planetId) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.SELECTED_PLANET_ID, planetId);
        startActivity(intent);

        //TODO - if two pane, update detail fragment here in this activity
        //TODO - otherwise, if single pane, launch detail activity
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Update the recycler view in case any changes in favorite status were made in the
        // detail activity
        mPlanets.clear();
        mPlanets.addAll(mPlanetDbHelper.getAllPlanets());
        mPlanetListAdapter.notifyDataSetChanged();
    }
}
