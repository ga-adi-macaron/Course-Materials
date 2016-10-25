package ly.generalassemb.drewmahrt.databaserecyclerviewdemo;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class CustomObject {
    private String mTitle, mDescription;

    public CustomObject(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
