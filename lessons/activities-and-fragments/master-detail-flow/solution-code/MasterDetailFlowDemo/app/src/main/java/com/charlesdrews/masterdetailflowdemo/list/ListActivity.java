package com.charlesdrews.masterdetailflowdemo.list;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;
import com.charlesdrews.masterdetailflowdemo.data.PlanetDbHelper;
import com.charlesdrews.masterdetailflowdemo.detail.DetailActivity;
import com.charlesdrews.masterdetailflowdemo.detail.DetailFragment;

import java.util.List;

public class ListActivity extends AppCompatActivity
        implements PlanetRecyclerViewAdapter.OnPlanetSelectedListener,
        DetailFragment.OnFavoriteStatusChangeListener {

    private boolean mTwoPane;
    private PlanetDbHelper mPlanetDbHelper;
    private List<Planet> mPlanets;
    private PlanetRecyclerViewAdapter mPlanetListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Check if two pane or not
        if (findViewById(R.id.detail_fragment_container) != null) {
            mTwoPane = true;
        }
        else {
            mTwoPane = false;
        }

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

        //If two pane, update detail fragment here in this activity
        //Otherwise, if single pane, launch detail activity
        if (mTwoPane) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            DetailFragment detailFragment = DetailFragment.newInstance(planetId);
            fragmentTransaction.replace(R.id.detail_fragment_container, detailFragment);
            fragmentTransaction.commit();
        }
        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailFragment.SELECTED_PLANET_ID, planetId);
            startActivity(intent);
        }
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

    @Override
    public void onFavoriteStatusChange(int planetId, boolean isFavorite) {
        for (int i = 0; i < mPlanets.size(); i++) {
            if (mPlanets.get(i).getId() == planetId) {
                mPlanets.get(i).setFavorite(isFavorite);
                mPlanetListAdapter.notifyItemChanged(i);
                break;
            }
        }
    }
}
