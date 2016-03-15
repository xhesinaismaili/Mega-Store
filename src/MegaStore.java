/**
 *
 * @author Xhesina Ismaili
 */
import java.util.Date; 
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList; 
import javax.swing.JOptionPane; 
import java.util.Scanner; 
public class MegaStore {
    
    private static ArrayList<Cashier> cashiers = new ArrayList<Cashier>(); 
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<StoreBasket> baskets = new ArrayList<StoreBasket>(); 
    
    private static Cashier current = new Cashier();
    private static StoreBasket currentBasket = null;
    private static Scanner scanner = new Scanner(System.in);
    private static int globalchoice; 
    
        
     public static int authenticate(String username, String password){
         
        
        for(int i=0; i<cashiers.size(); i++)
        {
        if(username.equals(cashiers.get(i).getCashierUsername()) && password.equals(cashiers.get(i).getCashierPassword())) {
                return i;
            } 
        
        }
        return -1;
    }
     
    public static void login(){
        int loginResult = 0; 
        Scanner scanner1 = new Scanner(System.in);
        //we need a do while structure because we need to run this code at least once 
        do{
                if(loginResult==-1)
                System.out.println("Wrong username & password combination"); 
                System.out.print("Enter username: ");
                String username = scanner1.next();
                System.out.print("Enter password: ");
                String password = scanner1.next(); 
                current.setCashierUsername(username);
                loginResult = authenticate(username, password);
                
        }
        while (loginResult == -1);
        
        current = cashiers.get(loginResult);
        //System.out.print("Ok");
        
        //current = cashiers.get(loginResult);
        if(current.getUserIndicator().equals("c"))
        CashierMenu();
        
        if(current.getUserIndicator().equals("m"));
        ManagerMenu();
    }
    
    public static void promptManagerMainMenu(){
        System.out.println ("*****************Xhesi's MegaStore*****************");
        System.out.println ("* 1 Overall number of baskets for a cashier       *");
        System.out.println ("* 2 Total amount of baskets by a cashier          *");
        System.out.println ("* 3 Total amount of baskets for today             *");
        System.out.println ("* 4 Switch to cashier                             *");
        System.out.println ("***************************************************");
        System.out.print   ("Enter your choice: ");
    }
    
    public static void promptCashierMainMenu(){
        System.out.println ("*****************Xhesi's MegaStore*****************");
        System.out.println ("* 1 Add new basket                                *");
        System.out.println ("* 2 Print basket information by ID                *");
        System.out.println ("* 3 Switch between users                          *");
        System.out.println ("***************************************************");
        System.out.print   ("Enter your choice: ");
    }
    
    public static void promptCashierMenu(){
        System.out.println ("*****************Xhesi's MegaStore*****************");
        System.out.println ("* 1 Add new item in basket                        *");
        System.out.println ("* 2 Remove item from basket                       *");
        System.out.println ("* 3 Print information of basket                   *");
        System.out.println ("* 4 Apply discount to basket                      *");
        System.out.println ("* 5 Exit                                          *");
        System.out.println ("***************************************************");
        System.out.print   ("Enter your choice: ");
    }
    public static void promptSubAddMenu(){
        System.out.println ("*****************Xhesi's MegaStore*****************");
        System.out.println ("* Do you want to add another item?                *");
        System.out.println ("* y for yes, any other value for no               *");
        System.out.println ("***************************************************");
        System.out.print   ("Enter your choice: ");
        
        String subchoice = scanner.next(); 
        if(subchoice.equals("y")){
            addItem();
            promptSubAddMenu();
            //baskets.add(basket);
            
        }
        else
            
            CashierSubMenu(); 
    }
    
    public static void promptSubRemoveMenu(){
        System.out.println ("*****************Xhesi's MegaStore*****************");
        System.out.println ("* Do you want to remove another item?             *");
        System.out.println ("* y for yes, any other value for no               *");
        System.out.println ("***************************************************");
        System.out.print   ("Enter your choice: ");
        
        String subchoice = scanner.next(); 
        if(subchoice.equals("y")){
            removeItem();
            promptSubRemoveMenu(); 
        }
        else
            CashierSubMenu(); 
    }
    
    public static void addItem(){
        //int basketId = baskets.size(); 
        //basket.setBasketId(basketId);
       
        System.out.print("ID     Name\n");
        for(int i=0; i<items.size(); i++){
            System.out.println(items.get(i).getItemID()+ "   "+items.get(i).getItemName());
        }
        System.out.print("Choose item to add to basket ");
        int theItem = scanner.nextInt();
        currentBasket.addItem(items.get(theItem-1));
        
    }
    
    public static void removeItem(){
        //StoreBasket basket = new StoreBasket(current.getCashierName());
        if(currentBasket.getItemList().size()>0){
                  
        System.out.print("Number  Name      Price\n");
        for(int i=0; i<currentBasket.getItemList().size(); i++){
        System.out.print((i+1) +"  "+currentBasket.getItemList().get(i).getItemName() +"   "+currentBasket.getItemList().get(i).getItemPrice()+ "\n");
        }
        System.out.print("Choose item to remove from basket ");
        int theItem = scanner.nextInt();
        currentBasket.discardItem(currentBasket.getItemList().get(theItem-1));
        promptSubRemoveMenu();
        //baskets.remove(currentBasket);
       
    }
        else
            System.out.print("No items found in this list\n");
            CashierSubMenu();
        }

    
    public static void CashierSubMenu(){
        int choice; 
        //int basketId = baskets.size(); 
        //basket.setBasketId(basketId);
        //baskets.add(basket);
        //ArrayList<StoreBasket> baskets = new ArrayList<StoreBasket>(); 
        //StoreBasket basket = new StoreBasket(current.getCashierName());
        
        
        promptCashierMenu();
        choice= scanner.nextInt(); 
        
    switch(choice){
        case 1: 
    {
        addItem();
        promptSubAddMenu();
        
       
        
        break;        
        
    }
        case 2:
    {
        
        removeItem();
        
        break; 
    }
    
    
        case 3: {
         
        System.out.printf("MegaStore address %s\n", currentBasket.getStoreAddress());
        System.out.printf("Date/Time %s\n",currentBasket.getTimeOfPurchase());
        System.out.printf("Basket ID %d\n",currentBasket.getBasketId());
        System.out.print("List of items in basket: \n");
        System.out.print("Name  Price\n");
        for(int i=0; i<currentBasket.getItemList().size(); i++){
        System.out.print(currentBasket.getItemList().get(i).getItemName() +"   "+currentBasket.getItemList().get(i).getItemPrice()+ "\n");
        //netTotal=netTotal+(currentBasket.getItemList().get(i).getItemPrice());
        }
        System.out.printf("Net amount of items is %.2f\n",currentBasket.getNetAmount());
        //currentBasket.setNetAmount(netTotal);
        //currentBasket.setTotalAmount(netTotal*1.2);
        System.out.printf("Total amount of items is %.2f\n",currentBasket.getTotalAmount());
        System.out.printf("The cashier for this basket: %s\n",current.getCashierUsername());
        CashierSubMenu();
        break; 
        }
        
        case 4: {
            if(currentBasket.getTotalAmount()>0.0){
            System.out.printf("Total basket amount is %.2f\n", currentBasket.getTotalAmount());
            //double discount = currentBasket.getTotalAmount() +(currentBasket.getTotalAmount()*0.1);
            currentBasket.setDiscount();
            System.out.printf("Total amount after applying the discount is %.2f\n",currentBasket.getTotalAmount());
            CashierSubMenu();
            }
            else
            {
                System.out.println("Total amount is currently 0. Discount cannot be applied");
                CashierSubMenu();
            }
        }    
            
        case 5: {
            baskets.add(currentBasket);
            CashierMenu();
            break; 
        }
            
        default: {
            CashierSubMenu();
            break; 
        }
    }
    }
    public static void CashierMenu(){
        
        
        int ch; 
        //int basketId = baskets.size(); 
        
        //StoreBasket basket = new StoreBasket(current.getCashierName());
        promptCashierMainMenu();
        ch=scanner.nextInt();
        //StoreBasket basket = new StoreBasket(current.getCashierName()); 
        
       switch(ch) {
           
      
                case 1: { 
                    StoreBasket basket = new StoreBasket(current.getCashierName());
                    basket.setBasketId(baskets.size());
                    
                    currentBasket = basket;
                    
                    CashierSubMenu();
                    
                    break; 
                         }
    
             
                case 2:{
                   
            
                    System.out.print("Enter basket ID: ");
                    int id = scanner.nextInt(); 
                    int count = 0;
                         
                    for(StoreBasket i: baskets){
                
                   
                    
                    if(id==i.getBasketId()){
                        count = 1;
                    System.out.printf("---------------Xhesi's MegaStore---------------");
                    System.out.println("MegaStore address" + i.getStoreAddress());
                    System.out.println("Basket creation date " + i.getTimeOfPurchase());
                    System.out.println("Basket ID " + i.getBasketId());
                    System.out.println("Basket net amount " + i.getNetAmount());
                    System.out.println("Basket amount " + i.getTotalAmount());
                    System.out.println("Basket cashier operation: " + current.getCashierUsername());
                    for(Item j : i.itemList ){
                    System.out.println("Item name :" + j.getItemName())  ;
                    }
                    System.out.printf("--------------------------------------------------");
                    
                    }

                    }
                    if (count == 0)
                        System.out.print("ID not found. Please enter a valid one\n");
            
                    CashierMenu();
                    break; 
                        
                    }   
            
                case 3:{
                    
                    login();
                    break;
                }
        
                    default:{
                          break;
                    }
             }
        
                             }
    
    public static void ManagerMenu(){
        
                int mChoice; 
                promptManagerMainMenu();
                mChoice=scanner.nextInt();
                
          switch(mChoice){
              case 1: {
                  int NoBaskets = 0;
                  //int count =0;
                  System.out.println("Enter name of cashier to check: ");
                  System.out.print("Names: Jesse, Walter, Vanessa, Jamie. Enter one: ");
                  String UID = scanner.next();
                                      
                      for(int i=0; i<baskets.size(); i++){                          
                         if(UID.equals(baskets.get(i).getCashierName()))
                             NoBaskets++;
                         
                         
                      }
                      if(NoBaskets==0)
                      System.out.print("Username not found. Please enter a valid one.\n");
                      
                      System.out.printf("User %s has %d baskets\n",UID,NoBaskets);
                      ManagerMenu();
                      break; 
              }
              case 2: {
                  double totalAmount = 0;
                  System.out.print("Ente username of cashier to check: ");
                  String UID = scanner.next();
                                       
                      for(int i=0; i<baskets.size(); i++){                          
                         if(UID.equals(baskets.get(i).getCashierName()))
                             totalAmount+= baskets.get(i).getTotalAmount();
                         else
                             System.out.print("Username not found. Please enter a valid one.\n");
                         
                      }
                      
                      System.out.printf("User %s has processed %.2f amount\n",UID,totalAmount);
                      ManagerMenu();
                  break; 
              }
              case 3: {
                  double todayAmount=0;
                     for( int i = 0; i < baskets.size(); i++){        
                           for(int j = 0; j < baskets.get(i).getItemList().size(); j++){
                                    
                               todayAmount+= baskets.get(i).getTotalAmount();
                                        
                                    }
                     }
                          System.out.printf("Total amount of items processed for today is %.2f ", todayAmount );  
                          break; 
              }
              case 4: {
                  login();
                  break; 
              }
              default: {
                  break; 
              }
          }
    }
    
    public static void main(String[] args){
        
         
        
        Cashier cashier1 = new Cashier ("Walter", "White", "walter", "walter123", "c");
        Cashier cashier2 = new Cashier ("Jamie", "Lennister", "jamie", "jamie123", "c"); 
        Cashier cashier3 = new Cashier ("Greg", "Parelli", "greg", "greg123", "c");
        Cashier cashier4 = new Cashier ("Vanessa", "Ives", "vanessa", "vanessa123", "c");
        Cashier cashier5 = new Cashier ("Jesse", "Pinkman", "jesse", "jesse123", "c"); 
        Cashier manager = new Cashier ("Arya", "Stark", "arya", "arya123", "m");
        
        cashiers.add(cashier1);
        cashiers.add(cashier2);
        cashiers.add(cashier3);
        cashiers.add(cashier4);
        cashiers.add(cashier5);
        cashiers.add(manager);
        
        Item item1 = new Item ("Pen",0,20.0); 
        Item item2 = new Item ("Pencil",1,23.0);
        Item item3 = new Item ("Rubber",2,24.5);
        Item item4 = new Item ("Ruler",3,50.0);
        Item item5 = new Item ("Notebook",4,40.5);
        Item item6 = new Item ("Bag",5,80.0);
        
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        //Cashier [] cashiers = {cashier1, cashier2, cashier3, cashier4, cashier5, manager};   
        //Cashier login = new Cashier(); 
        //StoreBasket basket = new StoreBasket ();
       login(); 
       //CashierMenu();
}
}
