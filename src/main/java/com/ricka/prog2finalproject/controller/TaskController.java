package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.service.TaskService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private TaskService taskService;
    @GetMapping("/tasks")
    public List<Task> getAllTasks(HttpServletResponse response){
        return this.taskService.getAll(response);
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(HttpServletResponse response, @PathVariable Integer id) {
        return this.taskService.getById(response, id);
    }

    @DeleteMapping("/task/{id}")
    public Task deleteTaskById(HttpServletResponse response, @PathVariable Integer id){
        return this.taskService.deleteById(response,id);
    }

    @PostMapping("/task")
    public Task createTask(HttpServletResponse response, @PathVariable Task newTask){
        return this.taskService.createTask(response,newTask);
    }
}
