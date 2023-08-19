package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return this.projectService.getAllProjects();
    }
}
