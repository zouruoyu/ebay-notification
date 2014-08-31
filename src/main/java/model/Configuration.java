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
public class Configuration {
    @JsonProperty
    private String from;

    @JsonProperty
    private String to;

    @JsonProperty
    private String password;

    @JsonProperty
    private List<Query> allQueries;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
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

