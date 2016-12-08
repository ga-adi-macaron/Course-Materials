package ly.generalassemb.drewmahrt.syncadapterexample;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by drewmahrt on 12/5/16.
 */

public class NewsContract {
    public static final String AUTHORITY = "ly.generalassemb.drewmahrt.syncadapterexample.NewsContentProvider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final class Articles implements BaseColumns {
        public static final String TABLE_ARTICLES = "articles";
        public static final String COLUMN_TITLE = "title";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,TABLE_ARTICLES);

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/ly.generalassemb.drewmahrt.articles";

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/ly.generalassemb.drewmahrt.articles";
    }
}
