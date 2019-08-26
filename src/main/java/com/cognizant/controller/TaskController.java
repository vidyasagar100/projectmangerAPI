package com.cognizant.controller;

import com.cognizant.data.Task;
import com.cognizant.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAll(){
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }

    @PostMapping("/task/create")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Integer taskId){
        return taskService.findById(taskId);
    }

    @PutMapping("/task/update/{id}")
    public Task updateTask(@PathVariable(value = "id") Integer taskId, @Valid @RequestBody Task task) {
        return taskService.updateTask(taskId,task);
    }

    @GetMapping("/tasks/project/{id}")
    public List<Task> getTasksByProjectId(@PathVariable(value = "id") Integer taskId) {
        return taskService.getTasksByProjectId(taskId);
    }


}
