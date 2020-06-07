package unq.dapp.ComprandoEnCasa.persistence.commerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

    Optional<ShoppingCart> findById(Integer id);

    List<ShoppingCart> findAll();

}