
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Xhesina Ismaili
 */

public class Cashier {
    private String cashierName; 
    private String cashierSurname;
    private String cashierUsername; 
    private String cashierPassword; 
    private String userIndicator; 
    
    
    public Cashier(String name, String surname, String username, String password, String indicator){
        setCashierName(name); 
        setCashierSurname (surname);
        setCashierUsername (username);
        setCashierPassword (password); 
        setUserIndicator (indicator);
     
        
    }
    public Cashier(){
    }

    public String getCashierName() {
        return cashierName;
    }

    public String getCashierSurname() {
        return cashierSurname;
    }

    public String getCashierUsername() {
        return cashierUsername;
    }

    public String getCashierPassword() {
        return cashierPassword;
    }
    
    public String getUserIndicator() {
        return userIndicator; 
    }

    public void setCashierName(String name) {
        cashierName = name;
    }

    public void setCashierSurname(String surname) {
        cashierSurname = surname;
    }

    public void setCashierUsername(String username) {
        cashierUsername = username;
    }

    public void setCashierPassword(String password) {
        cashierPassword = password;
    }
    
    public void setUserIndicator(String indicator){
        userIndicator = indicator; 
    }
    
    public void login(String username, String password){
        if(username.equals(getCashierUsername()) && password.equals(getCashierPassword()))
        System.out.print("Login successful!");
                else
        System.out.print("Login unsuccessful! Please try again!");
    }
}
