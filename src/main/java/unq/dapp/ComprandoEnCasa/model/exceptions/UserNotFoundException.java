package unq.dapp.ComprandoEnCasa.model.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {super("User email was not found");}
}
