package generalassembly.yuliyakaleda.joins.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/27/16.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder{
    public TextView mNameTextView;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mNameTextView = (TextView)itemView.findViewById(android.R.id.text1);
    }
}
