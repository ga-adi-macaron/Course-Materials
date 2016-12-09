package ly.generalassemb.drewmahrt.firebaseexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drewmahrt on 12/6/16.
 */

public class TextRecyclerViewAdapter extends RecyclerView.Adapter<TextRecyclerViewAdapter.TextViewHolder>{
    List<String> mList;

    public TextRecyclerViewAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TextViewHolder(inflater.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class TextViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }
}
