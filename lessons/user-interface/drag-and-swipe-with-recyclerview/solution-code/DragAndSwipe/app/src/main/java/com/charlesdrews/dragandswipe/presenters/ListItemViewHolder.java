package com.charlesdrews.dragandswipe.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.charlesdrews.dragandswipe.R;
import com.charlesdrews.dragandswipe.model.MyDataModel;

/**
 * Created by charlie on 7/31/16.
 */
public class ListItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImage;
    private TextView mText;

    // Constructor
    public ListItemViewHolder(View itemView) {
        super(itemView);

        mImage = (ImageView) itemView.findViewById(R.id.list_item_image);
        mText = (TextView) itemView.findViewById(R.id.list_item_text);
    }

    // Public method that can be called from the RecyclerViewAdapter in the onBindViewHolder method
    public void bindDataToViews(MyDataModel itemData) {
        mImage.setBackgroundColor(itemData.getRandomColorInt());

        // Plug the item number into the string template from strings.xml, then set it in mText
        String messageTemplate = mText.getContext().getString(R.string.list_item_message_text);
        String message = String.format(messageTemplate, itemData.getItemNumber());
        mText.setText(message);
    }
}
