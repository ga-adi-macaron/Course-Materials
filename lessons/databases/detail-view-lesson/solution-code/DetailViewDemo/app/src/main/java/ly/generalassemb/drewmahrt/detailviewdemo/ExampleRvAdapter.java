package ly.generalassemb.drewmahrt.detailviewdemo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by charlie on 10/25/16.
 */

public class ExampleRvAdapter extends RecyclerView.Adapter<ExampleRvAdapter.ExampleRvViewHolder> {

    private List<ExampleObject> mExampleObjects;

    public ExampleRvAdapter(List<ExampleObject> exampleObjects) {
        mExampleObjects = exampleObjects;
    }

    @Override
    public ExampleRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ExampleRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExampleRvViewHolder holder, int position) {
        // Get the relevant value(s) from the object at index `position`
        final int id = mExampleObjects.get(position).getId();
        String name = mExampleObjects.get(position).getName();

        holder.mNameTextView.setText(name);

        //TODO - add an OnClickListener that launches a detail view activity - DONE!
        holder.mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.mNameTextView.getContext(), DetailActivity.class);

                // Pass the object's id via the intent!!!
                intent.putExtra(DetailActivity.ITEM_DESCRIPTION_KEY, id);

                holder.mNameTextView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleObjects.size();
    }

    /**
     * Created by charlie on 10/25/16.
     */
    public static class ExampleRvViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTextView;

        private ExampleRvViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
