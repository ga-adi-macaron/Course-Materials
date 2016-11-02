package com.charlesdrews.dragandswipe.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.dragandswipe.R;
import com.charlesdrews.dragandswipe.model.MyDataModel;

import java.util.List;

/**
 * Created by charlie on 7/31/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private List<MyDataModel> mDataItems;

    public MyRecyclerViewAdapter(List<MyDataModel> dataItems) {
        mDataItems = dataItems;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        MyDataModel currentDataItem = mDataItems.get(position);
        holder.bindDataToViews(currentDataItem);
    }

    @Override
    public int getItemCount() {
        return mDataItems.size();
    }
}
