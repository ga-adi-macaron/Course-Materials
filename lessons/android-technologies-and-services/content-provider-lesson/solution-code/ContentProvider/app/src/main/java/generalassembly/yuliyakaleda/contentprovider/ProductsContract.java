package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ProductsContract {
    public static final String AUTHORITY = "generalassembly.yuliyakaleda.contentprovider.ProductsContentProvider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final class Products implements BaseColumns{
        public static final String TABLE_PRODUCTS = "products";
        public static final String COLUMN_PRODUCTNAME = "productname";
        public static final String COLUMN_QUANTITY = "quantity";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,"products");

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/vnd.generassembly.yuliyakaleda.products";

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/vnd.generassembly.yuliyakaleda.products";
    }

}
