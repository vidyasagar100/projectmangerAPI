package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.data.User;
import com.cognizant.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    User user = new User();
    UserService userService = new UserService();

    @Before
    public void setUp() {
        user.setUserId(101);
        user.setFirstName("Vidyasagar");
        user.setLastName("Makilan");
        user.setEmployeeId(194666);
        userService.userRepository = userRepository;
    }

    @Mock
    UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Test
    public void getUsers() {
        ArrayList<User> alUser = new ArrayList<>();
        alUser.add(user);
        when(userRepository.findAll()).thenReturn(alUser);
        List<User> actualUsers = userService.getUsers();
        assertEquals(1,actualUsers.size());
    }

    @Test
    public void save() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.userRepository = userRepository;
        User actualUsers = userService.save(user);
        assertEquals(actualUsers.getEmployeeId(),user.getEmployeeId());
        assertEquals(actualUsers.getFirstName(),user.getFirstName());
        assertEquals(actualUsers.getLastName(),user.getLastName());
        assertEquals(actualUsers.getUserId(),user.getUserId());
    }

    @Test
    public void findById() {
        java.util.Optional<User> optionalUser = java.util.Optional.of(user);
        when(userRepository.findById(isA(Integer.class))).thenReturn(optionalUser);
        userService.userRepository = userRepository;
        User actualUsers = userService.findById(101);
        assertEquals(actualUsers.getEmployeeId(),user.getEmployeeId());
        assertEquals(actualUsers.getFirstName(),user.getFirstName());
        assertEquals(actualUsers.getLastName(),user.getLastName());
        assertEquals(actualUsers.getUserId(),user.getUserId());
    }

    @Test
    public void updateUser() {
        java.util.Optional<User> optionalUser = java.util.Optional.of(user);
        when(userRepository.findById(isA(Integer.class))).thenReturn(optionalUser);
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.userRepository = userRepository;
        User updatedUser = userService.updateUser(101,user);
        assertEquals(updatedUser.getEmployeeId(),user.getEmployeeId());
        assertEquals(updatedUser.getFirstName(),user.getFirstName());
        assertEquals(updatedUser.getLastName(),user.getLastName());
        assertEquals(updatedUser.getUserId(),user.getUserId());
    }

    @Test
    public void deleteById() {
        java.util.Optional<User> optionalUser = java.util.Optional.of(user);
        doNothing().when(userRepository).deleteById(isA(Integer.class));
        userService.userRepository = userRepository;
        userService.deleteById(101);
        verify(userRepository,times(1)).deleteById(101);
    }
}