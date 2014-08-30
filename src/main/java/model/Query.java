package model;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/30/14
 * Time: 1:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Query {
    String searchTerm;
    String lowestPrice;
    String highestPrice;

    public String getLowestPrice() {
        return lowestPrice;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public void setSearchTerm(final String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setLowestPrice(final String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public void setHighestPrice(final String highestPrice) {
        this.highestPrice = highestPrice;
    }


}
