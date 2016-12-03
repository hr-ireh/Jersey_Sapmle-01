package ir.hri.core.repositories.impl;

import ir.hri.aspect.annotation.Loggable;
import ir.hri.core.entities.User;
import ir.hri.core.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "entityManagerFactory")
    EntityManager entityManager;

    @Override
    public User findByUsername(String username) throws Exception {
        Query query = entityManager.createQuery("select t from User t where t.username = :username");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        Query query = entityManager.createQuery("select t from User t");
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    @Loggable(description = "UserRepositoryImpl.insert")
    public void insert(User user) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.refresh(user);
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.clear();
            throw e;
        }
    }

    @Override
    public void delete(String username) throws Exception {
        Query query = entityManager.createQuery("delete from User t where t.username = :username");
        query.setParameter("username", username);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
