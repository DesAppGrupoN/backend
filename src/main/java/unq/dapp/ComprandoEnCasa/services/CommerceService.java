package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommerceService {

    @Autowired
    private CommerceRepository repository;

    public List<Commerce> findAll() { return repository.findAll(); }

    public Optional<Commerce> findById(int id) { return repository.findById(id); }

    public void save(Commerce commerce) {
        this.repository.save(commerce);
    }

    public List<Commerce> search(String search) {
        return repository.findBy(search.toLowerCase());
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Sector[] getSectors() {
        return Sector.values();
    }

    public PayMethods[] getPaymethods() {
        return PayMethods.values();
    }
}
