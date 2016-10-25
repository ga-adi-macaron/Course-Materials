package ly.generalassemb.drewmahrt.databaserecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView1, mTextView2;

    public CustomViewHolder(View itemView) {
        super(itemView);

        mTextView1 = (TextView)itemView.findViewById(R.id.name_text_view);
        mTextView2 = (TextView)itemView.findViewById(R.id.description_text_view);
    }
}
