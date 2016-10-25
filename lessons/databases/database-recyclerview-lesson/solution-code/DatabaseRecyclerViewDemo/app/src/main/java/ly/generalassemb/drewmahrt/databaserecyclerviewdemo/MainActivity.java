package ly.generalassemb.drewmahrt.databaserecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.databaserecyclerviewdemo.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        ExampleSQLiteOpenHelper helper = ExampleSQLiteOpenHelper.getInstance(this);
        List<CustomObject> objectList = helper.getAllRowsAsList();

        for (CustomObject object:objectList) {
            System.out.println(object.getTitle()+": "+object.getDescription());
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new CustomRecyclerViewAdapter(objectList));
    }
}
