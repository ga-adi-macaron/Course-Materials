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

        /**
         * The view must be able to receive a list of Products from the presenter and display them.
         *
         * @param products is the list of products to display to the user.
         */
        void displayProducts(@NonNull List<Product> products);

        /**
         * The view must be able to remove a product from the displayed list when the presenter
         * notifies it, by calling this method, and passes the ID of the product to remove.
         *
         * @param productId is the ID value of the specified product.
         */
        void removeProductFromList(int productId);

        /**
         * The view should show a SnackBar with the specified message and the option to UNDO the
         * action for the specified product.
         *
         * @param message is the message to be displayed in the SnackBar.
         * @param product is the Product that was removed.
         */
        void notifyUserProductWasRemoved(@NonNull String message, @NonNull Product product);
    }

    /**
     * The FavoritesContract.Presenter interface will be implemented by a POJO (plain old java
     * object) class that will be instantiated whenever the corresponding View is created. This
     * POJO can be tested via unit tests, rather than only via Espresso, since it's not dependent
     * on the Android framework.
     */
    interface Presenter extends BasePresenter {

        /**
         * The user can tap an "X" icon in each list entry to remove that item from the favorites
         * list. The view needs to communicate that action to the presenter, so the presenter must
         * have this method as a means to receive that communication.
         * <p>
         * The presenter will handle the business logic of persisting that change in the database.
         *
         * @param product is the product to be removed.
         */
        void onProductUnFavoriteIconClicked(@NonNull Product product);

        /**
         * The user can click "UNDO" when notified that an item was removed from favorites. The
         * view needs to communicate that action to the presenter, so it can reinstate the item
         * in the database.
         *
         * @param product is the product to be re-added to the database.
         */
        void onProductRemovalReversed(@NonNull Product product);
    }
}
