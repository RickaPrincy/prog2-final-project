package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.repository.ProjectRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(HttpServletResponse response){
        try {
            return this.projectRepository.getAll();
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }
}
