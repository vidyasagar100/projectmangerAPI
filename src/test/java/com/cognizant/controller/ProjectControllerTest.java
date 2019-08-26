package com.cognizant.controller;

import java.util.ArrayList;

import com.cognizant.data.Project;
import com.cognizant.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProjectControllerTest {

    ProjectService projectService = Mockito.mock(ProjectService.class);
    ProjectController projectController = new ProjectController();

    @Before
    public void setup(){
        projectController.projectService = projectService;
    }

    @Test
    public void getAll() {
        when(projectService.getProjects()).thenReturn(new ArrayList<>());
        projectController.getAll();
        verify(projectController.projectService,times(1)).getProjects();
    }


    @Test
    public void createProject() {
        Project project = new Project();
        when(projectService.save(project)).thenReturn(project);
        projectController.createProject(project);
        verify(projectService,times(1)).save(project);
    }

    @Test
    public void getProjectById() {
        Project project = new Project();
        when(projectService.findById(101)).thenReturn(project);
        projectController.getProjectById(101);
        verify(projectService,times(1)).findById(101);
    }

    @Test
    public void updateProject() {
        Project project = new Project();
        when(projectService.updateProject(101,project)).thenReturn(project);
        projectController.updateProject(101,project);
        verify(projectService,times(1)).updateProject(101,project);
    }
}