package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "Funciona";
    }

}
