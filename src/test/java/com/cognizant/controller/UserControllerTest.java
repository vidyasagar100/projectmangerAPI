package com.cognizant.controller;

import java.util.ArrayList;

import com.cognizant.data.Project;
import com.cognizant.data.User;
import com.cognizant.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {


    UserService userService = Mockito.mock(UserService.class);
    UserController userController = new UserController();

    @Before
    public void setup(){
        userController.userService = userService;
    }

    @Test
    public void getAll() {
        when(userService.getUsers()).thenReturn(new ArrayList<>());
        userController.getAll();
        verify(userController.userService,times(1)).getUsers();
    }

    @Test
    public void createUser() {
        User user = new User();
        when(userService.save(user)).thenReturn(user);
        userController.createUser(user);
        verify(userService,times(1)).save(user);
    }

    @Test
    public void getUserById() {
        User user = new User();
        when(userService.findById(101)).thenReturn(user);
        userController.getUserById(101);
        verify(userService,times(1)).findById(101);
    }

    @Test
    public void updateUser() {
        User user = new User();
        when(userService.updateUser(101,user)).thenReturn(user);
        userController.updateUser(101,user);
        verify(userService,times(1)).updateUser(101,user);
    }

    @Test
    public void deletebyUserId() {
        doNothing().when(userService).deleteById(101);
        userController.deletebyUserId(101);
        verify(userService,times(1)).deleteById(101);
    }
}