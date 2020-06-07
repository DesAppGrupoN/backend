package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ShoppingCartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Transactional
    public List<ShoppingCart> findAll() { return repository.findAll(); }

    @Transactional
    public Optional<ShoppingCart> findById(int id) { return repository.findById(id); }

    @Transactional
    public void save(ShoppingCart shoppingCart) {
        this.repository.save(shoppingCart);
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
