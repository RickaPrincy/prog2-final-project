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
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }

    public Project getProjectById(HttpServletResponse response, Integer id){
        try {
            Project result = this.projectRepository.getById(id);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }
}
