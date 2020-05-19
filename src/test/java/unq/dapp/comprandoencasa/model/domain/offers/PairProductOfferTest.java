package unq.dapp.comprandoEnCasa.model.domain.offers;

import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PairProductOfferTest {

    @Test
    public void setAndGetFirstProduct() {
        Product firstProduct = mock(Product.class);
        PairProductOffer pairProductOffer = new PairProductOffer();
        pairProductOffer.setFirstProduct(firstProduct);
        assertEquals(firstProduct, pairProductOffer.getFirstProduct());
    }

    @Test
    public void setAndGetSecondProduct() {
        Product secondProduct = mock(Product.class);
        PairProductOffer pairProductOffer = new PairProductOffer();
        pairProductOffer.setSecondProduct(secondProduct);
        assertEquals(secondProduct, pairProductOffer.getSecondProduct());
    }

    @Test
    public void getTotal() {
        Integer discount = 10;
        Integer priceFirstProduct = 100;
        Integer priceSecondProduct = 100;
        Product firstProduct = mock(Product.class);
        Product secondProduct = mock(Product.class);
        when(firstProduct.getPrice()).thenReturn(priceFirstProduct);
        when(secondProduct.getPrice()).thenReturn(priceSecondProduct);

        PairProductOffer pairProductOffer = new PairProductOffer();
        pairProductOffer.setFirstProduct(firstProduct);
        pairProductOffer.setSecondProduct(secondProduct);
        pairProductOffer.setDiscount(discount);

        Integer totalExpected = 180;

        assertEquals(totalExpected, pairProductOffer.getTotal());
    }
}