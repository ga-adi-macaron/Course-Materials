package com.charlesdrews.dragandswipe.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.dragandswipe.R;
import com.charlesdrews.dragandswipe.interfaces.OnItemMoveOrRemove;
import com.charlesdrews.dragandswipe.model.MyDataModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by charlie on 7/31/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<ListItemViewHolder>
        implements OnItemMoveOrRemove {

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

    // Must implement this method in order to implement the OnItemMoveOrRemove interface we defined
    @Override
    public void onItemMove(int fromPosition, int toPosition) {

        // Move the item from its original spot to the new spot by swapping it with each
        // item in between, one by one
        if (fromPosition < toPosition) { // the item moved DOWN visually (the position # got higher)

            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mDataItems, i, i + 1); // shift it down 1 spot
            }

        } else { // the item moved UP visually (the position # got lower)

            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mDataItems, i, i - 1); // shift it up 1 spot
            }
        }

        // Call one of the "notify" methods so the views are updated
        notifyItemMoved(fromPosition, toPosition);
    }

    // Must implement this method in order to implement the OnItemMoveOrRemove interface we defined
    @Override
    public void onItemRemove(int position) {

        // Remove the item at the specified position from the underlying data collection
        mDataItems.remove(position);

        // Call one of the "notify" methods so the views are updated
        notifyItemRemoved(position);
    }
}
