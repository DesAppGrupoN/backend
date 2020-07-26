package unq.dapp.ComprandoEnCasa.model.domain;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartElement> cart;

    public ShoppingCart() { this.cart = new ArrayList<>(); }

    public void addItem(Product product) {
        Optional<CartElement> cartElement = this.findCartElement(product);

        if(cartElement.isPresent()) {
            cartElement.get().increseQuantity();
        }
        else {
            CartElement newCartElement = new CartElement(product, 1);
            this.cart.add(newCartElement);
        }
    }

    public void removeItem(Product product) {
        Iterator<CartElement> i = this.cart.iterator();
        while(i.hasNext()) {
            CartElement element = i.next();
            if(element.getProduct().getId() == product.getId()) {
                this.cart.remove(element);
                break;
            }
        }
    }

    public Optional<CartElement> findCartElement(Product product) {
        return this.cart.stream()
                .filter(cartElement -> cartElement.getProduct().getId().equals(product.getId()))
                .findFirst();
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

    public void changeQuantity(Product product, Integer quantity) {
        Optional<CartElement> cartElement = this.findCartElement(product);

        if(cartElement.isPresent()) {
            cartElement.get().setQuantity(quantity);
        }
    }

    public List<Integer> getCommercesId() {
        return new ArrayList<>(
                new HashSet<>(
                        this.cart.stream()
                                .map(CartElement::getProduct)
                                .map(Product::getCommerceId)
                                .collect(Collectors.toList())
                )
        );
    }
}
