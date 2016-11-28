package drewmahrt.generalassemb.ly.contactsexample;

/**
 * Created by drewmahrt on 11/23/16.
 */

public class Contact {
    String mName;
    long mId;

    public Contact(String name, long id) {
        mName = name;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }
}
