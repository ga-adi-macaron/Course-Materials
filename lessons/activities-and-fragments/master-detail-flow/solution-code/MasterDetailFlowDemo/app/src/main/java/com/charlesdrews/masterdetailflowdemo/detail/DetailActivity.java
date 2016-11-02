package com.charlesdrews.masterdetailflowdemo.detail;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;
import com.charlesdrews.masterdetailflowdemo.data.PlanetDbHelper;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity
        implements DetailFragment.OnFavoriteStatusChangeListener {

    private FloatingActionButton mFavoriteFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get selected planet ID from the intent
        int selectedPlanetId = getIntent().getIntExtra(DetailFragment.SELECTED_PLANET_ID, -1);
        if (selectedPlanetId == -1) {
            finish();
        }

        // Load an instance of the detail fragment into its container view
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance(selectedPlanetId);
        fragmentTransaction.add(R.id.detail_fragment_container, detailFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFavoriteStatusChange(int planetId, boolean isFavorite) {
        // Nothing to do
    }
}
