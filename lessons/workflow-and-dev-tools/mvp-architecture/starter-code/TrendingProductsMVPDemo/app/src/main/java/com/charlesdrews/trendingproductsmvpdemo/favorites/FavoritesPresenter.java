package com.charlesdrews.trendingproductsmvpdemo.favorites;

import android.support.annotation.NonNull;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;

import java.util.List;

/**
 * Presents data to the fragment that implements FavoritesContract.View
 * <p>
 * Created by charlie on 11/28/16.
 */

class FavoritesPresenter {

    private FavoritesContract.View mView;
    private ProductsDataSource mDataSource;
    private boolean mViewIsReady = false;
    private List<Product> mProducts;

    FavoritesPresenter(FavoritesContract.View view, ProductsDataSource dataSource) {
        mView = view;
        mDataSource = dataSource;

        // Get favorite products asynchronously w/ callback
        mDataSource.getFavoriteProducts(new ProductsDataSource.GetProductsCallback() {
            @Override
            public void onProductsLoaded(List<Product> products) {
                mProducts = products;

                if (mViewIsReady) {
                    mView.displayProducts(mProducts);
                }
            }
        });
    }

    //TODO - add and implement the FavoritesContract.Presenter methods
}
