package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BasicService<Project> {
    public ProjectService(ProjectRepository projectRepository){
        super(projectRepository);
    }
}
