package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductDTO;
import unq.dapp.ComprandoEnCasa.model.utils.OpenCSVReadAndParseToBean;
import unq.dapp.ComprandoEnCasa.services.EmailService;
import unq.dapp.ComprandoEnCasa.services.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDTO product) {
        productService.save(product);
        return ResponseEntity.ok("Product is valid");
    }

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

    @PostMapping("/addBatch/{idCommerce}")
    public ResponseEntity<String> addProducts(@Valid @RequestParam MultipartFile file, @PathVariable Integer idCommerce) throws IOException {
        if (file.isEmpty()) {
            return new ResponseEntity<>("El file esta vacio", HttpStatus.OK);
        } else {
            OpenCSVReadAndParseToBean openCSVReadAndParseToBean = new OpenCSVReadAndParseToBean();
            List<ProductDTO> productList = openCSVReadAndParseToBean.main(file);
            List<String> productsName= new ArrayList<>();
            productList.stream().forEach((product) -> {
                product.setCommerceId(idCommerce);
                productService.save(product);
                productsName.add(product.getName())  ; });
                return new ResponseEntity<>(productsName.toString(), HttpStatus.OK);
                }

        }
    }