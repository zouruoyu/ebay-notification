package run;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import email.EmailSender;
import model.Configuration;
import model.Item;
import model.Query;
import util.MessageBuilder;
import util.PageParser;
import util.UrlBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/29/14
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class EbayNotificationStarter {
    private static Set<String> lastSentItems = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        if (args.length < 1 ) {
            throw new Exception("Need to pass the configuration file to run");
        }

        String configFile = args[0];

        try {
            byte[] jsonData = Files.toByteArray(new File(configFile));

            ObjectMapper objectMapper = new ObjectMapper();

            Configuration configuration = objectMapper.readValue(jsonData, Configuration.class);

            List<Query> allQueries = configuration.getQueries();

            while (true) {
                for (Query query : allQueries) {
                    String url = UrlBuilder.build(query.getSearchTerm(), query.getLowestPrice(), query.getHighestPrice());
                    List<Item> items = PageParser.parse(url);

                    List<Item> newItems = new ArrayList<Item>();

                    for (Item item : items) {
                        if (!lastSentItems.contains(item.getId())) {
                            newItems.add(item);
                            lastSentItems.add(item.getId());
                        }
                    }
                    if (newItems.size() > 0) {
                        EmailSender.send(configuration.getFrom(), configuration.getPassword(), configuration.getTo(), "ebay: " + query.getSearchTerm(), MessageBuilder.build(newItems));
                    }
                }
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
