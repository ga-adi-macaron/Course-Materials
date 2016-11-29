package com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview;

import android.support.annotation.NonNull;
import android.view.View;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;

import java.util.List;

/**
 * This is an implementation of BaseProductRvAdapter for use with the TrendingProductViewHolder class.
 * <p>
 * Created by charlie on 11/28/16.
 */

public class TrendingProductsRvAdapter extends BaseProductRvAdapter<TrendingProductViewHolder> {

    public TrendingProductsRvAdapter(List<Product> products,
                                     BaseProductViewHolder.OnProductIconClickedListener listener) {
        super(products, listener);
    }

    @Override
    protected TrendingProductViewHolder getNewViewHolder(
            @NonNull View itemView,
            @NonNull BaseProductViewHolder.OnProductIconClickedListener listener) {
        return new TrendingProductViewHolder(itemView, listener);
    }
}
