package com.cognizant.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.data.Project;
import com.cognizant.data.Task;
import com.cognizant.repository.ProjectRepository;
import com.cognizant.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class TaskServiceTest {

    Task task = new Task();
    TaskService taskService = new TaskService();

    @Mock
    TaskRepository taskRepository = Mockito.mock(TaskRepository.class);

    @Before
    public void setUp() {
        task.setTaskId(101);
        task.setTaskDesc("Task");
        task.setParentId(1);
        task.setPriority(1);
        task.setStartDate(LocalDate.now());
        task.setEndDate(LocalDate.now());
        task.setUserId(1);
        taskService.taskRepository = taskRepository;
    }

    @Test
    public void getTasks() {
        ArrayList<Task> alTasks = new ArrayList<>();
        alTasks.add(task);
        taskService.taskRepository = taskRepository;
        when(taskRepository.findAll()).thenReturn(alTasks);
        List<Task> actualProjects = taskService.getTasks();
        assertEquals(1,actualProjects.size());
    }

    @Test
    public void save() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        taskService.taskRepository = taskRepository;
        Task actualTasks = taskService.save(task);
        assertEquals(actualTasks.getProjectId(),task.getProjectId());
        assertEquals(actualTasks.getTaskDesc(),task.getTaskDesc());
        assertEquals(actualTasks.getPriority(),task.getPriority());
        assertEquals(actualTasks.getStartDate(),task.getStartDate());
        assertEquals(actualTasks.getEndDate(),task.getEndDate());
        assertEquals(actualTasks.getUserId(),task.getUserId());
    }

    @Test
    public void findById() {
        java.util.Optional<Task> optionalTask = java.util.Optional.of(task);
        when(taskRepository.findById(isA(Integer.class))).thenReturn(optionalTask);
        taskService.taskRepository = taskRepository;
        Task actualTasks = taskService.findById(101);
        assertEquals(actualTasks.getProjectId(),task.getProjectId());
        assertEquals(actualTasks.getTaskDesc(),task.getTaskDesc());
        assertEquals(actualTasks.getPriority(),task.getPriority());
        assertEquals(actualTasks.getStartDate(),task.getStartDate());
        assertEquals(actualTasks.getEndDate(),task.getEndDate());
        assertEquals(actualTasks.getUserId(),task.getUserId());
    }

    @Test
    public void updateTask() {
        java.util.Optional<Task> optionalTask = java.util.Optional.of(task);
        when(taskRepository.findById(isA(Integer.class))).thenReturn(optionalTask);
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        taskService.taskRepository = taskRepository;
        Task actualTasks = taskService.updateTask(101,task);
        assertEquals(actualTasks.getProjectId(),task.getProjectId());
        assertEquals(actualTasks.getTaskDesc(),task.getTaskDesc());
        assertEquals(actualTasks.getPriority(),task.getPriority());
        assertEquals(actualTasks.getStartDate(),task.getStartDate());
        assertEquals(actualTasks.getEndDate(),task.getEndDate());
        assertEquals(actualTasks.getUserId(),task.getUserId());
    }

    @Test
    public void getTasksByProjectId() {
        ArrayList<Task> alTasks = new ArrayList<>();
        alTasks.add(task);
        taskService.taskRepository = taskRepository;
        when(taskRepository.findByProjectId(isA(Integer.class))).thenReturn(alTasks);
        when(taskRepository.getOne(isA(Integer.class))).thenReturn(task);
        List<Task> actualProjects = taskService.getTasksByProjectId(101);
        assertEquals(1,actualProjects.size());
        assertNotNull(actualProjects.get(0).getParentTaskDesc());
    }
}