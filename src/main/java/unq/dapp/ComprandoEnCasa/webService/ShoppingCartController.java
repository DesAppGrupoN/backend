package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductShoppingCartDTO;
import unq.dapp.ComprandoEnCasa.model.dtos.PurchaseDTO;
import unq.dapp.ComprandoEnCasa.services.ProductService;
import unq.dapp.ComprandoEnCasa.services.ShoppingCartService;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<ShoppingCart> productsList = shoppingCartService.findAll();
        return ResponseEntity.ok().body(productsList);
    }

    @RequestMapping(value = "/get_user_shopping_cart/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserShoppingCart(@PathVariable String userEmail) {
        ShoppingCart shoppingCart = shoppingCartService.getUserShoppingCart(userEmail);
        return ResponseEntity.ok().body(shoppingCart);
    }

    @PostMapping("/add_product")
    public void addProduct(@RequestBody ProductShoppingCartDTO productShoppingCartDTO) { shoppingCartService.addProduct(productShoppingCartDTO); }

    @PostMapping("/remove_product")
    public void removeProduct(@RequestBody ProductShoppingCartDTO productShoppingCartDTO) { shoppingCartService.removeProduct(productShoppingCartDTO); }


    @PostMapping("/change_quantity")
    public void changeProductQuantity(@RequestBody ProductShoppingCartDTO productShoppingCartDTO) { shoppingCartService.changeProductQuantity(productShoppingCartDTO); }

    @RequestMapping(value = "/get_available_paymethods/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getAvailablePaymethods(@PathVariable String userEmail) {
        List<PayMethods> payMethods = shoppingCartService.getAvailablePaymethods(userEmail);
        return ResponseEntity.ok(payMethods);
    }

    @RequestMapping(value = "/get_commerces_in_shopping_cart/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommercesInUserShoppingCart(@PathVariable String userEmail) {
        List<Commerce> payMethods = shoppingCartService.getCommercesInUserShoppingCart(userEmail);
        return ResponseEntity.ok(payMethods);
    }

    @RequestMapping(value = "/get_commerces_turns/{commerceId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommercesTurns(@PathVariable Integer commerceId) {
        List<LocalTime> turns = shoppingCartService.getCommercesTurns(commerceId);
        return ResponseEntity.ok(turns);
    }

    @PostMapping("/confirm_purchase")
    public void confirmPurchase(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        shoppingCartService.confirmPurchase(purchaseDTO);
    }

}
