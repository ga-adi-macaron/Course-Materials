package ly.generalassemb.drewmahrt.iconlist;

/**
 * Created by charlie on 10/27/16.
 */

public class Icon {
    private int mId;
    private String mName;

    public Icon(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}