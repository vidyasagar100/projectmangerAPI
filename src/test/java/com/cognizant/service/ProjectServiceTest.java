package com.cognizant.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.data.Project;
import com.cognizant.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;


public class ProjectServiceTest {
    Project project = new Project();
    ProjectService projectService = new ProjectService();

    @Mock
    ProjectRepository projectRepository = Mockito.mock(ProjectRepository.class);

    @Before
    public void setUp() {
        project.setProjectId(101);
        project.setManagerId(102);
        project.setPriority(1);
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.now());
        project.setProjectDesc("ProjectTitle");
        projectService.projectRepository = projectRepository;
    }

    @Test
    public void getProjects() {
        ArrayList<Project> alProjects = new ArrayList<>();
        alProjects.add(project);
        when(projectRepository.findAll()).thenReturn(alProjects);
        List<Project> actualProjects = projectService.getProjects();
        assertEquals(1,actualProjects.size());
    }

    @Test
    public void save() {
        when(projectRepository.save(any(Project.class))).thenReturn(project);
        projectService.projectRepository = projectRepository;
        Project actualProject = projectService.save(project);
        assertEquals(actualProject.getProjectId(),project.getProjectId());
        assertEquals(actualProject.getManagerId(),project.getManagerId());
        assertEquals(actualProject.getPriority(),project.getPriority());
        assertEquals(actualProject.getStartDate(),project.getStartDate());
        assertEquals(actualProject.getEndDate(),project.getEndDate());
        assertEquals(actualProject.getProjectDesc(),project.getProjectDesc());
    }

    @Test
    public void findById() {
        java.util.Optional<Project> optionalUser = java.util.Optional.of(project);
        when(projectRepository.findById(isA(Integer.class))).thenReturn(optionalUser);
        projectService.projectRepository = projectRepository;
        Project actualProject = projectService.findById(101);
        assertEquals(actualProject.getProjectId(),project.getProjectId());
        assertEquals(actualProject.getManagerId(),project.getManagerId());
        assertEquals(actualProject.getPriority(),project.getPriority());
        assertEquals(actualProject.getStartDate(),project.getStartDate());
        assertEquals(actualProject.getEndDate(),project.getEndDate());
        assertEquals(actualProject.getProjectDesc(),project.getProjectDesc());
    }

    @Test
    public void updateProject() {
        java.util.Optional<Project> optionalUser = java.util.Optional.of(project);
        when(projectRepository.findById(isA(Integer.class))).thenReturn(optionalUser);
        when(projectRepository.save(any(Project.class))).thenReturn(project);
        projectService.projectRepository = projectRepository;
        Project actualProject = projectService.updateProject(101,project);
        assertEquals(actualProject.getProjectId(),project.getProjectId());
        assertEquals(actualProject.getManagerId(),project.getManagerId());
        assertEquals(actualProject.getPriority(),project.getPriority());
        assertEquals(actualProject.getStartDate(),project.getStartDate());
        assertEquals(actualProject.getEndDate(),project.getEndDate());
        assertEquals(actualProject.getProjectDesc(),project.getProjectDesc());
    }
}