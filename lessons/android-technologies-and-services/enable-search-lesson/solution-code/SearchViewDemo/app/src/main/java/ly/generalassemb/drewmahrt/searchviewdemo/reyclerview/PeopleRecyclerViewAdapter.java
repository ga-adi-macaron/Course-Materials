package ly.generalassemb.drewmahrt.searchviewdemo.reyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ly.generalassemb.drewmahrt.searchviewdemo.Person;

/**
 * Created by drewmahrt on 10/26/16.
 */

public class PeopleRecyclerViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private static final String TAG = "PeopleRecyclerViewAdapt";

    List<Person> mPeopleList;

    public PeopleRecyclerViewAdapter(List<Person> peopleList){
        mPeopleList = peopleList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.mNameTextView.setText(mPeopleList.get(position).getName());
        holder.mAgeTextView.setText("Age: "+mPeopleList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    public void replaceData(List<Person> newList){
        mPeopleList = newList;
        notifyDataSetChanged();
    }
}
