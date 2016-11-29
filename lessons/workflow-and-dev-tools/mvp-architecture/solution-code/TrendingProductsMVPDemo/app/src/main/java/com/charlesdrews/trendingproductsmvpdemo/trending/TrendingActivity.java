package com.charlesdrews.trendingproductsmvpdemo.trending;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.charlesdrews.trendingproductsmvpdemo.BaseActivity;
import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.MyProductsDataSource;
import com.charlesdrews.trendingproductsmvpdemo.data.ProductsDataSource;

public class TrendingActivity extends BaseActivity {

    private TrendingContract.View mTrendingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.title_activity_trending));
        }

        // Get trending fragment if it exists, otherwise create a new instance
        Fragment trendingFragment = getFragmentByContainerResId(R.id.trending_fragment_container);
        if (trendingFragment == null) {
            trendingFragment = TrendingFragment.newInstance();

            // Set up the new Fragment instance as a TrendingContract.View
            mTrendingView = (TrendingContract.View) trendingFragment;
            ProductsDataSource dataSource = MyProductsDataSource.getInstance(this);
            TrendingContract.Presenter presenter = new TrendingPresenter(mTrendingView, dataSource);
            mTrendingView.setPresenter(presenter);
        }

        // Add fragment to view
        addFragmentToContainer(trendingFragment, R.id.trending_fragment_container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trending, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorites:
                mTrendingView.onFavoritesMenuItemClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
