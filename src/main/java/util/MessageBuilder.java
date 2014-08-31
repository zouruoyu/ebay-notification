package util;

import model.Item;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/30/14
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageBuilder {
    public static String build(List<Item> items) {
        StringBuffer sb = new StringBuffer();

        for (Item item : items) {
            sb.append(item);
            sb.append("----------------------------------------\n");
        }
        return sb.toString();
    }
}
