package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alanjcaceres on 7/18/16.
 */

public class PlanetListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private OnPlanetSelectedListener mListener;

    public interface OnPlanetSelectedListener{
        void onPlanetSelected(String selectedPlanet);
    }

    public static Fragment newInstance(Bundle bundle, OnPlanetSelectedListener listener){
        PlanetListFragment fragment = new PlanetListFragment();
        fragment.setArguments(bundle);
        fragment.mListener = listener;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planet_list, container, false);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        String[] planetArray = getResources().getStringArray(R.array.Planets);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(new PlanetRecyclerViewAdapter(planetArray,mListener));
    }
}
