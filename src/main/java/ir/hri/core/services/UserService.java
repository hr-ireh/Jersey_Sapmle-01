package ir.hri.core.services;

import ir.hri.core.entities.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username) throws Exception;

    List<User> findAll() throws Exception;

    void insert(User user) throws Exception;

    void delete(String username) throws Exception;
}