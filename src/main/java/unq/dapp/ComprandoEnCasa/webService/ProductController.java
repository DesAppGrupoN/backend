package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.services.commerce.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Product> productsList = productService.findAll();
        return ResponseEntity.ok().body(productsList);
    }

    @RequestMapping(value = "/get/by_id/{productId}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/get/by_commerce_id/{commerceId}", method = RequestMethod.GET)
    public ResponseEntity<?> findByCommerceId(@PathVariable int commerceId) {
        List<Product> productList = productService.getAllByCommerceId(commerceId);
        return ResponseEntity.ok().body(productList);
    }

    @RequestMapping(value ="/get_categories", method = RequestMethod.GET)
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok().body(productService.getCategories());
    }

}
