package unq.dapp.ComprandoEnCasa.services.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceDAO;

import java.util.List;

@Service
public class CommerceServiceImpl implements CommerceService {

    @Autowired
    private CommerceDAO commerceDAO;

    @Override
    public List<Commerce> findAll() {
        return commerceDAO.findAll();
    }

    @Override
    public Commerce findById(int id) {
        return commerceDAO.findById(id);
    }

    @Override
    public void save(Commerce commerce) {
        commerceDAO.save(commerce);
    }

    @Override
    public void deleteById(int id) {
        commerceDAO.deleteById(id);
    }

}
