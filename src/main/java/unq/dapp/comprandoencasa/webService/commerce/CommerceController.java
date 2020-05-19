package unq.dapp.comprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.dapp.comprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.comprandoEnCasa.services.commerce.CommerceService;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    private CommerceService commerceService;

    @RequestMapping(value="/get_all", method= RequestMethod.GET)
    public List<Commerce> findAll(){
        return commerceService.findAll();
    }

    @RequestMapping(value="/get/{commerceId}", method= RequestMethod.GET)
    public Commerce findById(@PathVariable int commerceId){
        return commerceService.findById(commerceId);
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public void save() {
        Commerce commerce = new Commerce();
        commerceService.save(commerce);
    }

    @RequestMapping(value="/delete/{commerceId}", method= RequestMethod.GET)
    public void delete(@PathVariable int commerceId){
        commerceService.deleteById(commerceId);
    }

}
