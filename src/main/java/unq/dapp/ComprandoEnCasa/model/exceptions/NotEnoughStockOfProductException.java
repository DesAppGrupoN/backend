package unq.dapp.ComprandoEnCasa.model.exceptions;

public class NotEnoughStockOfProductException extends RuntimeException {
    public NotEnoughStockOfProductException(){
        super("There is not enough stock for a product of your shopping cart.");
    }
}