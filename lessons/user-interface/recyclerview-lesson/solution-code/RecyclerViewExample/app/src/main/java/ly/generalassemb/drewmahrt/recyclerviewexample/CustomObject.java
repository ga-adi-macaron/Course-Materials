package ly.generalassemb.drewmahrt.recyclerviewexample;

/**
 * Created by drewmahrt on 10/17/16.
 */

public class CustomObject {

    private String mText1;
    private String mText2;
    private String mText3;
    private String mText4;

    public CustomObject(){
        mText1 = "Text 1";
        mText2 = "Text 2";
        mText3 = "Text 3";
        mText4 = "Text 4";
    }

    public CustomObject(String text1, String text2, String text3, String text4) {
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;
        mText4 = text4;
    }

    public String getText1() {
        return mText1;
    }

    public void setText1(String text1) {
        mText1 = text1;
    }

    public String getText2() {
        return mText2;
    }

    public void setText2(String text2) {
        mText2 = text2;
    }

    public String getText3() {
        return mText3;
    }

    public void setText3(String text3) {
        mText3 = text3;
    }

    public String getText4() {
        return mText4;
    }

    public void setText4(String text4) {
        mText4 = text4;
    }
}
