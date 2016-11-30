package ir.hri.core.repositories.impl;

import ir.hri.core.entities.User;
import ir.hri.core.repositories.UserRepository;
import ir.hri.core.util.JPAUtility;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    EntityManager entityManager =
            JPAUtility.getEntityManager();

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
    public void insert(User user) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.refresh(user);
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
