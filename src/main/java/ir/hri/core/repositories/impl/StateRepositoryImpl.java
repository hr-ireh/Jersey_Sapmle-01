package ir.hri.core.repositories.impl;

import ir.hri.core.entities.State;
import ir.hri.core.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public State findById(int id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from State t where t.id = :id");
        query.setParameter("id", Integer.valueOf(id));
        State state = (State) query.getSingleResult();
        return state;
    }

    @Override
    public List<State> findAll() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from State t");
        List<State> stateList = query.getResultList();
        return stateList;
    }
}
