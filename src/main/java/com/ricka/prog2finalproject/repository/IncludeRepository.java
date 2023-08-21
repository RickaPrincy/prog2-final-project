package com.ricka.prog2finalproject.repository;
import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class IncludeRepository extends BasicRepositoryPostgresql<Include> {
    public IncludeRepository(Connection connection) {
        super(connection,Include.class);
    }
}
