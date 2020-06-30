package unq.dapp.ComprandoEnCasa.persistence.commerce;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface AttentionScheduleRepository extends CrudRepository<AttentionSchedule, Integer> {

    Optional<AttentionSchedule> findById(Integer id);

    List<AttentionSchedule> findAll();

}