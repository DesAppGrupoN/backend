package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.exceptions.UsernameAlreadyExistsException;
import unq.dapp.ComprandoEnCasa.model.exceptions.InvalidUsernameOrPasswordException;
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
    public Optional findById(String id) {
        return repository.findById(id);
    }

    @Transactional
    public User getUserByUsernameAndPassword(User user){
        return this.findAll().stream()
                .filter(it -> it.getUsername().equals(user.getUsername()) && it.getPassword().equals(user.getPassword()) )
                .findFirst()
                .orElseThrow(InvalidUsernameOrPasswordException::new);
    }

    @Transactional
    public void save(User user) {
        if (!findById(user.getUsername()).isPresent())
        this.repository.save(user);
        else new UsernameAlreadyExistsException();
    }g

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
