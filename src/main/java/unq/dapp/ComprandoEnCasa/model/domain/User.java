package unq.dapp.ComprandoEnCasa.model.domain;

import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.exceptions.InvalidUsernameOrPasswordException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class User {

    @Column(unique = true)
    private String username;

    private String password;

    @Id
    private String email;
    private String name;
    private String lastName;
    @OneToOne (cascade = {CascadeType.ALL})
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Commerce> commerceList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PurchaseOrder> purchaseHistory;

    private boolean statusNotifications;
    @Transient
    private SecretManager secretManager;

    public User(){
        this.secretManager =  new SecretManager("secreto");
        shoppingCart = new ShoppingCart();
        purchaseHistory = new ArrayList<>();
        statusNotifications = true;
    }

    public User(String username, String password){
        this.secretManager = new SecretManager("secreto");
        if(username.isEmpty() || password.isEmpty()){
            throw new InvalidUsernameOrPasswordException();
        }
        this.username = username;
        this.password = this.secretManager.encrypt(password);
    }

    public User(String username, String password, String email, String name, String lastName){
        this.secretManager =  new SecretManager("secreto");
        this.username = username;
        this.password = this.secretManager.encrypt(password);
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.commerceList = new ArrayList<>();
        this.shoppingCart = new ShoppingCart();
        this.purchaseHistory = new ArrayList<>();
    }

    public String getUsername() { return username; }

    public String getPassword() { return this.secretManager.decrypt(this.password); }

    public String getEmail() { return email; }

    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = this.secretManager.encrypt(password); }

    public void setEmail(String email) { this.email = email; }

    public void setName(String name) { this.name = name; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }

    public void addToCart(Product product) { this.shoppingCart.addItem(product); }

    public void cleanShoppingCart() { this.shoppingCart.emptyCart();}

    public List<PurchaseOrder> getPurchaseHistory() { return purchaseHistory; }

    public void setPurchaseHistory(List<PurchaseOrder> purchaseHistory) { this.purchaseHistory = purchaseHistory; }

    public void addToPurchaseHistory(PurchaseOrder purchaseOrder) { this.purchaseHistory.add(purchaseOrder); }

    public boolean getStatusNotifications() { return statusNotifications; }

    public void setStatusNotifications(boolean statusNotifications) { this.statusNotifications = statusNotifications; }

    public void enableNotifications() { this.setStatusNotifications(true);}

    public void disableNotifications() { this.setStatusNotifications(false);}

    public List<Commerce> getCommerceList() {
        return commerceList;
    }

    public void setCommerceList(List<Commerce> commerceList) {
        this.commerceList = commerceList;
    }

    public void addComerce(Commerce commerce) {
        if(commerceList.contains(commerce)) {
            commerceList.remove(commerce);
        }
        this.commerceList.add(commerce);
    }

    public void removeCommerce(Commerce commerce) {
        commerceList.remove(commerce);
    }
}
