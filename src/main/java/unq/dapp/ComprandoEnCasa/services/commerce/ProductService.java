package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> findAll() { return repository.findAll(); }

    @Transactional
    public Optional<Product> findById(int id) { return repository.findById(id); }

    @Transactional
    public void save(Product product) {
        this.repository.save(product);
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public List<Product> getAllByCommerceId(int id) {
        return repository.findByCommerceId(id);
    }

}
