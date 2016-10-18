package ly.generalassemb.drewmahrt.recyclerviewindependent;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by drewmahrt on 10/17/16.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public FrameLayout mFrameLayout;
    public Button mGreenButton;
    public Button mRedButton;

    public CustomViewHolder(View itemView) {
        super(itemView);

        mFrameLayout = (FrameLayout)itemView.findViewById(R.id.frame_layout);
        mGreenButton = (Button) itemView.findViewById(R.id.green_button);
        mRedButton = (Button) itemView.findViewById(R.id.red_button);
    }
}
