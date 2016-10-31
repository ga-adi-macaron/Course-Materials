package ly.generalassemb.drewmahrt.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The music used in this app is provided by www.bensound.com under the creative commons license
        int resID=getResources().getIdentifier("bensound_funnysong", "raw", getPackageName());
        mMediaPlayer = MediaPlayer.create(this,resID);

        Button launchButton = (Button)findViewById(R.id.new_activity_button);
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        Button startMusicButton = (Button)findViewById(R.id.play_button);
        startMusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.start();
            }
        });

        Button pauseMusicButton = (Button)findViewById(R.id.pause_button);
        pauseMusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.pause();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMediaPlayer.pause();
    }
}
