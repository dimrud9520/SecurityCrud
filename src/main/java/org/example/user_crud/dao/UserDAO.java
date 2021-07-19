package org.example.user_crud.dao;

import org.example.user_crud.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    User get(int id);
    void removeUserById(int id);
    List<User> getAllUsers();
}
