package unq.dapp.ComprandoEnCasa.persistence.commerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.dapp.ComprandoEnCasa.model.domain.Product;


import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<Product> findById(Integer id);

    List<Product> findAll();
}