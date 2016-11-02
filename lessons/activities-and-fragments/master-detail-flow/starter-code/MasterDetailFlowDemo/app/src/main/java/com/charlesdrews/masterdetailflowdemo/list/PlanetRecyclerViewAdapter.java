package com.charlesdrews.masterdetailflowdemo.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.masterdetailflowdemo.R;
import com.charlesdrews.masterdetailflowdemo.data.Planet;

import java.util.List;

/**
 * Created by charlie on 11/1/16.
 */

public class PlanetRecyclerViewAdapter extends RecyclerView.Adapter<PlanetViewHolder> {

    private List<Planet> mPlanets;
    private OnPlanetSelectedListener mOnPlanetSelectedListener;

    public interface OnPlanetSelectedListener {
        void onPlanetSelected(int planetId);
    }

    public PlanetRecyclerViewAdapter(List<Planet> planets,
                                     OnPlanetSelectedListener onPlanetSelectedListener) {
        mPlanets = planets;
        mOnPlanetSelectedListener = onPlanetSelectedListener;
    }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_list_item, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        final Planet currentPlanet = mPlanets.get(position);

        holder.mPlanetNameTextView.setText(currentPlanet.getName());
        holder.mFavoriteIcon.setVisibility(currentPlanet.isFavorite() ? View.VISIBLE : View.GONE);

        holder.mPlanetListItemRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnPlanetSelectedListener.onPlanetSelected(currentPlanet.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlanets.size();
    }
}
