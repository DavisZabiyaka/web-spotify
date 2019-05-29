package com.dslz.services;

import java.util.List;

import com.dslz.beans.User;
import com.dslz.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
    
}