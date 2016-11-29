package ir.hri.core.services.impl;

import ir.hri.core.entities.User;
import ir.hri.core.repositories.UserRepository;
import ir.hri.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) throws Exception {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) throws Exception {
        userRepository.insert(user);
    }

    @Override
    public void delete(String username) throws Exception {
        userRepository.delete(username);
    }
}
