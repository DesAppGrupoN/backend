package unq.dapp.comprandoEnCasa.persistence.commerce;


import unq.dapp.comprandoEnCasa.model.domain.commerce.Commerce;
import java.util.List;

public interface CommerceDAO {

    public List<Commerce> findAll();

    public Commerce findById(int id);

    public void save(Commerce commerce);

    public void deleteById(int id);

}