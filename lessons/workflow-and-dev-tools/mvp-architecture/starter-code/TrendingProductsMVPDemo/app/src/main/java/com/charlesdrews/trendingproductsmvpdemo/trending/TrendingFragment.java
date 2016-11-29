package com.charlesdrews.trendingproductsmvpdemo.trending;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.favorites.FavoritesActivity;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductRvAdapter;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductViewHolder;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.TrendingProductViewHolder;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.TrendingProductsRvAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrendingFragment extends Fragment implements TrendingContract.View,
        BaseProductViewHolder.OnProductIconClickedListener {

    //------------------------------------------------------------------------------------------
    // Member variables
    //------------------------------------------------------------------------------------------
    private TrendingContract.Presenter mPresenter;
    private List<Product> mProducts;
    private BaseProductRvAdapter<TrendingProductViewHolder> mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean mFirstTimeFragmentIsDisplayed = true;

    //------------------------------------------------------------------------------------------
    // Fragment factory methods
    //------------------------------------------------------------------------------------------
    public TrendingFragment() {
    }

    public static TrendingFragment newInstance() {
        TrendingFragment fragment = new TrendingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    //------------------------------------------------------------------------------------------
    // Fragment lifecycle methods
    //------------------------------------------------------------------------------------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

        // Preserve this instance of the fragment on device orientation changes
        setRetainInstance(true);

        mProducts = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(
                R.id.trending_products_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mAdapter = new TrendingProductsRvAdapter(mProducts, this);
        recyclerView.setAdapter(mAdapter);

        // Set up the SwipeRefreshLayout
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(
                R.id.trending_swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Refreshing products...", Toast.LENGTH_SHORT).show();
                mPresenter.onRefreshRequested();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mFirstTimeFragmentIsDisplayed) {
            mFirstTimeFragmentIsDisplayed = false;
            mPresenter.onViewReady();
            mSwipeRefreshLayout.setRefreshing(true);
        } else {
            mPresenter.onFavoriteStatusUpdateNeeded();
        }
    }

    //------------------------------------------------------------------------------------------
    // TrendingContract.View methods
    //------------------------------------------------------------------------------------------
    @Override
    public void displayProducts(@NonNull List<Product> products) {
        mProducts.clear();
        mProducts.addAll(products);
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showFavoriteIconForProduct(int productId) {
        for (Product product : mProducts) {
            if (product.getId() == productId) {
                product.setFavorite(true);
                mAdapter.notifyItemChanged(mProducts.indexOf(product));
                return;
            }
        }
    }

    @Override
    public void showNonFavoriteIconForProduct(int productId) {
        for (Product product : mProducts) {
            if (product.getId() == productId) {
                product.setFavorite(false);
                mAdapter.notifyItemChanged(mProducts.indexOf(product));
                return;
            }
        }
    }

    @Override
    public void notifyUserOfFavoriteStatusChange(@NonNull String message,
                                                 @NonNull final Product product) {
        View rootView = getActivity().findViewById(R.id.trending_coordinator_layout);
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.onProductFavoriteIconClicked(product);
                    }
                })
                .show();
    }

    @Override
    public void onFavoritesMenuItemClicked() {
        mPresenter.onMenuFavoritesIconCLicked();
    }

    @Override
    public void launchFavoritesView() {
        getActivity().startActivity(new Intent(getContext(), FavoritesActivity.class));
    }

    @Override
    public void setPresenter(TrendingContract.Presenter presenter) {
        mPresenter = presenter;
    }

    //------------------------------------------------------------------------------------------
    // BaseProductViewHolder.OnProductIconClickedListener methods
    //------------------------------------------------------------------------------------------
    @Override
    public void onProductIconClicked(Product product) {
        mPresenter.onProductFavoriteIconClicked(product);
    }
}
