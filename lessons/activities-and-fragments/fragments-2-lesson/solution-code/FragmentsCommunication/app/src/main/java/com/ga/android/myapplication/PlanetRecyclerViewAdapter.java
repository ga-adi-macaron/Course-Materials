package com.ga.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/31/16.
 */

public class PlanetRecyclerViewAdapter extends RecyclerView.Adapter<PlanetRecyclerViewAdapter.PlanetViewHolder> {
    String[] mPlanetArray;
    PlanetListFragment.OnPlanetSelectedListener mListener;

    public PlanetRecyclerViewAdapter(String[] planetArray, PlanetListFragment.OnPlanetSelectedListener listener) {
        mPlanetArray = planetArray;
        mListener = listener;
    }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new PlanetViewHolder(inflater.inflate(R.layout.planet_item,parent,false));
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, final int position) {
        holder.mPlanetTextView.setText(mPlanetArray[position]);

        holder.mPlanetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPlanetSelected(mPlanetArray[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlanetArray.length;
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder{
        TextView mPlanetTextView;
        LinearLayout mPlanetItem;

        public PlanetViewHolder(View itemView) {
            super(itemView);
            mPlanetTextView = (TextView)itemView.findViewById(R.id.planet_text);
            mPlanetItem = (LinearLayout)itemView.findViewById(R.id.planet_item);
        }
    }
}
