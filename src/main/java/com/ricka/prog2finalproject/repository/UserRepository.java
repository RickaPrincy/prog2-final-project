package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import org.springframework.stereotype.Repository;
import java.sql.Connection;

@Repository
public class UserRepository extends BasicRepositoryPostgresql<User> {
    public UserRepository(Connection connection) {
        super(connection,User.class);
    }
}
