package unq.dapp.ComprandoEnCasa.model.domain.offers;

import unq.dapp.ComprandoEnCasa.model.domain.Product;

public class PairProductOffer extends AbstractOffer {

    private Product firstProduct;
    private Product secondProduct;

    public Product getFirstProduct() {
        return firstProduct;
    }

    public void setFirstProduct(Product firstProduct) {
        this.firstProduct = firstProduct;
    }

    public Product getSecondProduct() {
        return secondProduct;
    }

    public void setSecondProduct(Product secondProduct) {
        this.secondProduct = secondProduct;
    }

    @Override
    public Integer getTotal() {
        Integer normalPrice = firstProduct.getPrice() + secondProduct.getPrice();
        Integer discountPrice = normalPrice * super.getDiscount() / 100;
        return normalPrice - discountPrice;
    }

}
