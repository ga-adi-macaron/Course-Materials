package com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Access individual views within each list item's layout
 * <p>
 * Created by charlie on 11/10/16.
 */

public abstract class BaseProductViewHolder extends RecyclerView.ViewHolder {

    private OnProductIconClickedListener mListener;
    private ImageView mThumbnail, mFavoriteIcon;
    private TextView mName, mBrand, mPrice;

    public BaseProductViewHolder(View itemView, OnProductIconClickedListener listener) {
        super(itemView);

        mListener = listener;

        mThumbnail = (ImageView) itemView.findViewById(R.id.product_thumbnail);
        mFavoriteIcon = (ImageView) itemView.findViewById(R.id.product_favorite_icon);
        mName = (TextView) itemView.findViewById(R.id.product_name);
        mBrand = (TextView) itemView.findViewById(R.id.product_brand);
        mPrice = (TextView) itemView.findViewById(R.id.product_price);
    }

    public void bindDataToViews(final Product product) {
        // Load the thumbnail asynchronously
        Picasso.with(mThumbnail.getContext())
                .load(product.getThumbnailImageUrl())
                .into(mThumbnail);


        // Update TextViews
        mName.setText(product.getName());
        mBrand.setText(product.getBrand());

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        mPrice.setText(format.format(product.getPrice()));

        // Set up the favorite icon
        setUpIcon(product, mFavoriteIcon);

        // Add OnClickListener to icon
        mFavoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onProductIconClicked(product);
            }
        });
    }

    /**
     * This method must set the drawable for the icon, as well as its click listener.
     */
    protected abstract void setUpIcon(@NonNull Product product, @NonNull ImageView icon);

    public interface OnProductIconClickedListener {
        void onProductIconClicked(Product product);
    }
}
