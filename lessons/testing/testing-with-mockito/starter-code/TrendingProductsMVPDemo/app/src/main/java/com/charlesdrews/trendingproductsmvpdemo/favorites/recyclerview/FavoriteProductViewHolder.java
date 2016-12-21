package com.charlesdrews.trendingproductsmvpdemo.favorites.recyclerview;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductViewHolder;

/**
 * This is an implementation of BaseProductViewHolder for the Favorite Products view.
 * <p>
 * Created by charlie on 11/28/16.
 */

public class FavoriteProductViewHolder extends BaseProductViewHolder {

    public FavoriteProductViewHolder(View itemView, OnProductIconClickedListener listener) {
        super(itemView, listener);
    }

    @Override
    protected void setUpIcon(@NonNull Product product, @NonNull ImageView icon) {
        icon.setImageResource(R.drawable.ic_clear_black_24dp);

        icon.setColorFilter(ContextCompat.getColor(icon.getContext(),
                R.color.favoriteProductRemoveIconColor));
    }
}
