package com.dslz.services;

import java.util.List;

import com.dslz.beans.User;

public interface UserService {

    public abstract List<User> findAllUsers();

    public abstract User findUserByEmail(String userEmail);

    public abstract void deleteUser(User user);

    public abstract void createUser(User user);
    
}