package unq.dapp.ComprandoEnCasa.model.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Integer id;
    @ElementCollection
    private Map<Product,Integer> cart ;

    public ShoppingCart(){ this.cart=new HashMap<Product, Integer>();}

    public void addItem(Product product, Integer ints){
        this.cart.put(product,ints);
    }

    public void removeItem(Product product) {
        this.cart.remove(product);
    }

    public Boolean isEmpty(){
        return this.cart.isEmpty();
    }

    public Boolean containsItem(Product product) {
        return this.cart.containsKey(product);
   }

    public Integer getValue(Product product) {
        return this.cart.get(product);
   }

    public void emptyCart() { this.cart= new HashMap<Product, Integer>(); }

    public Integer getTotalPrice() {
        int total = 0;
        for(Map.Entry<Product,Integer> entry : this.cart.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            total += product.getPrice() * quantity;
        }
        return total;
    }
}
