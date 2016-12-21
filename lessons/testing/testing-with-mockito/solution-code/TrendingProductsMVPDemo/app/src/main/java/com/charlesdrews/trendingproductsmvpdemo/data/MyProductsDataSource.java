package com.charlesdrews.trendingproductsmvpdemo.data;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.charlesdrews.trendingproductsmvpdemo.data.local.FavoriteProductsDbHelper;
import com.charlesdrews.trendingproductsmvpdemo.data.remote.WalmartApiUtility;

import java.util.List;
import java.util.Locale;

/**
 * Provides the trending and favorite products to the app's presenters.
 * <p>
 * Created by charlie on 11/10/16.
 */

public class MyProductsDataSource implements ProductsDataSource {

    private Handler mCallbackThreadHandler, mNetworkingThreadHandler, mDatabaseThreadHandler;
    private FavoriteProductsDbHelper mDbHelper;

    private static MyProductsDataSource sInstance;

    public static MyProductsDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MyProductsDataSource(context);
        }
        return sInstance;
    }

    private MyProductsDataSource(Context context) {
        // Use the main/UI thread for callbacks
        mCallbackThreadHandler = new Handler(Looper.getMainLooper());

        // Create new threads for networking & database access
        HandlerThread networkingThread = new HandlerThread("NetworkingThread");
        networkingThread.start();
        mNetworkingThreadHandler = new Handler(networkingThread.getLooper());

        HandlerThread databaseThread = new HandlerThread("DatabaseThread");
        databaseThread.start();
        mDatabaseThreadHandler = new Handler(databaseThread.getLooper());

        // Get a reference to the db helper singleton
        mDbHelper = FavoriteProductsDbHelper.getInstance(context);
    }

    @Override
    public void getTrendingProducts(@NonNull final GetProductsCallback callback) {
        logThread("Receiving call to getTrendingProducts()");

        mNetworkingThreadHandler.post(new Runnable() {
            @Override
            public void run() {

                logThread("Making Walmart API call");

                // Get products from API call
                final List<Product> products = WalmartApiUtility.getTrendingProducts();

                // Check if each product has previously been saved as a favorite;
                // if yes, update "isFavorite" to be true.
                for (Product product : products) {
                    product.setFavorite(mDbHelper.isProductInFavorites(product.getId()));
                }

                // Send the products back to the caller - do this back on the original thread!
                mCallbackThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        logThread("Passing products to callback");
                        callback.onProductsLoaded(products);
                    }
                });
            }
        });
    }

    @Override
    public void getFavoriteProducts(@NonNull final GetProductsCallback callback) {
        logThread("Receiving call to getFavoriteProduct()");

        mDatabaseThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                logThread("Getting favorite products from db");
                final List<Product> products = mDbHelper.getFavoriteProducts();

                mCallbackThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        logThread("Sending favorite products to callback");
                        callback.onProductsLoaded(products);
                    }
                });
            }
        });
    }

    @Override
    public void isProductInFavorites(final int productId,
                                     @NonNull final GetFavoriteStatusCallback callback) {

        logThread("Receiving call to isProductInFavorites()");

        mDatabaseThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                logThread("Getting favorite status from db");
                final boolean productIsInFavorites = mDbHelper.isProductInFavorites(productId);

                mCallbackThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        logThread("Sending favorite status to callback");
                        callback.onFavoriteStatusReturned(productIsInFavorites);
                    }
                });
            }
        });
    }

    @Override
    public void addProductToFavorites(final Product product) {
        mDatabaseThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                mDbHelper.addProductToDb(product);
            }
        });
    }

    @Override
    public void removeProductFromFavorites(final int productId) {
        mDatabaseThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                mDbHelper.removeProductFromDb(productId);
            }
        });
    }

    private void logThread(String message) {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();

        Log.d("MyyProductsDataSource", String.format(Locale.getDefault(), "%s: on thread %d %s",
                message, id, name));
    }
}
