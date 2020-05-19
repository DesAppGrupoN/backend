package unq.dapp.comprandoencasa.services.commerce;


import unq.dapp.comprandoencasa.model.domain.commerce.Commerce;
import java.util.List;

public interface CommerceService {

    public List<Commerce> findAll();

    public Commerce findById(int id);

    public void save(Commerce commerce);

    public void deleteById(int id);

}
