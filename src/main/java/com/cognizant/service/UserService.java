package com.cognizant.service;

import com.cognizant.data.User;
import com.cognizant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException());
    }

    public User updateUser(Integer userId, User updUser) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException());
        user.setFirstName(updUser.getFirstName());
        user.setLastName(updUser.getLastName());
        user.setEmployeeId(updUser.getEmployeeId());
        user.setProjectId(updUser.getProjectId());
        user.setTaskId(updUser.getTaskId());
        return save(user);
    }

    public void deleteById(Integer userId) {
         userRepository.deleteById(userId);
    }
}