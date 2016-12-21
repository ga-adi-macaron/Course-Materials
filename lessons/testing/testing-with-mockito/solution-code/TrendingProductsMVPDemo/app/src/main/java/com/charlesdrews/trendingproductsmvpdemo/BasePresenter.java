package com.charlesdrews.trendingproductsmvpdemo;

/**
 * The presenter interfaces for each view will extend this interface which defines the basic
 * functionality all presenters will share.
 * <p>
 * Created by charlie on 11/10/16.
 */

public interface BasePresenter {

    /**
     * Call this method to notify the presenter that the view is setup and ready to display data
     * to the user. This should be called from the `onResume()` lifecycle method of the view.
     */
    void onViewReady();

    /*
    Often you'll see `bindView()` and `unbindView()` methods in presenter interfaces. These are
    necessary if your presenter will live somewhere outside an activity or fragment, such as in
    a singleton presenter cache. In that situation, you wouldn't want to keep a reference to a view
    after the view is no longer on the screen, because that would prevent the view (which would be
    an activity or fragment) from being garbage collected, thus creating a memory leak.

    To prevent a memory leak, you would "unbind" the view in the presenter by setting the view
    reference to null. You'd call this `unbindView()` method from the view's `onPause()`
    lifecycle method. When the view is created or re-created, you'd then "bind" the view to the
    presenter by calling `bindView()` and passing to the presenter a reference to the view.

    In this demo app, the presenter will only life inside a fragment, and will not live anywhere
    outside a fragment or activity. Therefore, when the fragment "dies" (i.e. there are no more
    references to it and it can be garbage collected) then so will the presenter and you won't have
    any memory leaks.
     */
}
