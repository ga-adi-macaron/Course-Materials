package com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;

import java.util.List;

/**
 * Bind products to list item views.
 * <p>
 * Created by charlie on 11/10/16.
 */

public abstract class BaseProductRvAdapter<V extends BaseProductViewHolder>
        extends RecyclerView.Adapter<V> {

    private List<Product> mProducts;
    private BaseProductViewHolder.OnProductIconClickedListener mListener;

    public BaseProductRvAdapter(List<Product> products,
                                BaseProductViewHolder.OnProductIconClickedListener listener) {
        mProducts = products;
        mListener = listener;
    }

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return getNewViewHolder(view, mListener);
    }

    /**
     * This method will need to instantiate the specific ViewHolder type V that is used for the adapter.
     *
     * @param itemView is the inflated view to be passed to the ViewHolder constructor.
     * @param listener is the click listener to be passed to the ViewHolder constructor.
     * @return a new instance of ViewHolder of type V used by this adapter.
     */
    protected abstract V getNewViewHolder(
            @NonNull View itemView,
            @NonNull BaseProductViewHolder.OnProductIconClickedListener listener);

    @Override
    public void onBindViewHolder(V holder, int position) {
        holder.bindDataToViews(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
