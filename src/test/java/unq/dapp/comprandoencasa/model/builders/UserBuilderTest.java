package unq.dapp.comprandoencasa.model.builders;

import org.junit.jupiter.api.Test;
import unq.dapp.comprandoencasa.model.domain.ShoppingCart;
import unq.dapp.comprandoencasa.model.domain.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class UserBuilderTest {

    @Test
    public void buildUserWithUsername() {
        User user = UserBuilder.aUser().withUsername("Octavia2020").build();

        assertEquals("Octavia2020", user.getUsername());
    }

    @Test
    public void buildUserWithName() {
        User user = UserBuilder.aUser().withName("Octavia").build();

        assertEquals("Octavia", user.getName());
    }

    @Test
    public void buildUserWithLastname() {
        User user = UserBuilder.aUser().withLastname("Black").build();

        assertEquals("Black", user.getLastName());
    }


    @Test
    public void buildUserWithPassword() {
        User user = UserBuilder.aUser().withPassword("Secure1234").build();

        assertEquals("Secure1234", user.getPassword());
    }

    @Test
    public void buildUserWithEmail() {
        User user = UserBuilder.aUser().withEmail("Octavia2020@gmail.com").build();

        assertEquals("Octavia2020@gmail.com", user.getEmail());
    }

    @Test
    public void buildUserWithShoppingCart() {
        ShoppingCart shoppingCartMock = mock(ShoppingCart.class);
        User user = UserBuilder.aUser().withShoppingCart(shoppingCartMock).build();

        assertEquals(shoppingCartMock, user.getShoppingCart());
    }



}
