package ly.generalassemb.drewmahrt.recyclerviewexample;

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

        holder.mTextView1.setText(mCustomObjectsList.get(position).getText1());
        holder.mTextView2.setText(mCustomObjectsList.get(position).getText2());
        holder.mTextView3.setText(mCustomObjectsList.get(position).getText3());
        holder.mTextView4.setText(mCustomObjectsList.get(position).getText4());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button_1:
                        Toast.makeText(view.getContext(), "You clicked button 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button_2:
                        Toast.makeText(view.getContext(), "You clicked button 2", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(view.getContext(), "You clicked row " + position, Toast.LENGTH_SHORT).show();
                }
            }
        };

        holder.mButton1.setOnClickListener(onClickListener);
        holder.mButton2.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return mCustomObjectsList.size();
    }
}
