package com.charlesdrews.masterdetailflowdemo.detail;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;
import com.charlesdrews.masterdetailflowdemo.data.PlanetDbHelper;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    //TODO - move the logic for retrieving and displaying a planet to the new detail fragment
    //TODO - and here in this activity, just display the fragment

    public static final String SELECTED_PLANET_ID = "selectedPlanetId";

    private FloatingActionButton mFavoriteFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get selected planet ID from the intent
        final int selectedPlanetId = getIntent().getIntExtra(SELECTED_PLANET_ID, -1);
        if (selectedPlanetId == -1) {
            finish();
        }

        // Get selected planet from database
        final PlanetDbHelper planetDbHelper = PlanetDbHelper.getInstance(this);
        final Planet selectedPlanet = planetDbHelper.getPlanetById(selectedPlanetId);

        // Populate views with planet details
        TextView nameView = (TextView) findViewById(R.id.planet_detail_name);
        TextView diameterView = (TextView) findViewById(R.id.planet_detail_diameter);
        TextView temperatureView = (TextView) findViewById(R.id.planet_detail_temperature);
        TextView ringsView = (TextView) findViewById(R.id.planet_detail_rings);
        TextView moonsView = (TextView) findViewById(R.id.planet_detail_moons);
        mFavoriteFab = (FloatingActionButton) findViewById(R.id.planet_detail_favorite_button);

        nameView.setText(selectedPlanet.getName());
        diameterView.setText(String.format(Locale.getDefault(), "Diameter: %,d km",
                selectedPlanet.getDiameterInKm()));
        temperatureView.setText(String.format(Locale.getDefault(), "Average temperature: %d°C",
                selectedPlanet.getAvgTempInC()));
        ringsView.setText(selectedPlanet.hasRings() ? "Has rings" : "Does not have rings");
        moonsView.setText(String.format(Locale.getDefault(), "Number of moons: %d",
                selectedPlanet.getNumMoons()));
        setFavoriteFabIcon(selectedPlanet.isFavorite());


        // Update the favorite status when the user clicks the FAB
        mFavoriteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle the favorite status
                selectedPlanet.setFavorite(!selectedPlanet.isFavorite());

                // Update the database to reflect this change
                planetDbHelper.updatePlanetFavoriteStatus(selectedPlanetId, selectedPlanet.isFavorite());

                // Update the FAB icon accordingly
                setFavoriteFabIcon(selectedPlanet.isFavorite());
            }
        });
    }

    private void setFavoriteFabIcon(boolean isFavorite) {
        // Fill in FAB with full star if favorite, else just outline of star if not favorite.
        // The final color of the icon is controlled by the tint attribute in XML.
        if (isFavorite) {
            mFavoriteFab.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else {
            mFavoriteFab.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
    }
}
