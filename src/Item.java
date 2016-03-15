/**
 *
 * @author Xhesina Ismaili
 */
public class Item {
    private String itemName; 
    private int itemID; 
    private double itemPrice; 
    
    public Item(String name, int id, double price){
        setItemName(name);
        setItemID (id);
        setItemPrice (price);
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String name) {
        itemName=name;
    }

    public void setItemID(int id) {
        itemID = id +1;
    }

    public void setItemPrice(double price) {
        itemPrice = price;
    }
}
