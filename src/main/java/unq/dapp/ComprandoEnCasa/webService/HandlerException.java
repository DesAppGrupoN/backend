package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import unq.dapp.ComprandoEnCasa.model.exceptions.NotEnoughStockOfProductException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<?> handleValidationExceptions(TransactionSystemException ex){
        String result = "Something went wrong";

        Throwable cause = ((TransactionSystemException) ex).getRootCause();
        if (cause instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();
            result = constraintViolations.stream().findFirst().get().getMessageTemplate();
        }
        return new ResponseEntity<>( "error:  " + result, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotEnoughStockOfProductException.class)
    public ResponseEntity<String> notEnoughStockForAProduct(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
