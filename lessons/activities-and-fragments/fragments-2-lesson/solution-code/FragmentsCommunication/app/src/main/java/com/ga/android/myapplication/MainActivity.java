package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PlanetListFragment.OnPlanetSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment planetListFragment = PlanetListFragment.newInstance(null, this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, planetListFragment).commit();
    }

    @Override
    public void onPlanetSelected(String selectedPlanet) {
        Bundle bundle = new Bundle();
        bundle.putString("selected_planet", selectedPlanet);
        Fragment detailFragment = DetailFragment.newInstance(bundle);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, detailFragment)
                .commit();

    }
}
