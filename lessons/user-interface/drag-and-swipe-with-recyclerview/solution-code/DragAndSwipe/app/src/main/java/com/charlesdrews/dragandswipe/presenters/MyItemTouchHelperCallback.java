package com.charlesdrews.dragandswipe.presenters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.charlesdrews.dragandswipe.interfaces.OnItemMoveOrRemove;

/**
 * Created by charlie on 7/31/16.
 */
public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    // We'll need an instance of a RecyclerViewAdapter which implements the OnItemMoveOrRemove
    // interface we defined.
    private OnItemMoveOrRemove mRecyclerViewAdapter;

    // Constructor
    public MyItemTouchHelperCallback(OnItemMoveOrRemove recyclerViewAdapter) {
        mRecyclerViewAdapter = recyclerViewAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        // specify which directions are a "drag" motion
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        // specify which directions are a "swipe" motion
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        // Since we said above that the adapter passed to the constructor must implement
        // the OnItemMoveOrRemove interface, we know that adapter has an onItemMove() method.
        mRecyclerViewAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        // With this approach, this class doesn't need to know how to handle an item being moved,
        // it just needs to notify the adapter and let the adapter handle it

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        // Since we said above that the adapter passed to the constructor must implement
        // the OnItemMoveOrRemove interface, we know that adapter has an onItemRemove() method.
        mRecyclerViewAdapter.onItemRemove(viewHolder.getAdapterPosition());

        // With this approach, this class doesn't need to know how to handle an item being removed,
        // it just needs to notify the adapter and let the adapter handle it
    }

    // The system will call this method at some point to check if dragging is enabled.
    // If you don't override this method and always return true, dragging won't work.
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    // The system will call this method at some point to check if swiping is enabled.
    // If you don't override this method and always return true, swiping won't work.
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
