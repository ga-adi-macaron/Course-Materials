package com.charlesdrews.trendingproductsmvpdemo.data.remote;

import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Utility class to make calls to the Walmart API's "trending product" endpoint
 * <p>
 * Created by charlie on 11/10/16.
 */

public class WalmartApiUtility {
    private static final String API_KEY = "g5p3xscxuhc7v4bgecnckwkp";

    private static final String TRENDING_PRODUCTS_URL =
            "http://api.walmartlabs.com/v1/trends?format=json&apiKey=" + API_KEY;

    /**
     * This method performs a synchronous network call, and therefore should only be called from
     * a background thread, and never from the main/UI thread!
     * @return a list of trending products retrieved from Walmart's API
     */
    public static List<Product> getTrendingProducts() {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(TRENDING_PRODUCTS_URL).build();

        WalmartApiResponse walmartApiResponse = null;

        try {
            // OK to make a synchronous request here; the threading will be handled in the
            // class that implements ProductsDataSource
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            walmartApiResponse = gson.fromJson(response.body().string(), WalmartApiResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Product> products = new ArrayList<>();

        if (walmartApiResponse != null) {
            for (WalmartItem item : walmartApiResponse.getItems()) {
                products.add(new Product(item));
            }
        }

        return products;
    }
}
