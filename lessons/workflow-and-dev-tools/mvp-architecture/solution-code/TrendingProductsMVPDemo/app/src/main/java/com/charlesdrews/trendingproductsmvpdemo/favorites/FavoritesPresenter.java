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

class FavoritesPresenter implements FavoritesContract.Presenter {

    private static final int NUM_CHARS_OF_PROD_NAME_FOR_MSG = 20;

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

    @Override
    public void onProductUnFavoriteIconClicked(@NonNull Product product) {
        // The data source performs the removal asynchronously, but there is no callback
        // because it doesn't return anything.
        mDataSource.removeProductFromFavorites(product.getId());

        // Update view
        mView.removeProductFromList(product.getId());

        String message = "Removed from favorites: ";
        if (product.getName().length() > NUM_CHARS_OF_PROD_NAME_FOR_MSG) {
            message = message + product.getName()
                    .substring(0, NUM_CHARS_OF_PROD_NAME_FOR_MSG - 3) + "...";
        } else {
            message = message + product.getName();
        }

        mView.notifyUserProductWasRemoved(message, product);
    }

    @Override
    public void onProductRemovalReversed(@NonNull Product product) {
        mDataSource.addProductToFavorites(product);

        mDataSource.getFavoriteProducts(new ProductsDataSource.GetProductsCallback() {
            @Override
            public void onProductsLoaded(List<Product> products) {
                mProducts = products;
                mView.displayProducts(mProducts);
            }
        });
    }

    @Override
    public void onViewReady() {
        mViewIsReady = true;

        if (mProducts != null) {
            mView.displayProducts(mProducts);
        }
    }
}
