package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.services.commerce.CommerceService;

import java.util.List;
import java.util.Optional;

@RestController
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void save() {
        Commerce commerce = new Commerce();
        commerceService.save(commerce);
    }

    @RequestMapping(value = "/delete/{commerceId}", method = RequestMethod.GET)
    public void delete(@PathVariable int commerceId) {
        commerceService.deleteById(commerceId);
    }

}
