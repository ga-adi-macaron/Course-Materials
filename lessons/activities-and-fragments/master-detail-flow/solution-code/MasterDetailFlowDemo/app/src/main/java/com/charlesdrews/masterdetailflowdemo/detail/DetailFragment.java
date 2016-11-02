package com.charlesdrews.masterdetailflowdemo.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;
import com.charlesdrews.masterdetailflowdemo.data.PlanetDbHelper;

import java.util.Locale;

public class DetailFragment extends Fragment {

    public static final String SELECTED_PLANET_ID = "selectedPlanetId";

    private int mSelectedPlanetId;
    private OnFavoriteStatusChangeListener mListener;
    private FloatingActionButton mFavoriteFab;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int selectedPlanetId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(SELECTED_PLANET_ID, selectedPlanetId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSelectedPlanetId = getArguments().getInt(SELECTED_PLANET_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get selected planet from database
        final PlanetDbHelper planetDbHelper = PlanetDbHelper.getInstance(getContext());
        final Planet selectedPlanet = planetDbHelper.getPlanetById(mSelectedPlanetId);

        // Populate views with planet details
        TextView nameView = (TextView) view.findViewById(R.id.planet_detail_name);
        TextView diameterView = (TextView) view.findViewById(R.id.planet_detail_diameter);
        TextView temperatureView = (TextView) view.findViewById(R.id.planet_detail_temperature);
        TextView ringsView = (TextView) view.findViewById(R.id.planet_detail_rings);
        TextView moonsView = (TextView) view.findViewById(R.id.planet_detail_moons);
        mFavoriteFab = (FloatingActionButton) view.findViewById(R.id.planet_detail_favorite_button);

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
                planetDbHelper.updatePlanetFavoriteStatus(mSelectedPlanetId,
                        selectedPlanet.isFavorite());

                // Update the FAB icon accordingly
                setFavoriteFabIcon(selectedPlanet.isFavorite());

                // Call the listener
                mListener.onFavoriteStatusChange(mSelectedPlanetId, selectedPlanet.isFavorite());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFavoriteStatusChangeListener) {
            mListener = (OnFavoriteStatusChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFavoriteStatusChangeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Helper method
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFavoriteStatusChangeListener {
        void onFavoriteStatusChange(int planetId, boolean isFavorite);
    }
}
