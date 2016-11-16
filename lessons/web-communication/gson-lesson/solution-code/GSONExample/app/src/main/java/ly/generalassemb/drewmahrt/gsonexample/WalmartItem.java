package ly.generalassemb.drewmahrt.gsonexample;

/**
 * Created by drewmahrt on 3/1/16.
 */
public class WalmartItem {
    private String name;
    private String shortDescription;

    public String getName(){return name;}

    public String getShortDescription(){return shortDescription;}

    public void setName(String name){this.name = name;}

    public void setShortDescription(String description){this.shortDescription = description;}

    @Override
    public String toString() {
        return name;
    }
}
