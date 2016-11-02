package com.charlesdrews.dragandswipe.model;

import android.graphics.Color;

import java.util.Random;

/**
 * This is a silly little class that models an object with 2 properties: a number and a random color
 */
public class MyDataModel {

    // Seed a random number generator with the current time.
    // Make it static so every instance of ListItemViewHolder uses the same generator.
    private static Random sRandom = new Random(System.currentTimeMillis());

    // Regular (non-static) member variables
    private int mItemNumber;
    private int mRandomColorInt;

    // Constructor
    public MyDataModel(int itemNumber) {
        mItemNumber = itemNumber;
        mRandomColorInt = generateRandomColorAsInt();
    }

    // Helper method to get random color
    private int generateRandomColorAsInt() {
        // Use the random number generator to get red/green/blue values.
        // Per the documentation for Color.rgb() the values should be between 0 and 255, inclusive.
        int red = sRandom.nextInt(255);
        int green = sRandom.nextInt(255);
        int blue = sRandom.nextInt(255);
        return Color.rgb(red, green, blue);
    }

    public int getItemNumber() {
        return mItemNumber;
    }

    public int getRandomColorInt() {
        return mRandomColorInt;
    }
}
