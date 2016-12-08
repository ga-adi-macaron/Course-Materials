package ly.generalassemb.drewmahrt.syncadapterexample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by drewmahrt on 3/2/16.
 */
public class NewsContentProvider extends ContentProvider {

    private NewsDBHelper myDB;
    public static final String AUTHORITY = NewsContract.AUTHORITY;
    private static final String ARTICLES_TABLE = NewsContract.Articles.TABLE_ARTICLES;
    public static final Uri CONTENT_URI = NewsContract.Articles.CONTENT_URI;

    public static final int ARTICLES = 1;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, ARTICLES_TABLE, ARTICLES);
    }
    /*
     * Always return true, indicating that the
     * provider loaded correctly.
     */
    @Override
    public boolean onCreate() {
        myDB = new NewsDBHelper(getContext(), null, null, 1);
        return false;
    }
    /*
     * Return no type for MIME type
     */
    @Override
    public String getType(Uri uri) {
        return null;
    }
    /*
     * query() always returns no results
     *
     */
    @Override
    public Cursor query(
            Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        Log.d(TAG, "query: ");

        switch (uriType) {
            case ARTICLES:
                cursor = myDB.getAllArticles();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }
    /*
     * insert() always returns null (no URI)
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case ARTICLES:
                id = myDB.addArticle(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(ARTICLES_TABLE + "/" + id);
    }
    /*
     * delete() always returns "no rows affected" (0)
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = sURIMatcher.match(uri);
        int rowsDeleted = 0;

        switch (uriType) {
            case ARTICLES:
                rowsDeleted = myDB.deleteAllArticles();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }
    /*
     * update() always returns "no rows affected" (0)
     */
    public int update(
            Uri uri,
            ContentValues values,
            String selection,
            String[] selectionArgs) {
        return 0;
    }
}