package ly.generalassemb.drewmahrt.databaserecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    List<CustomObject> mObjectList;

    public CustomRecyclerViewAdapter(List<CustomObject> objectList) {
        mObjectList = objectList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CustomViewHolder(inflater.inflate(R.layout.custom_item,parent,false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mTextView1.setText(mObjectList.get(position).getTitle());
        holder.mTextView2.setText(mObjectList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }
}
