package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.Task;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class TaskRepository extends RepositoryPostgresql<Task> {
    private Connection connection;
    public TaskRepository(Connection connection) {
        super(connection,Task.class);
        this.connection = connection;
    }
}
