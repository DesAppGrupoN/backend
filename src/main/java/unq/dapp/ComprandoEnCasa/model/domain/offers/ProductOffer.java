package unq.dapp.ComprandoEnCasa.model.domain.offers;

import unq.dapp.ComprandoEnCasa.model.domain.Product;

public class ProductOffer extends AbstractOffer {

    private Product product;

    public ProductOffer() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Integer getTotal() {
        return this.product.getPrice() - (this.product.getPrice() * super.getDiscount() / 100);
    }

}
