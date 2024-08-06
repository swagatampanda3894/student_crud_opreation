package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    //saving a specific record by using the method save() of CrudRepository
    public User save(User user)
    {
        userRepository.save(user);
        return user;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }
//    public User addUser(User user) {
//        users.add(user);
//        System.out.println("UserADDDD "+ user.toString());
//        userRepository.
//        return user;
//    }



//    public User updateUser(String userId, User updatedUser) {
//        User user = getUser(userId);
//        if (user != null) {
//            user.setName(updatedUser.getName());
//            user.setEmail(updatedUser.getEmail());
//            return user;
//        }
//        return null;
//    }

    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return true;
    }

}
