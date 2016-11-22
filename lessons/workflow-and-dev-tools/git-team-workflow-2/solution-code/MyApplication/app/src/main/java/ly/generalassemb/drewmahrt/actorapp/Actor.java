package ly.generalassemb.drewmahrt.actorapp;

/**
 * Created by drewmahrt on 2/29/16.
 */
public class Actor {
    private String mName;
    private String mDob;
    private int mNumOscars;

    public Actor(String name, String dob, int numOscars) {
        mName = name;
        mDob = dob;
        mNumOscars = numOscars;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDob() {
        return mDob;
    }

    public void setDob(String mDob) {
        this.mDob = mDob;
    }

    public int getNumOscars() {
        return mNumOscars;
    }

    public void setNumOscars(int mNumOscars) {
        this.mNumOscars = mNumOscars;
    }
}
