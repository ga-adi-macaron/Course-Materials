package com.example.g.cardviewdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardRecyclerViewAdapter
        extends RecyclerView.Adapter<CardRecyclerViewAdapter.CardViewHolder> {

    private List<String> mItems;

    public CardRecyclerViewAdapter(List<String> items) {
        mItems = items;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.mTitle.setText(mItems.get(position));
        holder.mDetail.setText("more text more text more text more text more text");

        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch a detail activity when an item is clicked - use a shared element transition
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) view.getContext(), holder.mAndroidImage, "androidImage");

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                view.getContext().startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        View mRootView, mAndroidImage;
        TextView mTitle, mDetail;

        public CardViewHolder(View itemView) {
            super(itemView);

            mRootView = itemView;
            mAndroidImage = itemView.findViewById(R.id.item_image);
            mTitle = (TextView) itemView.findViewById(R.id.item_title_text);
            mDetail = (TextView) itemView.findViewById(R.id.item_detail_text);
        }
    }
}
