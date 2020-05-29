package unq.dapp.ComprandoEnCasa.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{
    public InvalidUsernameOrPasswordException() {super("Usuario o contraseña incorrectos.");}
}