package unq.dapp.ComprandoEnCasa.webService.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.services.commerce.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable int userId) {
        Optional user = userService.findById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/add")
    public void addClient(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public void delete(@PathVariable int userId) {
        userService.deleteById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        List<User> users = userService.findAll();
        User user = userService.getUserByUsernameAndPassword(username, password, users);
        return ResponseEntity.ok().body(user);
    }
}
