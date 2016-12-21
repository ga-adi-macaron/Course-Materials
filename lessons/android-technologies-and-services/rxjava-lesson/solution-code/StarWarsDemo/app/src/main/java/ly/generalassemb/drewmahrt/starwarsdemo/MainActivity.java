package ly.generalassemb.drewmahrt.starwarsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    StarWarsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new StarWarsAdapter(new ArrayList<SWCharacter>());
        mRecyclerView.setAdapter(mAdapter);

        Button clearButton = (Button) findViewById(R.id.button_clear);
        Button fetchButton = (Button) findViewById(R.id.button_fetch);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAdapter.clear();
            }
        });

        fetchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://swapi.co/api/")
                        .build();

                StarWarsService starWarsService = retrofit.create(StarWarsService.class);

                for(int i=1; i<10; i++) {
                    starWarsService.getCharacterInfo(i)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(character -> mAdapter.addData(character));
                }
            }
        });
    }
}
