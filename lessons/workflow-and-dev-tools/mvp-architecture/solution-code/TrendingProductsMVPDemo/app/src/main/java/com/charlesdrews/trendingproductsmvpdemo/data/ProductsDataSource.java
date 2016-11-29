package com.charlesdrews.trendingproductsmvpdemo.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Defines the responsibilities of a data source for the products this app will display
 * <p>
 * This interface allows implementing classes flexibility in where the data comes from. In this
 * demo app, the trending products will be retrieved from an API call, while the favorite products
 * will be retrieved from a local database. The presenters that utilize the data source shouldn't
 * care, or even be aware, of where the data comes from.
 * <p>
 * Created by charlie on 11/10/16.
 */

public interface ProductsDataSource {

    interface GetProductsCallback {
        void onProductsLoaded(List<Product> products);
    }

    interface GetFavoriteStatusCallback {
        void onFavoriteStatusReturned(boolean productIsInFavorites);
    }

    void getTrendingProducts(@NonNull GetProductsCallback callback);

    void getFavoriteProducts(@NonNull GetProductsCallback callback);

    void isProductInFavorites(int productId, @NonNull GetFavoriteStatusCallback callback);

    void addProductToFavorites(Product product);

    void removeProductFromFavorites(int productId);
}
