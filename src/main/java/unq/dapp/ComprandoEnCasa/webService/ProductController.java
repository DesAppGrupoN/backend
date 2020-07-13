package unq.dapp.ComprandoEnCasa.webService;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.utils.CSVProduct;
import unq.dapp.ComprandoEnCasa.model.utils.OpenCSVReadAndParseToBean;
import unq.dapp.ComprandoEnCasa.services.EmailService;
import unq.dapp.ComprandoEnCasa.services.ProductService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            emailService.sendNotificaitoin();
        }
        catch (Exception e) {}
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

    @PostMapping("/addBatch")
    public void addProducts(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.print("Esta vacio el file");
        }
        else {

            OpenCSVReadAndParseToBean openCSVReadAndParseToBean = new OpenCSVReadAndParseToBean();
            List<CSVProduct> res = openCSVReadAndParseToBean.main(file);
            System.out.print(res);
        }








}
