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

    private List<Object> getArgs(Task task){
        List<Object> args = new ArrayList<>();
        args.add(task.getTitle());
        args.add(task.getStatus());
        args.add(task.getStartDate());
        args.add(task.getEndDate());
        args.add(task.getPriority());
        args.add(task.getUserId());
        args.add(task.getProjectId());
        args.add(task.getTagId());
        return args;
    }
    public Task createTask (HttpServletResponse response, Task task){
        return this.updateDb(response,this.getArgs(task).toArray(), HttpMethod.POST);
    }

    public Task updateTask(HttpServletResponse response, Integer id, Task task){
        List<Object> args = this.getArgs(task);
        args.add(0,id);
        return this.updateDb(response,args.toArray(),HttpMethod.PUT);
    }
}