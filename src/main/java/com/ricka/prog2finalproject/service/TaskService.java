package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.repository.TaskRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(HttpServletResponse response){
        try {
            return this.taskRepository.getAll();
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response,error);
        }
    }

    public Task getTaskById(HttpServletResponse response,Integer id){
        try {
            Task result = this.taskRepository.getById(id);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response,error);
        }
    }

}
