package util;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/30/14
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class UrlBuilder {
    private static final String baseUrl = "http://www.ebay.com/sch/i.html?_ipg=50&LH_BIN=1&_sacat=0&_mPrRngCbx=1&_udlo=50&_udhi=200&_nkw=durametric&_sop=10";

    public static String build(String searchTerm, String lowestPrice, String highestPrice) {
        return baseUrl + "&_udlo=" + lowestPrice + "&_udhi=" + highestPrice + "&_nkw=" + searchTerm;
    }
}
