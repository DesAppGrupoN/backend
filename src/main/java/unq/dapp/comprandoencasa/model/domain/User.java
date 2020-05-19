package unq.dapp.comprandoEnCasa.model.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private ShoppingCart shoppingCart;
    private Map<LocalDate,ShoppingCart> purchaseHistory;
    private boolean statusNotifications;

    public User(){
        shoppingCart=new ShoppingCart();
        purchaseHistory= new HashMap<LocalDate, ShoppingCart>();
    }

    public User(String username, String password, String email, String name, String lastName){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }
    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public void setEmail(String email) { this.email = email; }

    public void setName(String name) { this.name = name; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }

    public void addToCart(Product product, int i) { this.shoppingCart.addItem(product,i); }

    public void cleanShoppingCart() { this.shoppingCart.emptyCart();}

    public void buyShoppingCart(ShoppingCart shoppingCart) { this.purchaseHistory.put(LocalDate.now(),shoppingCart);}

    public Map<LocalDate, ShoppingCart> getPurchaseHistory() { return purchaseHistory; }

    public void setPurchaseHistory(Map<LocalDate, ShoppingCart> purchaseHistory) { this.purchaseHistory = purchaseHistory; }

    public boolean getStatusNotifications() { return statusNotifications; }

    public void setStatusNotifications(boolean statusNotifications) { this.statusNotifications = statusNotifications; }

    public void enableNotifications() { this.setStatusNotifications(true);}

    public void disableNotifications() { this.setStatusNotifications(false);}
}
