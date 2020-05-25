package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.persistence.commerce.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    public static User getUserByUsernameAndPassword(String username,String password , List<User> users){
        User res = null;
        for (User user: users){
            if(user.getUsername().equals(username)&& user.getPassword().equals(password)){
                res = user ;
            }
        }
        return res;
    }
    @Transactional
    public void save(User user) {
        this.repository.save(user);
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
