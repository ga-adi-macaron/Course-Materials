package com.charlesdrews.masterdetailflowdemo.data;

/**
 * This is a plain old Java object (POJO) designed to represent a Planet in our solar system.
 *
 * Created by charlie on 11/1/16.
 */
public class Planet {

    private int mId;
    private String mName;
    private int mDiameterInKm, mAvgTempInC, mNumMoons;
    private boolean mHasRings, mIsFavorite;

    public Planet(int id, String name, int diameterInKm, int avgTempInC, int numMoons,
                  boolean hasRings, boolean isFavorite) {
        mId = id;
        mName = name;
        mDiameterInKm = diameterInKm;
        mAvgTempInC = avgTempInC;
        mNumMoons = numMoons;
        mHasRings = hasRings;
        mIsFavorite = isFavorite;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getDiameterInKm() {
        return mDiameterInKm;
    }

    public int getAvgTempInC() {
        return mAvgTempInC;
    }

    public int getNumMoons() {
        return mNumMoons;
    }

    public boolean hasRings() {
        return mHasRings;
    }

    public boolean isFavorite() {
        return mIsFavorite;
    }

    public void setFavorite(boolean favorite) {
        mIsFavorite = favorite;
    }
}
