package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.builders.UserBuilder;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.dtos.UserOauthDTO;
import unq.dapp.ComprandoEnCasa.model.exceptions.UsernameAlreadyExistsException;
import unq.dapp.ComprandoEnCasa.model.exceptions.InvalidUsernameOrPasswordException;
import unq.dapp.ComprandoEnCasa.persistence.commerce.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional findByEmail(String userEmail) {
        return repository.findByEmail(userEmail);
    }

    public Optional findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User getUserByUsernameAndPassword(User user){
        return this.findAll().stream()
                .filter(it -> it.getUsername().equals(user.getUsername()) && it.getPassword().equals(user.getPassword()) )
                .findFirst()
                .orElseThrow(InvalidUsernameOrPasswordException::new);
    }

    public void save(User user) {
        if (!findByUsername(user.getUsername()).isPresent())
        this.repository.save(user);
        else new UsernameAlreadyExistsException();
    }

    public void deleteByEmail(String userEmail) {
        repository.deleteById(1);
    }

    public List<Commerce> getCommercesByUserEmail(String userEmail) {
        Optional<User> user = repository.findByEmail(userEmail);
        if(user.isPresent()) {
            return(user.get().getCommerceList());
        }
        else {
            return(new ArrayList<>());
        }
    }

    public void saveIfNoExists(UserOauthDTO userOauthDTO) {
        if(!this.findByEmail(userOauthDTO.getEmail()).isPresent()) {
            User user = UserBuilder.aUser()
                    .withEmail(userOauthDTO.getEmail())
                    .withUsername(userOauthDTO.getNickname())
                    .withName(userOauthDTO.getName())
                    .build();

            repository.save(user);
        }
    }

}
