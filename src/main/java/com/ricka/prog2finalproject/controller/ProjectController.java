package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.service.ProjectService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@RestController
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects(HttpServletResponse response){
        return this.projectService.getAll(response);
    }

    @GetMapping("/project/{id}")
    public Project getProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.getById(response, id);
    }

    @DeleteMapping("/project/{id}")
    public Project deleteProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.deleteById(response,id);
    }
}
