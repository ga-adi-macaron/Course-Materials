package ly.generalassemb.drewmahrt.listviewsandadapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mNameList;
    ArrayAdapter<String> mAdapter;
    BaseAdapter mBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNameList = new LinkedList<>();
        mNameList.add("Adam");
        mNameList.add("Brad");
        mNameList.add("Charlie");
        mNameList.add("David");
        mNameList.add("Frank");


        //Create an ArrayAdapter
        //mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mNameList);
        mBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mNameList.size();
            }

            @Override
            public Object getItem(int position) {
                return mNameList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    v = li.inflate(android.R.layout.simple_list_item_1, null);
                }

                TextView textView = (TextView)v.findViewById(android.R.id.text1);
                textView.setText(mNameList.get(position));

                return v;
            }
        };


        //Get the reference to the ListView and Set the adapter of the ListView
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(mBaseAdapter);

        //In the onClick method, remove the first item from the list if any exist and refresh the updated list on the screen
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNameList.size() >= 1) {
                    mNameList.remove(0);
                    //mAdapter.notifyDataSetChanged();
                    mBaseAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
