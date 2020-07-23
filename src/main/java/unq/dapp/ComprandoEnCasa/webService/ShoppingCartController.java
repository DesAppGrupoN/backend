package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductShoppingCartDTO;
import unq.dapp.ComprandoEnCasa.services.ProductService;
import unq.dapp.ComprandoEnCasa.services.ShoppingCartService;

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

}
