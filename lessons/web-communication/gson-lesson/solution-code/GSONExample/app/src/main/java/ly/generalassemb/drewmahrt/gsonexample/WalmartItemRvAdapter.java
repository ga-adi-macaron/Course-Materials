package ly.generalassemb.drewmahrt.gsonexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by charlie on 11/17/16.
 */

public class WalmartItemRvAdapter extends RecyclerView.Adapter<WalmartItemViewHolder> {

    private List<WalmartItem> mItems;

    public WalmartItemRvAdapter(List<WalmartItem> items) {
        mItems = items;
    }

    @Override
    public WalmartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new WalmartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WalmartItemViewHolder holder, int position) {
        holder.mTextView.setText(mItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
