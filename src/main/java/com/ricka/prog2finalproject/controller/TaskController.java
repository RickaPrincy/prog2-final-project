package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private TaskRepository taskRepository;
    @GetMapping("/")
    public List<Task> getAllTasks(){
        return this.taskRepository.getAll();
    }
}
