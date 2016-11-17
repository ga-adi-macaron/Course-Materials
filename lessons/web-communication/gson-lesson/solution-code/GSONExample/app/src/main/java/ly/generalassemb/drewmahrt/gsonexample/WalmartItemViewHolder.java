package ly.generalassemb.drewmahrt.gsonexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by charlie on 11/17/16.
 */

public class WalmartItemViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public WalmartItemViewHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
