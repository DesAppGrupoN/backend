package unq.dapp.ComprandoEnCasa.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.PurchaseOrder;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.dtos.PurchaseOrderDTO;
import unq.dapp.ComprandoEnCasa.model.dtos.UserOauthDTO;
import unq.dapp.ComprandoEnCasa.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "/get/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String userEmail) {
        Optional user = userService.findByEmail(userEmail);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping (value = "/get_commerces/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommercesByUserId(@PathVariable String userEmail) {
        List<Commerce> commerces = userService.getCommercesByUserEmail(userEmail);
        return ResponseEntity.ok().body(commerces);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) { userService.save(user); }

    @RequestMapping(value = "/delete/{userEmail}", method = RequestMethod.GET)
    public void delete(@PathVariable String userEmail) {
        userService.deleteByEmail(userEmail);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.getUserByUsernameAndPassword(user));
    }

    @PostMapping("/userLoggedIn")
    public void userLoggedIn(@RequestBody UserOauthDTO userOauthDTO) {
        userService.saveIfNoExists(userOauthDTO);
    }

    @RequestMapping(value = "/get_purchase_history/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getPurchaseHistory(@PathVariable String userEmail) {
        List<PurchaseOrderDTO> purchaseHistory = userService.getPurchaseHistory(userEmail);
        return ResponseEntity.ok().body(purchaseHistory);
    }
}
