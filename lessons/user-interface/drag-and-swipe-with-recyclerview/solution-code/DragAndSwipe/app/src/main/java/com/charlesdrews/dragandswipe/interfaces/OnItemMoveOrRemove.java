package com.charlesdrews.dragandswipe.interfaces;

/**
 * Created by charlie on 7/31/16.
 */
public interface OnItemMoveOrRemove {

    void onItemMove(int fromPosition, int toPosition);

    void onItemRemove(int position);
}
