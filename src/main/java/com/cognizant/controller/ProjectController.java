package com.cognizant.controller;

import com.cognizant.data.Project;
import com.cognizant.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAll(){
        List<Project> projects = projectService.getProjects();
        return projects;
    }

    @PostMapping("/projects/create")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable(value = "id") Integer projectId){
        return projectService.findById(projectId);
    }

    @PutMapping("/projects/update/{id}")
    public Project updateProject(@PathVariable(value = "id") Integer projectId, @Valid @RequestBody Project project) {
        return projectService.updateProject(projectId,project);
    }

}
