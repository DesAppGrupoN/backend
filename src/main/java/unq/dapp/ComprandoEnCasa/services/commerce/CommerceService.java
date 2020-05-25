package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;

@Service
public class CommerceService {

    @Autowired
    private CommerceRepository repository;

    @Transactional
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> findById(int id) {
        return ResponseEntity.ok().body(repository.findById(id));
    }

    @Transactional
    public void save(Commerce commerce) {
        this.repository.save(commerce);
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
