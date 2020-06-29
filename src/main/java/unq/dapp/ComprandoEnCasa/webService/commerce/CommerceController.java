package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.services.commerce.CommerceService;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    private CommerceService commerceService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Commerce> commerceList = commerceService.findAll();
        return ResponseEntity.ok().body(commerceList);
    }

    @RequestMapping(value = "/get/{commerceId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable int commerceId) {
        Optional commerce = commerceService.findById(commerceId);
        return ResponseEntity.ok().body(commerce);
    }

    @PostMapping("/add")
    public void addCommerce(@RequestBody Commerce commerce) { commerceService.save(commerce); }

    @RequestMapping(value = "/delete/{commerceId}", method = RequestMethod.GET)
    public void delete(@PathVariable int commerceId) {
        commerceService.deleteById(commerceId);
    }

    @RequestMapping(value ="/get_sectors", method = RequestMethod.GET)
    public ResponseEntity<?> getSectors() {
        return ResponseEntity.ok().body(commerceService.getSectors());
    }

    @RequestMapping(value ="/get_paymethods", method = RequestMethod.GET)
    public ResponseEntity<?> getPaymethods() {
        return ResponseEntity.ok().body(commerceService.getPaymethods());
    }

    @RequestMapping(value = "/search/{search}", method = RequestMethod.GET)
    public ResponseEntity<?> search(@PathVariable String search) {
        List<Commerce> commerceList = commerceService.search(search);
        return ResponseEntity.ok().body(commerceList);
    }

}
