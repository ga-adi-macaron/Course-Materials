package ly.generalassemb.drewmahrt.detailviewdemo;

/**
 * Created by charlie on 10/25/16.
 */

public class ExampleObject {
    private int mId;
    private String mName, mDescription;

    public ExampleObject(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
