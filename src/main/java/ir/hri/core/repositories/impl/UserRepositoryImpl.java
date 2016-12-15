package ir.hri.core.repositories.impl;

import ir.hri.aspect.annotation.Loggable;
import ir.hri.core.entities.User;
import ir.hri.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public User findByUsername(String username) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from User t where t.username = :username");
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from User t");
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    @Loggable(description = "UserRepositoryImpl.insert")
    public void insert(User user) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("delete from User t where t.username = :username");
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);
        query.setParameter("username", username);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
