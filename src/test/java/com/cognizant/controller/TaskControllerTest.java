package com.cognizant.controller;


import java.util.ArrayList;

import com.cognizant.data.Task;
import com.cognizant.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TaskControllerTest {
    TaskService taskService = Mockito.mock(TaskService.class);
    TaskController taskController = new TaskController();

    @Before
    public void setup(){
        taskController.taskService = taskService;
    }

    @Test
    public void getAll() {
        when(taskService.getTasks()).thenReturn(new ArrayList<>());
        taskController.getAll();
        verify(taskController.taskService,times(1)).getTasks();
    }


    @Test
    public void createtask() {
        Task task = new Task();
        when(taskService.save(task)).thenReturn(task);
        taskController.createTask(task);
        verify(taskService,times(1)).save(task);
    }

    @Test
    public void gettaskById() {
        Task task = new Task();
        when(taskService.findById(101)).thenReturn(task);
        taskController.getTaskById(101);
        verify(taskService,times(1)).findById(101);
    }

    @Test
    public void updatetask() {
        Task task = new Task();
        when(taskService.updateTask(101,task)).thenReturn(task);
        taskController.updateTask(101,task);
        verify(taskService,times(1)).updateTask(101,task);
    }
}