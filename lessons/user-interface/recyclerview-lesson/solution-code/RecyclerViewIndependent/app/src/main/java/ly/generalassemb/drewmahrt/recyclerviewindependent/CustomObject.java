package ly.generalassemb.drewmahrt.recyclerviewindependent;

import android.graphics.Color;

/**
 * Created by drewmahrt on 10/17/16.
 */

public class CustomObject {

    private int mColor;

    public CustomObject(){
        mColor = Color.GREEN;
    }


    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }
}
