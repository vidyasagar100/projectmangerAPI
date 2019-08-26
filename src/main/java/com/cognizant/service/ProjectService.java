package com.cognizant.service;

import com.cognizant.data.Project;
import com.cognizant.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project findById(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException());
    }

    public Project updateProject(Integer projectId, Project updProject) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException());
        project.setPriority(updProject.getPriority());
        project.setProjectDesc(updProject.getProjectDesc());
        project.setStartDate(updProject.getStartDate());
        project.setEndDate(updProject.getEndDate());
        project.setManagerId(updProject.getManagerId());
        project.setStatus(updProject.getStatus());
        return save(project);
    }
}
