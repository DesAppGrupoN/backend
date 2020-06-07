package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.services.commerce.ProductService;
import unq.dapp.ComprandoEnCasa.services.commerce.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ShoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<ShoppingCart> productsList = shoppingCartService.findAll();
        return ResponseEntity.ok().body(productsList);
    }

    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable int productId) {
        Optional shoppingCart = shoppingCartService.findById(productId);
        return ResponseEntity.ok().body(shoppingCart);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ShoppingCart shoppingService) { shoppingCartService.save(shoppingService); }

}
