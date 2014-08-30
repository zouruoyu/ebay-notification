package model;

/**
 * Created with IntelliJ IDEA.
 * User: ruoyu
 * Date: 8/29/14
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    private String id;
    private String title;
    private String link;
    private double price;
    private double shipping;

    public Item(String id, String title, String link, double price, double shipping) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.price = price;
        this.shipping = shipping;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n"
             + "title: " + this.title + "\n"
             + "link: " +  this.link + "\n"
             + "price: " + this.price + "\n"
             + "shipping: " +  this.shipping + "\n";
    }
}
