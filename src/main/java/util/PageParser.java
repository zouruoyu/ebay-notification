package util;

import com.google.common.base.Strings;
import model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/30/14
 * Time: 1:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageParser {


    public static List<Item> parse(String url) {
        List<Item> items = new ArrayList<Item>();
        try {
            Document doc = Jsoup.connect(url).get();

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
                items.add(item);
            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return items;
    }
}
