package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
  private static final String TAG = "MainActivity";
  public static final Uri CONTENT_URI = ProductsContract.Products.CONTENT_URI;

  private static final int PRODUCTS_LOADER = 0;

  private ProductRecyclerViewAdapter mAdapter;

  private EditText mInputName;
  private EditText mInputQuantity;

  private ContentResolver mContentResolver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAdapter = new ProductRecyclerViewAdapter(new ArrayList<Product>());
    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.product_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    recyclerView.setAdapter(mAdapter);

    Button add = (Button) findViewById(R.id.add_button);

    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        addProduct();
      }
    });

    mInputName = (EditText) findViewById(R.id.input_name);
    mInputQuantity = (EditText) findViewById(R.id.input_quantity);

    mContentResolver = getContentResolver();

    getSupportLoaderManager().initLoader(PRODUCTS_LOADER,null,this);
  }

  public void addProduct () {
    ContentValues values = new ContentValues();
    values.put(ProductsContract.Products.COLUMN_PRODUCTNAME,mInputName.getText().toString());
    values.put(ProductsContract.Products.COLUMN_QUANTITY,mInputQuantity.getText().toString());
    mContentResolver.insert(CONTENT_URI,values);
  }

  @Override
  public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    switch (id){
      case PRODUCTS_LOADER:
        return new CursorLoader(
                this,
                CONTENT_URI,
                new String[]{ProductsContract.Products._ID,
                        ProductsContract.Products.COLUMN_PRODUCTNAME,
                        ProductsContract.Products.COLUMN_QUANTITY},
                null,
                null,
                null
        );
      default:
        return null;
    }
  }

  @Override
  public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    mAdapter.swapData(data);
  }

  @Override
  public void onLoaderReset(Loader<Cursor> loader) {
    mAdapter.swapData(null);
  }
}
