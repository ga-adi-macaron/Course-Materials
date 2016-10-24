package ly.generalassemb.drewmahrt.cursorlab;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;

        db = openOrCreateDatabase(
                "BooksData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] titles = new String[]{"Harry Potter and the Sorcerers Stone","The Martian", "War And Peace", "Curious George", "The Cat In The Hat"};
        String[] authors = new String[]{"J. K. Rowling","Andy Weir", "Lev Nikolayevich Tolstoy", "Margaret Rey", "Theodor Seuss Geisel"};
        int[] years = new int[]{1997,2011,1869,1941,1957};
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_books (title VARCHAR, author VARCHAR, year VARCHAR);");
        for (int i=0; i<titles.length;i++) {
            db.execSQL("INSERT INTO tbl_books Values ('" + titles[i] + "', '"+ authors[i] + "', '" + years[i] +"');");
        }

        //Start your code here

    }
}
