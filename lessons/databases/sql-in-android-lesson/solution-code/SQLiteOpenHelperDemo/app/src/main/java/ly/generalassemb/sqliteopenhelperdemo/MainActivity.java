package ly.generalassemb.sqliteopenhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mGameNameEditText, mGameYearEditText;
    Button mAddGameButton, mDeleteGameButton, mGetGameButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameNameEditText = (EditText) findViewById(R.id.edit_text_name);
        mGameYearEditText = (EditText) findViewById(R.id.edit_text_year);

        mAddGameButton = (Button) findViewById(R.id.button_add_game);
        mDeleteGameButton = (Button) findViewById(R.id.button_delete_game);
        mGetGameButton = (Button) findViewById(R.id.button_game_count);

        mTextView = (TextView) findViewById(R.id.text_game_count);

        mAddGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gameName = mGameNameEditText.getText().toString();
                int gameYear = Integer.parseInt(mGameYearEditText.getText().toString());

                DatabaseHelper.getInstance(MainActivity.this).addFavorite(gameName,gameYear);

                Toast.makeText(MainActivity.this, "Game Added", Toast.LENGTH_SHORT).show();
            }
        });

        mDeleteGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gameName = mGameNameEditText.getText().toString();

                int count = DatabaseHelper.getInstance(MainActivity.this).deleteGameByName(gameName);
                if(count == 0){
                    mTextView.setText("Game not found");
                }else{
                    mTextView.setText(gameName+" deleted successfully");
                }

            }
        });

        mGetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gameName = mGameNameEditText.getText().toString();
                int gameCount = DatabaseHelper.getInstance(MainActivity.this).getGameCount(gameName);
                mTextView.setText("Game count for "+gameName+": "+gameCount);
            }
        });
    }
}
