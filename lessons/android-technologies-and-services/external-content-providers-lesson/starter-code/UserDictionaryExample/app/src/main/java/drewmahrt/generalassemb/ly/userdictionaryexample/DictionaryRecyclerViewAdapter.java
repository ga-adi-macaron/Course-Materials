package drewmahrt.generalassemb.ly.userdictionaryexample;

import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drewmahrt on 11/22/16.
 */

public class DictionaryRecyclerViewAdapter extends RecyclerView.Adapter<DictionaryRecyclerViewAdapter.DictionaryViewHolder>{
    private List<String> mWords;

    public DictionaryRecyclerViewAdapter(List<String> words) {
        mWords = words;
    }

    @Override
    public DictionaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new DictionaryViewHolder(inflater.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(DictionaryViewHolder holder, int position) {
        holder.mTextView.setText(mWords.get(position));
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public void swapData(Cursor cursor){
        mWords.clear();

        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                mWords.add(cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD)));
                cursor.moveToNext();
            }
        }
    }

    public class DictionaryViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;


        public DictionaryViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }
}
