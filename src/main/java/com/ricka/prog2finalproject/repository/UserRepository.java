package com.ricka.prog2finalproject.repository;

import com.ricka.prog2finalproject.model.User;
import org.springframework.stereotype.Repository;
import java.sql.Connection;

@Repository
public class UserRepository extends RepositoryPostgresql<User>{
    private Connection connection;
    public UserRepository(Connection connection) {
        super(connection,User.class);
        this.connection = connection;
    }
}
