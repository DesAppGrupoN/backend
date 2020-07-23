package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.dtos.CommerceDTO;
import unq.dapp.ComprandoEnCasa.services.CommerceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    private CommerceService commerceService;
    private MyResourceNotFoundException myResourceNotFoundException= new MyResourceNotFoundException();

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
    public ResponseEntity<String> addCommerce(@Valid @RequestBody CommerceDTO commerceDTO) {
        commerceService.save(commerceDTO);
        return ResponseEntity.ok("Commerce is valid");
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestBody CommerceDTO commerceDTO) {
        commerceService.delete(commerceDTO);
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
