package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.service.TaskService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private TaskService taskService;
    @GetMapping("/tasks")
    public List<Task> getAllTasks(HttpServletResponse response){
        return this.taskService.getAllTasks(response);
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(HttpServletResponse response, @PathVariable Integer id) {
        return this.taskService.getTaskById(response, id);
    }
}
