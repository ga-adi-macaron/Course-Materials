package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drewmahrt on 11/23/16.
 */

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>{
    private static final String TAG = "ProductRecyclerViewAdap";
    private List<Product> mProductList;

    public ProductRecyclerViewAdapter(List<Product> productList){
        mProductList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ProductViewHolder(inflater.inflate(R.layout.product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        holder.mNameTextView.setText(mProductList.get(position).getName());
        holder.mQuantityTextView.setText("("+mProductList.get(position).getQuantity()+")");

        Log.d(TAG, "onBindViewHolder: Name: "+mProductList.get(position).getName()+" ID: "+mProductList.get(position).getId());

        holder.mIncreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = mProductList.get(holder.getAdapterPosition()).getId();
                int quantity = mProductList.get(holder.getAdapterPosition()).getQuantity();
                quantity++;

                ContentValues values = new ContentValues();
                values.put(ProductsContract.Products.COLUMN_QUANTITY,quantity);
                Log.d(TAG, "onClick: Increase quantity: "+quantity+" for ID: "+id);
                Uri uriWithId = ContentUris.withAppendedId(ProductsContract.Products.CONTENT_URI,id);
                int rowsUpdated = view.getContext().getContentResolver().update(uriWithId,
                        values,
                        null,
                        null);
                Log.d(TAG, "onClick: Rows updated: "+rowsUpdated);
            }
        });

        holder.mDecreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = mProductList.get(holder.getAdapterPosition()).getId();
                int quantity = mProductList.get(holder.getAdapterPosition()).getQuantity();
                quantity--;

                ContentValues values = new ContentValues();
                values.put(ProductsContract.Products.COLUMN_QUANTITY,quantity);
                Log.d(TAG, "onClick: Decrease quantity: "+quantity);
                Uri uriWithId = ContentUris.withAppendedId(ProductsContract.Products.CONTENT_URI,id);
                int rowsUpdated = view.getContext().getContentResolver().update(uriWithId,
                        values,
                        null,
                        null);
            }
        });

        holder.mContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                long id = mProductList.get(holder.getAdapterPosition()).getId();
                Uri uriWithId = ContentUris.withAppendedId(ProductsContract.Products.CONTENT_URI,id);
                view.getContext().getContentResolver().delete(uriWithId,
                        null,
                        null);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public void swapData(Cursor cursor){
        mProductList.clear();
        Log.d(TAG, "swapData: Swapping Data");
        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String name = cursor.getString(cursor.getColumnIndex(ProductsContract.Products.COLUMN_PRODUCTNAME));
                int quantity = cursor.getInt(cursor.getColumnIndex(ProductsContract.Products.COLUMN_QUANTITY));
                long id = cursor.getLong(cursor.getColumnIndex(ProductsContract.Products._ID));
                mProductList.add(new Product(name,quantity,id));
                cursor.moveToNext();
            }
        }
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView mNameTextView, mQuantityTextView;
        ImageButton mIncreaseButton, mDecreaseButton;
        RelativeLayout mContainer;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView)itemView.findViewById(R.id.product_name);
            mQuantityTextView = (TextView)itemView.findViewById(R.id.product_quantity);
            mIncreaseButton = (ImageButton)itemView.findViewById(R.id.increase_quantity);
            mDecreaseButton = (ImageButton)itemView.findViewById(R.id.decrease_quantity);
            mContainer = (RelativeLayout)itemView.findViewById(R.id.product_container);
        }
    }
}
