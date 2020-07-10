package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.builders.CommerceBuilder;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import unq.dapp.ComprandoEnCasa.model.dtos.CommerceDTO;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommerceService {

    @Autowired
    private CommerceRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Commerce> findAll() { return repository.findAll(); }

    public Optional<Commerce> findById(int id) { return repository.findById(id); }

    public void save(CommerceDTO commerceDTO) {

            Optional<User> user = userRepository.findByEmail(commerceDTO.getUserEmail());
            if (user.isPresent()) {
                Commerce commerce = CommerceBuilder.aCommerce()
                        .withName(commerceDTO.getName())
                        .withAddress(commerceDTO.getAddress())
                        .withAttentionSchedule(commerceDTO.getAttentionSchedule())
                        .withImage(commerceDTO.getImage())
                        .withMaDistance(commerceDTO.getMaxDistance())
                        .withPayMethods(commerceDTO.getPayMethods())
                        .withSector(commerceDTO.getSector())
                        .withDescription(commerceDTO.getDescription())
                        .withId(commerceDTO.getId())
                        .build();

                user.get().addComerce(commerce);
                userRepository.save(user.get());
            }

    }

    public List<Commerce> search(String search) {
        return repository.findBy(search.toLowerCase());
    }

    public void delete(CommerceDTO commerceDTO) {
        Optional<User> user = userRepository.findByEmail(commerceDTO.getUserEmail());
        if(user.isPresent()) {
            Commerce commerce = repository.findById(commerceDTO.getId()).orElse(new Commerce());
            user.get().removeCommerce(commerce);
            userRepository.save(user.get());
        }
    }

    public Sector[] getSectors() {
        return Sector.values();
    }

    public PayMethods[] getPaymethods() {
        return PayMethods.values();
    }
}
