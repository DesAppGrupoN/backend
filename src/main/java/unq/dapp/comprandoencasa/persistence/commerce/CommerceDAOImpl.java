package unq.dapp.comprandoEnCasa.persistence.commerce;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unq.dapp.comprandoEnCasa.model.domain.commerce.Commerce;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CommerceDAOImpl implements CommerceDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Commerce> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Commerce> theQuery = currentSession.createQuery("from Commerce", Commerce.class);

        return theQuery.getResultList();
    }

    @Override
    public Commerce findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(Commerce.class, id);
    }

    @Override
    public void save(Commerce commerce){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(commerce);
    }

    @Override
    public void deleteById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Commerce> theQuery = currentSession.createQuery("delete from Commerce where id=:idCommerce");

        theQuery.setParameter("idCommerce", id);
        theQuery.executeUpdate();
    }


}
