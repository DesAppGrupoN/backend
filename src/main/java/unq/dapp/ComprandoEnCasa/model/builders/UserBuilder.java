package unq.dapp.ComprandoEnCasa.model.builders;


import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.domain.User;

public class UserBuilder {

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private ShoppingCart shoppingCart;

    public UserBuilder(){

        this.username = "not username";
        this.password = "not password";
        this.email = "not email";
        this.name = "not name";
        this.lastName = "not lastName";
        this.shoppingCart = new ShoppingCart();

    }

    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setLastName(lastName);
        user.setShoppingCart(shoppingCart);

        return user;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withLastname(String lastname) {
        this.lastName = lastname;
        return this;
    }

    public UserBuilder withShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        return this;
    }

}
