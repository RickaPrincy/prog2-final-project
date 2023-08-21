package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class TagRepository extends BasicRepositoryPostgresql<Tag> {
    public TagRepository(Connection connection) {
        super(connection,Tag.class);
    }
}
