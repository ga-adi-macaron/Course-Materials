package com.charlesdrews.trendingproductsmvpdemo.favorites;

import android.support.annotation.NonNull;

import com.charlesdrews.trendingproductsmvpdemo.BasePresenter;
import com.charlesdrews.trendingproductsmvpdemo.BaseView;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;

import java.util.List;

/**
 * Defines the responsibilities of the View and Presenter for the Favorite Products feature
 * <p>
 * Note that because no access modifier is specified, this is "package private" and only visible
 * to classes in this folder.
 * <p>
 * Created by charlie on 11/10/16.
 */

interface FavoritesContract {

    /**
     * The FavoritesContract.View interface will be implemented by FavoritesFragment.
     */
    interface View extends BaseView<Presenter> {

        //TODO - write this contract

    }

    /**
     * The FavoritesContract.Presenter interface will be implemented by a POJO (plain old java
     * object) class that will be instantiated whenever the corresponding View is created. This
     * POJO can be tested via unit tests, rather than only via Espresso, since it's not dependent
     * on the Android framework.
     */
    interface Presenter extends BasePresenter {

        //TODO - write this contract
    }
}
