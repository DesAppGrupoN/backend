package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceService {

    @Autowired
    private CommerceRepository repository;

    @Transactional
    public List<Commerce> findAll() { return repository.findAll(); }

    @Transactional
    public Optional<Commerce> findById(int id) { return repository.findById(id); }

    @Transactional
    public void save(Commerce commerce) {
        this.repository.save(commerce);
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Sector[] getCategories() {
        return Sector.values();
    }
}
