package com.charlesdrews.trendingproductsmvpdemo.data.remote;

/**
 * Describes each item returned by the Walmart API. Because this will be used with GSON, the
 * member variable names must EXACTLY match the keys used in the JSON returned by the API.
 * <p>
 * Created by charlie on 11/10/16.
 */

public class WalmartItem {
    private int itemId;
    private String name, brandName, shortDescription, thumbnailImage, largeImage, productUrl;
    private float salePrice, customerRating;

    public WalmartItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(float customerRating) {
        this.customerRating = customerRating;
    }
}
