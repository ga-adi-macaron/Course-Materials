package com.charlesdrews.trendingproductsmvpdemo.data;

import com.charlesdrews.trendingproductsmvpdemo.data.remote.WalmartItem;

/**
 * Models a product, based on the product data returned by Walmart's API.
 * <p>
 * Created by charlie on 11/10/16.
 */

public class Product {
    private int mId;
    private String mName, mBrand, mThumbnailImageUrl;
    private float mPrice;
    private boolean mIsFavorite;

    public Product(int id, String name, String brand, String thumbnailImageUrl, float price,
                   boolean isFavorite) {
        mId = id;
        mName = name;
        mBrand = brand;
        mThumbnailImageUrl = thumbnailImageUrl;
        mPrice = price;
        mIsFavorite = isFavorite;
    }

    public Product(WalmartItem walmartItem) {
        mId = walmartItem.getItemId();
        mName = walmartItem.getName();
        mBrand = walmartItem.getBrandName();
        mThumbnailImageUrl = walmartItem.getThumbnailImage();
        mPrice = walmartItem.getSalePrice();
        mIsFavorite = false;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getBrand() {
        return mBrand;
    }

    public String getThumbnailImageUrl() {
        return mThumbnailImageUrl;
    }

    public float getPrice() {
        return mPrice;
    }

    public boolean isFavorite() {
        return mIsFavorite;
    }

    public void setFavorite(boolean favorite) {
        mIsFavorite = favorite;
    }
}
