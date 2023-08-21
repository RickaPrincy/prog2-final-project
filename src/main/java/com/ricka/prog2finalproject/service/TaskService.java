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
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }
}
