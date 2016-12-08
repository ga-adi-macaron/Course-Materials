package ly.generalassemb.drewmahrt.syncadapterexample;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drewmahrt on 12/5/16.
 */

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>{
    private static final String TAG = "NewsRecyclerViewAdapter";
    private List<String> mArticleTitles;

    public NewsRecyclerViewAdapter(List<String> articleTitles){
        mArticleTitles = articleTitles;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new NewsViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.mTitleText.setText(mArticleTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return mArticleTitles.size();
    }

    public void swapData(Cursor cursor){
        mArticleTitles.clear();

        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                mArticleTitles.add(cursor.getString(cursor.getColumnIndex(NewsContract.Articles.COLUMN_TITLE)));
                cursor.moveToNext();
            }
        }

        notifyDataSetChanged();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView mTitleText;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }
}
