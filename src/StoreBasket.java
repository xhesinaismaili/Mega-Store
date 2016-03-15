
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Xhesina Ismaili
 */
public class StoreBasket {
    private  boolean discount = false;
    private int basketId=0; 
    private double netAmount; 
    private double totalAmount; 
    private static final double  VAT= 0.2 ;
    ArrayList<Item> itemList = new ArrayList<Item> (); 
    //private Date timeOfPurchase; 
    private String storeAddress="Via Zara"; 
    private String cashierName; 
    
    public StoreBasket(int id, double net, double total, ArrayList<Item> items,  String address
            , String name){
        setBasketId(id);
        setNetAmount(net);
        setTotalAmount(total);
        setItemList(items);
       // setTimeOfPurchase(date);
        setStoreAddress(address);
        setCashierName(name);
        
    }
   public StoreBasket(String name) {
       setCashierName(name);
       
   }
   public StoreBasket(){
    
    }
   
    //Item[] itemList = new Item[6]; 

    public void setBasketId(int id) {
        basketId = id+1;
    }

    public void setNetAmount(double net) {
        netAmount = netAmount + net;
        setTotalAmount(netAmount);
    }

    public void setTotalAmount(double total) {
        
        totalAmount = total * 1.2;
        if (discount)
            totalAmount = totalAmount - totalAmount * 0.1;
           
    }

    public void setDiscount() {
        this.discount = true;
        setNetAmount(0.0);
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setItemList(ArrayList<Item> items) {
        itemList = items;
    }

    /*public void setTimeOfPurchase(Date date) {
        timeOfPurchase = date;
    }*/

    public void setStoreAddress(String address) {
        storeAddress = address;
    }

    public void setCashierName(String name) {
        cashierName = name;
    }
    public void addItem(Item i){
        this.setNetAmount(i.getItemPrice());
        itemList.add(i);
    }
    
    public void discardItem (Item i){
        setNetAmount(-i.getItemPrice());
        itemList.remove(i);
        
    }

    public int getBasketId() {
        return basketId;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public static double getVAT() {
        return VAT;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public Date getTimeOfPurchase() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date=new Date(); 
        //System.out.println(df.format(date));
        return date;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getCashierName() {
        return cashierName;
    } 
}
