package com.charlesdrews.trendingproductsmvpdemo.favorites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.trendingproductsmvpdemo.R;
import com.charlesdrews.trendingproductsmvpdemo.data.Product;
import com.charlesdrews.trendingproductsmvpdemo.favorites.recyclerview.FavoriteProductsRvAdapter;
import com.charlesdrews.trendingproductsmvpdemo.trending.recyclerview.BaseProductViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment implements FavoritesContract.View,
        BaseProductViewHolder.OnProductIconClickedListener {

    //------------------------------------------------------------------------------------------
    // Member variables
    //------------------------------------------------------------------------------------------
    private FavoritesContract.Presenter mPresenter;
    private List<Product> mProducts;
    private RecyclerView.Adapter mAdapter;

    //------------------------------------------------------------------------------------------
    // Fragment factory methods
    //------------------------------------------------------------------------------------------
    public FavoritesFragment() {
    }

    public static FavoritesFragment newInstance() {
        FavoritesFragment fragment = new FavoritesFragment();
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
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(
                R.id.favorite_products_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mAdapter = new FavoriteProductsRvAdapter(mProducts, this);
        recyclerView.setAdapter(mAdapter);

        // Notify the presenter that the view is set up
        mPresenter.onViewReady();
    }

    //------------------------------------------------------------------------------------------
    // FavoritesContract.View methods
    //------------------------------------------------------------------------------------------
    @Override
    public void displayProducts(@NonNull List<Product> products) {
        //TODO - implement this method - replace the contents of mProducts w/ products & notify mAdapter
    }

    @Override
    public void removeProductFromList(int productId) {
        //TODO - implement this method - look thru mProducts to find the one with the matching productId,
        //TODO - then remove it and notify mAdapter (try not to call notifyDataSetChanged() since only one item changed)
    }

    @Override
    public void notifyUserProductWasRemoved(@NonNull String message, @NonNull final Product product) {
        //TODO - implement this method - show the given message in a SnackBar and use setAction()
        //TODO - to provide an UNDO action for the user
    }

    @Override
    public void setPresenter(FavoritesContract.Presenter presenter) {
        //TODO - implement this method - simply save a reference to the given presenter in the appropriate member variable
    }

    //------------------------------------------------------------------------------------------
    // BaseProductViewHolder.OnProductIconClickedListener methods
    //------------------------------------------------------------------------------------------
    @Override
    public void onProductIconClicked(Product product) {
        mPresenter.onProductUnFavoriteIconClicked(product);
    }
}
