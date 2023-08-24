package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.repository.ProjectRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService extends BasicService<Project> {
    public ProjectService(ProjectRepository projectRepository){
        super(projectRepository);
    }

    private List<Object> getArgs(Project project){
        List<Object> args = new ArrayList<>();
        args.add(project.getName());
        args.add(project.getDescription());
        args.add(project.getStatus());
        args.add(project.getStartDate());
        args.add(project.getEndDate());
        args.add(project.getUserId());
        return args;
    }
    public Project createProject(HttpServletResponse response, Project project){
        return this.updateDb(response,this.getArgs(project).toArray(), HttpMethod.POST);
    }

    public Project updateProject(HttpServletResponse response, Integer id,Project project){
        List<Object> args = this.getArgs(project);
        args.add(0,id);
        return this.updateDb(response,args.toArray(), HttpMethod.POST);
    }

    public Project updatePartialProject(HttpServletResponse response, Integer id,Project project){
        List<Object> args = this.getArgs(project);
        args.add(0,id);
        return this.updateDb(response,args.toArray(), HttpMethod.PATCH);
    }
}