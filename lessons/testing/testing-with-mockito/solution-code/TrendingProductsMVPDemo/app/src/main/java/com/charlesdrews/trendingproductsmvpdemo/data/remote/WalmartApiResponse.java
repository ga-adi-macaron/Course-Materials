package com.charlesdrews.trendingproductsmvpdemo.data.remote;

/**
 * Describes the JSON data returned by the Walmart API. Because this will be used with GSON, the
 * member variable names must EXACTLY match the keys used in the JSON returned by the API.
 * <p>
 * Created by charlie on 11/10/16.
 */

public class WalmartApiResponse {
    private WalmartItem[] items;

    public WalmartApiResponse() {
    }

    public WalmartItem[] getItems() {
        return items;
    }

    public void setItems(WalmartItem[] items) {
        this.items = items;
    }
}
