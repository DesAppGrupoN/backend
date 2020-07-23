package unq.dapp.ComprandoEnCasa.model.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {

    @Test
    public void isEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertTrue(shoppingCart.isEmpty());
    }

    @Test
    public void cleanCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productMock = mock(Product.class);
        shoppingCart.addItem(productMock);
        assertFalse(shoppingCart.isEmpty());
        shoppingCart.emptyCart();
        assertTrue(shoppingCart.isEmpty());
    }

    @Test
    public void getTotalTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = mock(Product.class);
        Integer priceProduct1 = 100;
        Product product2 = mock(Product.class);
        Integer priceProduct2 = 200;

        when(product1.getPrice()).thenReturn(priceProduct1);
        when(product2.getPrice()).thenReturn(priceProduct2);

        when(product1.getId()).thenReturn(1);
        when(product2.getId()).thenReturn(2);

        Integer totalExpected = priceProduct1 + priceProduct2;

        shoppingCart.addItem(product1);
        shoppingCart.addItem(product2);

        assertEquals(totalExpected, shoppingCart.getTotalPrice());
    }

}