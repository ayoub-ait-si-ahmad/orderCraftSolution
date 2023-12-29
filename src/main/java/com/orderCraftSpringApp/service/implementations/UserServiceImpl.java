package com.orderCraftSpringApp.service.implementations;

import com.orderCraftSpringApp.model.classes.User;
import com.orderCraftSpringApp.repository.UserRepository;
import com.orderCraftSpringApp.service.interfaces.UserService;
import com.orderCraftSpringApp.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private EncryptionUtils encryptionUtils;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EncryptionUtils encryptionUtils) {
        this.userRepository = userRepository;
        this.encryptionUtils = encryptionUtils;
    }
    @Override
    public User findUserById(Long userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("User already exists!");
        }
        // encrypt the password
        String password = user.getPassword();
        try {
            String encryptedPassword = encryptionUtils.encrypt(password);
            user.setPassword(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userID, User user) {
        Optional<User> userOptional = userRepository.findById(user.getUserID());
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setUserName(user.getUserName());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userID);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
