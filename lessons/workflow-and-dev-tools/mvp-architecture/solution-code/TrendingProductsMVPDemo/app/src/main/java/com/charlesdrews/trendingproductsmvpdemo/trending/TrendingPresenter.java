package com.charlesdrews.trendingproductsmvpdemo.trending;

import android.support.annotation.NonNull;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;

import java.util.List;

/**
 * Presents data to the fragment that implements TrendingContract.View
 * <p>
 * Created by charlie on 11/10/16.
 */

class TrendingPresenter implements TrendingContract.Presenter {

    private static final int NUM_CHARS_OF_PROD_NAME_FOR_MSG = 20;

    private TrendingContract.View mView;
    private ProductsDataSource mDataSource;
    private boolean mViewIsReady = false;
    private List<Product> mProducts;


    TrendingPresenter(TrendingContract.View view, ProductsDataSource dataSource) {
        mView = view;
        mDataSource = dataSource;

        // Get trending products asynchronously w/ callback
        mDataSource.getTrendingProducts(new ProductsDataSource.GetProductsCallback() {
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
    public void onFavoriteStatusUpdateNeeded() {
        for (final Product product : mProducts) {
            mDataSource.isProductInFavorites(product.getId(),
                    new ProductsDataSource.GetFavoriteStatusCallback() {
                        @Override
                        public void onFavoriteStatusReturned(boolean productIsInFavorites) {
                            product.setFavorite(productIsInFavorites);

                            // If this is the last product, then also refresh the view
                            if (mProducts.indexOf(product) == mProducts.size() - 1) {
                                mView.displayProducts(mProducts);
                            }
                        }
                    });
        }
    }

    @Override
    public void onRefreshRequested() {
        mDataSource.getTrendingProducts(new ProductsDataSource.GetProductsCallback() {
            @Override
            public void onProductsLoaded(List<Product> products) {
                mProducts = products;
                mView.displayProducts(mProducts);
            }
        });
    }

    @Override
    public void onProductFavoriteIconClicked(@NonNull final Product product) {
        mDataSource.isProductInFavorites(product.getId(), new ProductsDataSource.GetFavoriteStatusCallback() {
            @Override
            public void onFavoriteStatusReturned(boolean productIsInFavorites) {

                String message;
                if (product.getName().length() > NUM_CHARS_OF_PROD_NAME_FOR_MSG) {
                    message = product.getName()
                            .substring(0, NUM_CHARS_OF_PROD_NAME_FOR_MSG - 3) + "...";
                } else {
                    message = product.getName();
                }

                if (productIsInFavorites) {
                    // Product is currently in favorites, so remove it
                    mDataSource.removeProductFromFavorites(product.getId());
                    mView.showNonFavoriteIconForProduct(product.getId());
                    message = "Removed from favorites: " + message;
                } else {
                    // Product is NOT currently in favorites, so add it
                    mDataSource.addProductToFavorites(product);
                    mView.showFavoriteIconForProduct(product.getId());
                    message = "Added to favorites: " + message;
                }

                mView.notifyUserOfFavoriteStatusChange(message, product);
            }
        });
    }

    @Override
    public void onMenuFavoritesIconCLicked() {
        mView.launchFavoritesView();
    }

    @Override
    public void onViewReady() {
        mViewIsReady = true;

        if (mProducts != null) {
            mView.displayProducts(mProducts);
        }
    }
}
