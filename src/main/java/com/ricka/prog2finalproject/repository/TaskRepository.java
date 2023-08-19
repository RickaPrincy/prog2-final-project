package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.Task;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class TaskRepository extends RepositoryPostgresql<Task> {
    public TaskRepository(Connection connection) {
        super(connection,Task.class);
    }
}
