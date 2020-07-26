package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;

import java.util.List;

public class ShoppingCartDTO {
    private Integer commerceId;
    private ShoppingCart shoppingCart;

    public ShoppingCartDTO() {
        this.shoppingCart = new ShoppingCart();
    }

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addAllProducts(List<Product> productList) {
        for(Product product : productList) {
            this.shoppingCart.addItem(product);
        }
    }
}
