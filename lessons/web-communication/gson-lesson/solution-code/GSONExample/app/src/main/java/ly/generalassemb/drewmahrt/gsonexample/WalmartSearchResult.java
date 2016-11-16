package ly.generalassemb.drewmahrt.gsonexample;

import java.util.ArrayList;

/**
 * Created by drewmahrt on 3/1/16.
 */
public class WalmartSearchResult {
    private ArrayList<WalmartItem> items;

    public void setItems(ArrayList<WalmartItem> items){this.items = items;}

    public ArrayList<WalmartItem> getItems(){return items;}

    @Override
    public String toString() {
        return items.size()+" item(s) in the search result";
    }
}
