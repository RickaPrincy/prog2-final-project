package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.service.ProjectService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("projects")
    public List<Project> getAllProjects(HttpServletResponse response){
        return this.projectService.getAll(response);
    }

    @GetMapping("projects/{id}")
    public Project getProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.getById(response, id);
    }

    @DeleteMapping("projects/{id}")
    public Project deleteProjectById(HttpServletResponse response, @PathVariable Integer id){
        return this.projectService.deleteById(response,id);
    }

    @PostMapping("projects")
    public Project createProject(HttpServletResponse response, @RequestBody Project project){
        return this.projectService.createProject(response,project);
    }

    @PutMapping("projects/{id}")
    public Project updateProject(HttpServletResponse response,@PathVariable Integer id,@RequestBody Project project){
        return this.projectService.updateProject(response,id,project);
    }

    @PatchMapping("projects/{id}")
    public Project updatePartialProject(HttpServletResponse response,@PathVariable Integer id,@RequestBody Project project){
        return this.projectService.updatePartialProject(response,id,project);
    }

    @GetMapping("users/{id}/projects")
    public List<Project> getProjectByUser(HttpServletResponse response,@PathVariable Integer id){
        return this.projectService.getByField(response,"userId", id);
    }
}