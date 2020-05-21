package unq.dapp.ComprandoEnCasa.persistence.commerce;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface CommerceRepository extends CrudRepository<Commerce, Integer> {

    Optional<Commerce> findById(Integer id);

    List<Commerce> findAll();

}