package unq.dapp.ComprandoEnCasa.model.domain;

import javax.persistence.*;

@Entity
public class CartElement {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public CartElement() { }

    public CartElement(Product product, Integer quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getTotal() {
        return this.product.getPrice() * this.quantity;
    }

    public void increseQuantity() {
        this.quantity += 1;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

    public boolean isValid() {
        return quantity <= product.getStock();
    }
}
