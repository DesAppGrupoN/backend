package unq.dapp.comprandoencasa.model.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {

    @Test
    public void addAndContainsItem() {
        Integer amount = 1;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productMock = mock(Product.class);
        shoppingCart.addItem(productMock, amount);
        assertTrue(shoppingCart.containsItem(productMock));
    }

    @Test
    public void addAndGetItem() {
        Integer amount = 1;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productMock = mock(Product.class);
        shoppingCart.addItem(productMock, amount);
        assertEquals(amount, shoppingCart.getValue(productMock));
    }

    @Test
    public void removeItem() {
        Integer amount = 1;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productMock = mock(Product.class);
        shoppingCart.addItem(productMock, amount);

        shoppingCart.removeItem(productMock);
        assertFalse(shoppingCart.containsItem(productMock));
    }

    @Test
    public void isEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertTrue(shoppingCart.isEmpty());
    }

    @Test
    public void cleanCart() {
        Integer amount = 1;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productMock = mock(Product.class);
        shoppingCart.addItem(productMock, amount);
        assertFalse(shoppingCart.isEmpty());
        shoppingCart.emptyCart();
        assertTrue(shoppingCart.isEmpty());
    }

    @Test
    public void getTotalTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = mock(Product.class);
        Integer priceProduct1 = 100;
        Integer quantityProduct1 = 1;
        Product product2 = mock(Product.class);
        Integer priceProduct2 = 200;
        Integer quantityProduct2 = 2;

        when(product1.getPrice()).thenReturn(priceProduct1);
        when(product2.getPrice()).thenReturn(priceProduct2);

        Integer totalExpected = priceProduct1 * quantityProduct1 + priceProduct2 * quantityProduct2;

        shoppingCart.addItem(product1, quantityProduct1);
        shoppingCart.addItem(product2, quantityProduct2);

        assertEquals(totalExpected, shoppingCart.getTotalPrice());
    }

}