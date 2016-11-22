package ly.generalassemb.drewmahrt.actorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Leonardo DiCaprio", "November 11, 1974", 1));
        actors.add(new Actor("Matt Damon", "October 8, 1970", 1));
        actors.add(new Actor("Jennifer Lawrence", "August 15, 1990", 1));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.actor_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ActorRecyclerViewAdapter(actors));
    }
}
