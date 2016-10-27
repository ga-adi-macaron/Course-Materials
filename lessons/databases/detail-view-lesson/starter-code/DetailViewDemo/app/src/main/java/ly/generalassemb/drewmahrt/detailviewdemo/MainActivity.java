package ly.generalassemb.drewmahrt.detailviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.detailviewdemo.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        // Get objects from the database
        ExampleSQLiteOpenHelper helper = new ExampleSQLiteOpenHelper(MainActivity.this);
        List<ExampleObject> objects = helper.getExampleList();

        // Set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.example_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new ExampleRvAdapter(objects);
        recyclerView.setAdapter(adapter);
    }
}
