package org.example.user_crud.dao;

import org.example.user_crud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    User findByUserName(String username);
    void addUser(User user);
    void updateUser(User user);
    User get(int id);
    void removeUserById(int id);
    List<User> getAllUsers();
}
