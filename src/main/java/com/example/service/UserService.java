package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(String emailId);

    List<User> getAllUsers();

    void deleteUser(String emailId);
}
