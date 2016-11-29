package ir.hri.core.repositories;

import ir.hri.core.entities.User;

import java.util.List;

public interface UserRepository {
    User findByUsername(String username) throws Exception;

    List<User> findAll() throws Exception;

    void insert(User user) throws Exception;

    void delete(String username) throws Exception;
}
