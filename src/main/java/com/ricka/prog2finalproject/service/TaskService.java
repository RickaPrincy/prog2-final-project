package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.repository.TaskRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService extends BasicService<Task>{
    public TaskService(TaskRepository taskRepository){
        super(taskRepository);
    }
    public Task createTask (HttpServletResponse response, Task newTask){
        List<Object> args = new ArrayList<>();
        args.add(newTask.getTitle());
        args.add(newTask.getStatus());
        args.add(newTask.getStartDate());
        args.add(newTask.getEndDate());
        args.add(newTask.getPriority());
        args.add(newTask.getUserId());
        args.add(newTask.getProjectId());
        args.add(newTask.getTagId());

        return this.updateDb(response,args.toArray(), HttpMethod.POST);
    }
}
