package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
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

                //TODO: Get the id and current quantity for the position clicked

                //TODO: Increase the quantity

                //TODO: Create new ContentValues, put the updated quantity

                //TODO: Use the Content Resolver to update the quantity

            }
        });

        holder.mDecreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: Get the id and current quantity for the position clicked

                //TODO: decrease the quantity

                //TODO: Create new ContentValues, put the updated quantity

                //TODO: Use the Content Resolver to update the quantity


            }
        });

        holder.mContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //TODO: Get the id of the product clicked on

                //TODO: Use the ContentResolver to delete the product clicked on



                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    /**
     * Take in a cursor, convert it to a list, and fill the recycler view adapter's data with the data from the cursor.
     * If the cursor is null, an empty list will be displayed
     * @param cursor The data to be updated
     */
    public void swapData(Cursor cursor){
        //Empty the existing list
        mProductList.clear();

        //Check if the cursor is null
        if(cursor != null && cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                //Iterate through the cursor. For each item, get the name, quantity, and id to create the list of products
                String name = cursor.getString(cursor.getColumnIndex(ProductsContract.Products.COLUMN_PRODUCTNAME));
                int quantity = cursor.getInt(cursor.getColumnIndex(ProductsContract.Products.COLUMN_QUANTITY));
                long id = cursor.getLong(cursor.getColumnIndex(ProductsContract.Products._ID));
                mProductList.add(new Product(name,quantity,id));
                cursor.moveToNext();
            }
        }

        //Notify the adapter that the data has changed
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
