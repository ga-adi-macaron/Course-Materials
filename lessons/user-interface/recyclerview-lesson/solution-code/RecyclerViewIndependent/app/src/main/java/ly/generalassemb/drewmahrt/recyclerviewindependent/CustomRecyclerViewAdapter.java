package ly.generalassemb.drewmahrt.recyclerviewindependent;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by drewmahrt on 10/17/16.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    List<CustomObject> mCustomObjectsList;

    public CustomRecyclerViewAdapter(final List<CustomObject> customObjectList){
        mCustomObjectsList = customObjectList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomObject object = mCustomObjectsList.get(position);
                switch (view.getId()){
                    case R.id.green_button:
                        object.setColor(Color.GREEN);
                        notifyItemChanged(position);
                        break;
                    case R.id.red_button:
                        object.setColor(Color.RED);
                        notifyItemChanged(position);
                        break;
                    default:
                        Toast.makeText(view.getContext(), "You clicked row " + position, Toast.LENGTH_SHORT).show();
                }
            }
        };

        holder.mFrameLayout.setBackgroundColor(mCustomObjectsList.get(position).getColor());

        holder.mRedButton.setOnClickListener(onClickListener);
        holder.mGreenButton.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return mCustomObjectsList.size();
    }
}
