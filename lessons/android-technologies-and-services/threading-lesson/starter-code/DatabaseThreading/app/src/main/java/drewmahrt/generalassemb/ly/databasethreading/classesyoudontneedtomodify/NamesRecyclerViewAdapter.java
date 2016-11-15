package drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alanjcaceres on 8/2/16.
 */
public class NamesRecyclerViewAdapter extends RecyclerView.Adapter<NameViewHolder> {

    /**
     * DO NOT MODIFY THIS CLASS
     *
     * Your threading will be done in MainActivity for this app, not here
     */

    private List<String> mNames;

    public NamesRecyclerViewAdapter(@NonNull List<String> names) {
        mNames = names;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new NameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {
        holder.setName(mNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public void updateNames(List<String> names) {
        mNames = names;
        notifyDataSetChanged();
    }
}
