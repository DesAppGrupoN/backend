package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.services.commerce.ProductService;
import unq.dapp.ComprandoEnCasa.services.commerce.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<ShoppingCart> productsList = shoppingCartService.findAll();
        return ResponseEntity.ok().body(productsList);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) { shoppingCartService.addProduct(product,1,1); }

    @PostMapping("/add")
    public void addShoppingCart(@RequestBody ShoppingCart shoppingService) { shoppingCartService.save(shoppingService); }

}
