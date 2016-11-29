package com.charlesdrews.trendingproductsmvpdemo.favorites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.charlesdrews.trendingproductsmvpdemo.BaseActivity;
import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.MyProductsDataSource;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;

public class FavoritesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.title_activity_favorites));
        }

        // Get trending fragment if it exists, otherwise create a new instance
        Fragment favoritesFragment = getFragmentByContainerResId(R.id.favorites_fragment_container);
        if (favoritesFragment == null) {
            favoritesFragment = FavoritesFragment.newInstance();

            // Set up the new Fragment instance as a TrendingContract.View
            FavoritesContract.View favoritesView = (FavoritesContract.View) favoritesFragment;
            ProductsDataSource dataSource = MyProductsDataSource.getInstance(this);
            FavoritesContract.Presenter presenter = new FavoritesPresenter(favoritesView, dataSource);
            favoritesView.setPresenter(presenter);
        }

        // Add fragment to view
        addFragmentToContainer(favoritesFragment, R.id.favorites_fragment_container);
    }
}
