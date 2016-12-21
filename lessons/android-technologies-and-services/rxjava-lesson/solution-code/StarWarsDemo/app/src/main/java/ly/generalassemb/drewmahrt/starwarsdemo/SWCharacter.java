package ly.generalassemb.drewmahrt.starwarsdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by drewmahrt on 12/15/16.
 */

public class SWCharacter {
    public String name;
    public int height;

    @SerializedName("birth_year")
    @Expose
    private String birthYear;

    public SWCharacter(String name, int height, String birthYear) {
        this.name = name;
        this.height = height;
        this.birthYear = birthYear;
    }

    public SWCharacter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birth_year) {
        this.birthYear = birth_year;
    }
}
