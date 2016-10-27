package ly.generalassemb.drewmahrt.iconlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by charlie on 10/27/16.
 */

public class IconRvViewHolder extends RecyclerView.ViewHolder {

    ImageView mIconImageView;
    TextView mIconNameTextView;

    public IconRvViewHolder(View itemView) {
        super(itemView);

        mIconImageView = (ImageView) itemView.findViewById(R.id.icon_image_view);
        mIconNameTextView = (TextView) itemView.findViewById(R.id.icon_name_text_view);
    }
}
