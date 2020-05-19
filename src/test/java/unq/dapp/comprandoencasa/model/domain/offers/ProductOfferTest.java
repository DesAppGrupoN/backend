package unq.dapp.comprandoEnCasa.model.domain.offers;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductOfferTest {

    @Test
    public void getProduct() {
        ProductOffer productOffer = new ProductOffer();
        Product anyProduct = mock(Product.class);
        productOffer.setProduct(anyProduct);

        assertEquals(anyProduct, productOffer.getProduct());
    }

    @Test
    public void getTotal() {
        Integer discount = 10;
        Integer priceProduct1 = 10;
        Integer totalExpected = priceProduct1 - priceProduct1 * discount / 100;
        ProductOffer productOffer = new ProductOffer();
        Product product1 = mock(Product.class);
        when(product1.getPrice()).thenReturn(priceProduct1);
        productOffer.setProduct(product1);
        productOffer.setDiscount(discount);

        assertEquals(totalExpected, productOffer.getTotal());
    }
}