package com.orderCraftSpringApp.service.interfaces;

import com.orderCraftSpringApp.model.classes.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    // the methods that i will need to implement in the service implementation
    // TODO : DON'T FORGET TO DELETE THE METHODS THAT YOU DON'T NEED
    User findByUsername(String username);
    User findByEmail(String email);
    User findUserById(Long userID);
    User saveUser(User user);
    User updateUser(Long userID, User user);
    boolean deleteUser(Long userID);
    List<User> findAllUsers();
}
