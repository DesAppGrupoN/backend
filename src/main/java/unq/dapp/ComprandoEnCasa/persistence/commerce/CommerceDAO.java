package unq.dapp.ComprandoEnCasa.persistence.commerce;


import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import java.util.List;

public interface CommerceDAO {

    public List<Commerce> findAll();

    public Commerce findById(int id);

    public void save(Commerce commerce);

    public void deleteById(int id);

}
