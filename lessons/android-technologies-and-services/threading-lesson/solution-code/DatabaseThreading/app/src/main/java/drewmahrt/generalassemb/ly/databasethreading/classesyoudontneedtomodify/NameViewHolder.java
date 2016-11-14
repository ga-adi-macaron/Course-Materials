package drewmahrt.generalassemb.ly.databasethreading.classesyoudontneedtomodify;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alanjcaceres on 8/2/16.
 */
public class NameViewHolder extends RecyclerView.ViewHolder {

    /**
     * DO NOT MODIFY THIS CLASS
     *
     * Your threading will be done in MainActivity for this app, not here
     */

    private TextView mName;

    public NameViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public void setName(String name) {
        mName.setText(name);
    }
}
