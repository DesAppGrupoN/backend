package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import unq.dapp.ComprandoEnCasa.persistence.commerce.AttentionScheduleRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AttentionScheduleService {

    @Autowired
    private AttentionScheduleRepository repository;

    public List<AttentionSchedule> findAll() { return repository.findAll(); }

    public Optional<AttentionSchedule> findById(int id) { return repository.findById(id); }

    public void save(AttentionSchedule attentionSchedule) {
        this.repository.save(attentionSchedule);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
