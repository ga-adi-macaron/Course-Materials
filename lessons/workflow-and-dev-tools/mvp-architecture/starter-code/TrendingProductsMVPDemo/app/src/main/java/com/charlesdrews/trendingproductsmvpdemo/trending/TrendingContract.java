package com.charlesdrews.trendingproductsmvpdemo.trending;

import android.support.annotation.NonNull;

import com.charlesdrews.trendingproductsmvpdemo.BasePresenter;
import com.charlesdrews.trendingproductsmvpdemo.BaseView;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;

import java.util.List;

/**
 * Defines the responsibilities of the View and Presenter for the Trending Products feature
 * <p>
 * Note that because no access modifier is specified, this is "package private" and only visible
 * to classes in this folder.
 * <p>
 * Created by charlie on 11/10/16.
 */

interface TrendingContract {

    /**
     * The TrendingContract.View interface will be implemented by TrendingFragment.
     */
    interface View extends BaseView<Presenter> {

        /**
         * The view must be able to receive a list of Products from the presenter and display them.
         *
         * @param products is the list of products to display to the user.
         */
        void displayProducts(@NonNull List<Product> products);

        /**
         * The presenter needs to tell the view when it should show a "favorite" icon for a
         * specified product.
         *
         * @param productId is the ID value of the specified product.
         */
        void showFavoriteIconForProduct(int productId);

        /**
         * The presenter needs to tell the view when it should show a "non-favorite" icon for a
         * specified product.
         *
         * @param productId is the ID value of the specified product.
         */
        void showNonFavoriteIconForProduct(int productId);

        /**
         * The view should show a SnackBar with the specified message and the option to UNDO the
         * action for the specified product.
         *
         * @param message is the text to be displayed in the SnackBar.
         * @param product is the Product whose favorite status was changed.
         */
        void notifyUserOfFavoriteStatusChange(@NonNull String message, @NonNull Product product);

        /**
         * The activity needs to be able to tell the view when the user clicks on the favorites
         * icon in the menu.
         */
        void onFavoritesMenuItemClicked();

        /**
         * The view should launch the favorites screen when this is called.
         */
        void launchFavoritesView();
    }

    /**
     * The TrendingContract.Presenter interface will be implemented by a POJO (plain old java
     * object) class that will be instantiated whenever the corresponding View is created. This
     * POJO can be tested via unit tests, rather than only via Espresso, since it's not dependent
     * on the Android framework.
     */
    interface Presenter extends BasePresenter {

        /**
         * When the user returns from the Favorites screen to the Trending screen, the favorite
         * status of some of the products might have changed, and therefore needs to be updated.
         * Note that this does not require a full refresh of the trending products themselves,
         * just their favorite status.
         */
        void onFavoriteStatusUpdateNeeded();

        /**
         * The user can manually request a data refresh, i.e. by tapping a refresh icon, or by
         * pulling down on a SwipeRefreshLayout, and the view must be able to communicate this
         * request to the presenter.
         */
        void onRefreshRequested();

        /**
         * The user can tap a favorite icon in each list entry to toggle the favorite status of
         * that product. The view needs to communicate that action to the presenter, so the
         * presenter must have this method as a means to receive that communication.
         * <p>
         * The presenter will handle the business logic of checking whether or not the product is
         * currently a favorite, switching it to the opposite value, and persisting that change.
         *
         * @param product is the product on which the user clicked.
         */
        void onProductFavoriteIconClicked(@NonNull Product product);

        /**
         * The user can tap the "favorites" icon in the menu to go to a list of their favorite
         * products. The view needs to communicate this action to the presenter, which should
         * respond by telling the view to launch the favorites activity.
         */
        void onMenuFavoritesIconCLicked();
    }
}
