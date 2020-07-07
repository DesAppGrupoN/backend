package unq.dapp.ComprandoEnCasa.services;

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
    public Optional findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Optional findByUsername(String username) {
        return repository.findByUsername(username);
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
        if (!findByUsername(user.getUsername()).isPresent())
        this.repository.save(user);
        else new UsernameAlreadyExistsException();
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
