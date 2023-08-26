package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.service.ProjectService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects(HttpServletResponse response){
        return this.projectService.getAll(response);
    }

    @GetMapping("/{id}")
    public Project getProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.getById(response, id);
    }

    @DeleteMapping("/{id}")
    public Project deleteProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.deleteById(response,id);
    }

    @PostMapping
    public Project createProject(HttpServletResponse response, @RequestBody Project project){
        return this.projectService.createProject(response,project);
    }

    @PutMapping("/{id}")
    public Project updateProject(HttpServletResponse response,@PathVariable Integer id,@RequestBody Project project){
        return this.projectService.updateProject(response,id,project);
    }

    @PatchMapping("/{id}")
    public Project updatePartialProject(HttpServletResponse response,@PathVariable Integer id,@RequestBody Project project){
        return this.projectService.updatePartialProject(response,id,project);
    }
}