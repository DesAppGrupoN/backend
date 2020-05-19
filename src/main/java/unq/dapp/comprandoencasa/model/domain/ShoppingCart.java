package unq.dapp.comprandoEnCasa.model.domain;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

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
