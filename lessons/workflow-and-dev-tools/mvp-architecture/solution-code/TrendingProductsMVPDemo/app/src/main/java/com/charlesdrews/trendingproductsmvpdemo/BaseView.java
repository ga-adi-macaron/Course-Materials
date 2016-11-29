package com.charlesdrews.trendingproductsmvpdemo;

/**
 * The view interfaces for each screen will extend this interface which defines the basic
 * functionality all views will share.
 * <p>
 * Created by charlie on 11/10/16.
 */

public interface BaseView<P extends BasePresenter> {

    /**
     * If the class implementing the view interface is a fragment, then the host activity would
     * need to be able to pass an instance of the required presenter to that fragment.
     * <p>
     * Since we are using fragments as our views in this app, all our view interfaces will need
     * to include this method.
     *
     * @param presenter is the presenter being passed to the view.
     */
    void setPresenter(P presenter);
}
