package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.Tag;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class TagRepository extends RepositoryPostgresql<Tag> {
    private Connection connection;
    public TagRepository(Connection connection) {
        super(connection,Tag.class);
        this.connection = connection;
    }
}
