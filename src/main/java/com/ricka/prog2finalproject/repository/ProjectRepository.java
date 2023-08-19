package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.Project;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class ProjectRepository extends BasicRepositoryPostgresql<Project> {
    public ProjectRepository(Connection connection) {
        super(connection,Project.class);
    }
}
