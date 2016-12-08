package ly.generalassemb.drewmahrt.syncadapterexample.models;

import java.util.ArrayList;

import ly.generalassemb.drewmahrt.syncadapterexample.models.NewsItem;

/**
 * Created by drewmahrt on 3/2/16.
 */
public class SearchResult {
    private ArrayList<NewsItem> results;

    public ArrayList<NewsItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<NewsItem> results) {
        this.results = results;
    }
}
