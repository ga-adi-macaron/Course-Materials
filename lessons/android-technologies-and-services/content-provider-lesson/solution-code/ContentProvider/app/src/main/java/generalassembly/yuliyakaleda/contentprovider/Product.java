package generalassembly.yuliyakaleda.contentprovider;

/**
 * Created by drewmahrt on 11/23/16.
 */

public class Product {
    String mName;
    int mQuantity;
    long mId;

    public Product(String name, int quantity, long id) {
        mName = name;
        mQuantity = quantity;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }
}
