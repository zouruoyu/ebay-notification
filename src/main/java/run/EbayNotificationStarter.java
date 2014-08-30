package run;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;


/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/29/14
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class EbayNotificationStarter {

    List<Item> allItems = new ArrayList<Item>();

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.ebay.com/sch/i.html?LH_BIN=1&_from=R40|R40|R40&_sacat=0&_sop=16&_nkw=iphone&_ipg=50&rt=nc").get();

            //A list of Items that each item has every information it needed.
            Elements elements = doc.getElementsByAttribute("listingid");
            for (Element element : elements) {
                String id = element.attr("listingId");
                String title = element.getElementsByTag("a").text();
                String link = element.getElementsByTag("a").attr("href");
                double price = Double.parseDouble(element.getElementsByAttributeValue("class", "g-b").text().substring(1).replaceAll(",", ""));
                double shipping = 0.0;
                String noFreeShipping = element.getElementsByAttributeValue("class", "fee").text();
                if (!Strings.isNullOrEmpty(noFreeShipping)) {
                    shipping = Double.parseDouble(noFreeShipping.substring(2).split(" ")[0].replaceAll(",", ""));
                }
                Item item = new Item(id, title, link, price, shipping);
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
