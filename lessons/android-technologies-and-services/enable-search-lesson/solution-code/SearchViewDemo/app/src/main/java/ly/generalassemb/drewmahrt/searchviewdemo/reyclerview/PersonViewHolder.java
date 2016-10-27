package ly.generalassemb.drewmahrt.searchviewdemo.reyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/26/16.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder{
    public TextView mNameTextView, mAgeTextView;


    public PersonViewHolder(View itemView) {
        super(itemView);

        mNameTextView = (TextView) itemView.findViewById(android.R.id.text1);
        mAgeTextView = (TextView) itemView.findViewById(android.R.id.text2);
    }
}
