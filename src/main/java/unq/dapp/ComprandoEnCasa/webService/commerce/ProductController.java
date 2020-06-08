package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.services.commerce.CommerceService;
import unq.dapp.ComprandoEnCasa.services.commerce.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Product> productsList = productService.findAll();
        return ResponseEntity.ok().body(productsList);
    }

    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable int productId) {
        Optional product = productService.findById(productId);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) { productService.save(product); }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public void delete(@PathVariable int productId) {
        productService.deleteById(productId);
    }

}