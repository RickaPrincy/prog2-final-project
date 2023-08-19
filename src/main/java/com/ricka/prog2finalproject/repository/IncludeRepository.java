package com.ricka.prog2finalproject.repository;
import com.ricka.prog2finalproject.model.Include;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class IncludeRepository extends RepositoryPostgresql<Include> {
    private Connection connection;
    public IncludeRepository(Connection connection) {
        super(connection,Include.class);
        this.connection = connection;
    }
}
