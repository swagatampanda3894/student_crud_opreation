package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/insert/user")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }


//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable String id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
    @DeleteMapping("/users/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
