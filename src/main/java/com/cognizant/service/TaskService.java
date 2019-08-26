package com.cognizant.service;

import com.cognizant.data.Task;
import com.cognizant.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(Integer taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException());
    }

    public Task updateTask(Integer taskId, Task updTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException());
        task.setTaskDesc(updTask.getTaskDesc());
        task.setPriority(updTask.getPriority());
        task.setParentId(updTask.getParentId());
        task.setStartDate(updTask.getStartDate());
        task.setEndDate(updTask.getEndDate());
        task.setProjectId(updTask.getProjectId());
        task.setUserId(updTask.getUserId());
        task.setTaskId(taskId);
        return save(task);
    }

    public List<Task> getTasksByProjectId(Integer taskId) {
        List<Task> alTasks = taskRepository.findByProjectId(taskId);
        for(Task t:alTasks) {
            if(t.getParentId()!=null) {
                Task parentTask = taskRepository.getOne(t.getParentId());
                t.setParentTaskDesc(parentTask.getTaskDesc());
            }
        }
        //alTasks.stream().filter(t -> t.getParentId()!=null).forEach(e-> {e.setParentTaskDesc(taskRepository.getOne(e.getTaskId()).getTaskDesc());
        return alTasks;
    }
}
