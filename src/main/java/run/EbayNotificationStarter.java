package run;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;
import model.Query;
import model.SearchQuery;
import org.apache.commons.io.IOUtils;
import util.PageParser;
import util.UrlBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;




/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/29/14
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class EbayNotificationStarter {

    public static void main(String[] args) {

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            byte[] jsonData = IOUtils.toByteArray(classloader.getResourceAsStream("configuration.json"));

            ObjectMapper objectMapper = new ObjectMapper();

            SearchQuery searchQuery = objectMapper.readValue(jsonData, SearchQuery.class);

            List<Query> allQueries = searchQuery.getQueries();

            for (Query query : allQueries) {
                String url = UrlBuilder.build(query.getSearchTerm(), query.getLowestPrice(), query.getHighestPrice());
                List<Item> items = PageParser.parse(url);

                System.out.println(items);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
