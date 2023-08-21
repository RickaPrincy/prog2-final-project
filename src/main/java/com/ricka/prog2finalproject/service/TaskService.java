package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends BasicService<Task>{
    public TaskService(TaskRepository taskRepository){
        super(taskRepository);
    }
}
