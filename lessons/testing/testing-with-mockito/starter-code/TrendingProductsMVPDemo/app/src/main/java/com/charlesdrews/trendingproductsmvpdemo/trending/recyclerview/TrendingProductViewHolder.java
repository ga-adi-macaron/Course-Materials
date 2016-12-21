package com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;

/**
 * This is an implementation of BaseProductViewHolder for the Trending Products view.
 * <p>
 * Created by charlie on 11/28/16.
 */

public class TrendingProductViewHolder extends BaseProductViewHolder {

    public TrendingProductViewHolder(View itemView, OnProductIconClickedListener listener) {
        super(itemView, listener);
    }

    @Override
    protected void setUpIcon(@NonNull Product product, @NonNull ImageView icon) {
        icon.setImageResource(product.isFavorite() ? R.drawable.ic_star_white_24dp :
                R.drawable.ic_star_border_black_24dp);

        icon.setColorFilter(ContextCompat.getColor(icon.getContext(), R.color.colorAccent));
    }
}
