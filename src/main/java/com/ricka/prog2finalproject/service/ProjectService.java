package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.repository.ProjectRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService extends BasicService<Project> {
    public ProjectService(ProjectRepository projectRepository){
        super(projectRepository);
    }
    public Project createProject(HttpServletResponse response, Project newProject){
        List<Object> args = new ArrayList<>();
        args.add(newProject.getName());
        args.add(newProject.getDescription());
        args.add(newProject.getDescription());
        args.add(newProject.getStatus());
        args.add(newProject.getStartDate());
        args.add(newProject.getEndDate());
        args.add(newProject.getUserId());
        return this.create(response,args.toArray());
    }
}
