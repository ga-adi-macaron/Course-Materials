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
        mProducts.clear();
        mProducts.addAll(products);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void removeProductFromList(int productId) {
        for (Product product : mProducts) {
            if (product.getId() == productId) {
                int index = mProducts.indexOf(product);
                mProducts.remove(index);
                mAdapter.notifyItemRemoved(index);
                return;
            }
        }
    }

    @Override
    public void notifyUserProductWasRemoved(@NonNull String message, @NonNull final Product product) {
        View rootView = getActivity().findViewById(R.id.favorites_coordinator_layout);
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.onProductRemovalReversed(product);
                    }
                })
                .show();
    }

    @Override
    public void setPresenter(FavoritesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    //------------------------------------------------------------------------------------------
    // BaseProductViewHolder.OnProductIconClickedListener methods
    //------------------------------------------------------------------------------------------
    @Override
    public void onProductIconClicked(Product product) {
        mPresenter.onProductUnFavoriteIconClicked(product);
    }
}
