package com.charlesdrews.trendingproductsmvpdemo;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * This will serve as a parent class for all activities in this app, and will implement the basic
 * functionality that all the activities will share - i.e. using a fragment manager to load
 * a fragment into a specified container and set its presenter.
 * <p>
 * Created by charlie on 11/10/16.
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * Fragments may already exist when the activity is being setup because fragments can be
     * retained during orientation changes by calling `setRetainInstance(true)` in the fragment.
     * Therefore, before creating a new instance of the fragment, try to get the existing
     * instance, if there is one.
     *
     * @param containerResId is the resource ID of the view being used as the fragment container.
     * @return the fragment that is in the specified container if it exists, else null.
     */
    public Fragment getFragmentByContainerResId(@IdRes int containerResId) {
        return getSupportFragmentManager().findFragmentById(containerResId);
    }

    public void addFragmentToContainer(@NonNull Fragment fragment, @IdRes int containerResId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerResId, fragment)
                .commit();
    }
}
