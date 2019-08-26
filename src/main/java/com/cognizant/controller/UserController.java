package com.cognizant.controller;

import com.cognizant.data.User;
import com.cognizant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getUsers();
    }

    @PostMapping("/users/create")
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users/get/{id}")
    public User getUserById(@PathVariable(value = "id") Integer userId){
        return userService.findById(userId);
    }

    @PutMapping("/users/update/{id}")
    public User updateUser(@PathVariable(value = "id") Integer userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deletebyUserId(@PathVariable(value = "id") Integer userId) {
        userService.deleteById(userId);
    }
}
