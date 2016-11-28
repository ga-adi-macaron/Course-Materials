package drewmahrt.generalassemb.ly.contactsexample;

import android.content.ContentUris;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drewmahrt on 11/23/16.
 */

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ContactsViewHolder>{
    private List<Contact> mContactList;

    public ContactsRecyclerViewAdapter(List<Contact> contactList) {
        mContactList = contactList;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ContactsViewHolder(inflater.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(final ContactsViewHolder holder, int position) {
        holder.mNameTextView.setText(mContactList.get(position).getName());

        //TODO: Independent Practice - Delete the contact when you long press the name
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public void swapData(Cursor cursor){
        mContactList.clear();

        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
                long id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID));
                mContactList.add(new Contact(name,id));
                cursor.moveToNext();
            }
        }
        notifyDataSetChanged();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView mNameTextView;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }
}
