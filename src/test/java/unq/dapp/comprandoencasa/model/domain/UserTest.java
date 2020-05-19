package unq.dapp.comprandoencasa.model.domain;



import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void constructorTest() {
        String username = "username";
        String password = "password";
        String email = "email";
        String name = "name";
        String lastname = "lastname";

        User user = new User(username, password, email, name, lastname);

        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(name, user.getName());
        assertEquals(lastname, user.getLastName());
    }

    @Test
    public void userShouldAddAnItemToShoppingCart() {
        User user = new User();
        ShoppingCart shoppingCartMock = mock(ShoppingCart.class);
        Product productMock = mock(Product.class);

        user.setShoppingCart(shoppingCartMock);
        user.addToCart(productMock, 1);

        verify(shoppingCartMock, times(1)).addItem(productMock, 1);
    }
    @Test
    public void userShouldCleanToShoppingCart() {
        User user = new User();
        ShoppingCart shoppingCartMock = mock(ShoppingCart.class);
        Product productMock = mock(Product.class);

        user.setShoppingCart(shoppingCartMock);
        user.addToCart(productMock, 1);
        user.cleanShoppingCart();
        verify(shoppingCartMock, times(1)).emptyCart();
    }
    @Test
    public void ShouldBuyShoppingCart() {
        User user = new User();
        ShoppingCart shoppingCartMock = mock(ShoppingCart.class);
        Product productMock = mock(Product.class);

        user.setShoppingCart(shoppingCartMock);
        user.addToCart(productMock, 1);
        user.buyShoppingCart(shoppingCartMock);
        assertEquals(user.getPurchaseHistory().size(), 1);
        assertEquals(user.getPurchaseHistory().get(LocalDate.now()), shoppingCartMock);
    }
    @Test
    public void testUserEnableNotifications() {
        User user = new User();
        user.enableNotifications();
        assertTrue(user.getStatusNotifications());
    }
    @Test
    public void testUserDisableNotifications() {
        User user = new User();
        user.disableNotifications();
        assertFalse(user.getStatusNotifications());
    }

}
