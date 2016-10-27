package ly.generalassemb.drewmahrt.iconlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by charlie on 10/27/16.
 */

public class IconRvAdapter extends RecyclerView.Adapter<IconRvViewHolder> {

    private List<Icon> mIcons;

    public IconRvAdapter(List<Icon> icons) {
        mIcons = icons;
    }

    @Override
    public IconRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.icon_list_item, parent, false);
        return new IconRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IconRvViewHolder holder, int position) {
        Icon currentIcon = mIcons.get(position);

        holder.mIconImageView.setImageResource(getDrawableValue(currentIcon.getName()));

        //TODO - show only the icon in MainActivity; show the name only in the detail activity
        holder.mIconNameTextView.setText(currentIcon.getName());

        //TODO - add an OnClickListener that will launch the detail activity
    }

    @Override
    public int getItemCount() {
        return mIcons.size();
    }

    // Helper method to get the right image resource ID for each icon
    private int getDrawableValue(String iconName){
        switch(iconName){
            case "search":
                return android.R.drawable.ic_menu_search;
            case "add":
                return android.R.drawable.ic_menu_add;
            case "upload":
                return android.R.drawable.ic_menu_upload;
            case "play":
                return android.R.drawable.ic_media_play;
            default:
                return 0;
        }
    }
}
