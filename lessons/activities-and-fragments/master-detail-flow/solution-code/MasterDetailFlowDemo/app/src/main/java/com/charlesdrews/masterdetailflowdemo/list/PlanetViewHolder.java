package com.charlesdrews.masterdetailflowdemo.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.charlesdrews.masterdetailflowdemo.R;

/**
 * Created by charlie on 11/1/16.
 */

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    View mPlanetListItemRootView;
    TextView mPlanetNameTextView;
    ImageView mFavoriteIcon;

    public PlanetViewHolder(View itemView) {
        super(itemView);

        mPlanetListItemRootView = itemView;
        mPlanetNameTextView = (TextView) itemView.findViewById(R.id.planet_name_text_view);
        mFavoriteIcon = (ImageView) itemView.findViewById(R.id.planet_favorite_icon);
    }
}
