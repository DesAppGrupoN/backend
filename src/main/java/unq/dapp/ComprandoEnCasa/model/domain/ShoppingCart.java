package unq.dapp.ComprandoEnCasa.model.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartElement> cart;

    public ShoppingCart() { this.cart = new ArrayList<>(); }

    public void addItem(Product product, Integer quantity) {
        CartElement cartElement = new CartElement(product, quantity);
        this.cart.add(cartElement);
    }

    public void removeItem(Product product) {
        this.cart.removeIf((elem) -> elem.getProduct().getId().equals(product.getId()));
    }

    public List<CartElement> getCart() { return this.cart; }

    public void setShoppingCart(List<CartElement> cart) {
        this.cart = cart;
    }

    public Boolean isEmpty(){
        return this.cart.isEmpty();
    }

    public void emptyCart() { this.cart = new ArrayList<>(); }

    public Integer getTotalPrice() {
        if(!this.cart.isEmpty()) {
            return this.cart.stream()
                    .mapToInt(elem -> (elem.getTotal()))
                    .sum();
        }
        else {
            return 0;
        }
    }
}
