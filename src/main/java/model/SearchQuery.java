package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/30/14
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchQuery {
    @JsonProperty
    private List<Query> allQueries;

    public SearchQuery() {
    }

    public List<Query> getQueries() {
        return allQueries;
    }

    public void setAllQueries() {
        this.allQueries = allQueries;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Query query : allQueries) {
            sb.append(query.getSearchTerm() + ", ").append(query.getLowestPrice() + ", ").append(query.getHighestPrice() + "\n");
        }
        return sb.toString();
    }
}

