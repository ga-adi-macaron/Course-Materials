package ly.generalassemb.drewmahrt.iconlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.iconlist.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ignore these two lines; they load data into the database
        DBAssetHelper dbAssetHelper = new DBAssetHelper(MainActivity.this);
        dbAssetHelper.getReadableDatabase();

        // Get our icons from the database
        List<Icon> icons = IconSQLiteOpenHelper.getInstance(this).getIconList();

        // Set up the RecyclerView
        RecyclerView iconRecyclerView = (RecyclerView) findViewById(R.id.icon_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        iconRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new IconRvAdapter(icons);
        iconRecyclerView.setAdapter(adapter);
    }

}
