package com.charlesdrews.trendingproductsmvpdemo.favorites.recyclerview;

import android.support.annotation.NonNull;
import android.view.View;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductRvAdapter;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductViewHolder;

import java.util.List;

/**
 * This is an implementation of BaseProductRvAdapter for use with the FavoriteProductViewHolder class.
 * <p>
 * Created by charlie on 11/28/16.
 */

public class FavoriteProductsRvAdapter extends BaseProductRvAdapter<FavoriteProductViewHolder> {

    public FavoriteProductsRvAdapter(List<Product> products,
                                     BaseProductViewHolder.OnProductIconClickedListener listener) {
        super(products, listener);
    }

    @Override
    protected FavoriteProductViewHolder getNewViewHolder(
            @NonNull View itemView,
            @NonNull BaseProductViewHolder.OnProductIconClickedListener listener) {

        return new FavoriteProductViewHolder(itemView, listener);
    }
}
