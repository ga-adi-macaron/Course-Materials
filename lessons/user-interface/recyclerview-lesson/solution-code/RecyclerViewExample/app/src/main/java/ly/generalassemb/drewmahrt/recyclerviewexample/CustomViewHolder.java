package ly.generalassemb.drewmahrt.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/17/16.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public Button mButton1;
    public Button mButton2;

    public CustomViewHolder(View itemView) {
        super(itemView);

        mTextView1 = (TextView) itemView.findViewById(R.id.textview_1);
        mTextView2 = (TextView) itemView.findViewById(R.id.textview_2);
        mTextView3 = (TextView) itemView.findViewById(R.id.textview_3);
        mTextView4 = (TextView) itemView.findViewById(R.id.textview_4);
        mButton1 = (Button) itemView.findViewById(R.id.button_1);
        mButton2 = (Button) itemView.findViewById(R.id.button_2);
    }
}
