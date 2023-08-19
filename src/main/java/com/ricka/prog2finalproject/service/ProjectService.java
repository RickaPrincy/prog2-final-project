package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        try {
            return this.projectRepository.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
