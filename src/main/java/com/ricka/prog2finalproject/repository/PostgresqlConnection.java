package com.ricka.prog2finalproject.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class PostgresqlConnection {
    private final String dbPassword = System.getenv("DB_PASSWORD");
    private final String dbUsername = System.getenv("DB_USERNAME");
    private final String dbUrl = System.getenv("DB_URL");

    @Bean
    public Connection getConnection(){
        try {
            return  DriverManager.getConnection(
                this.dbUrl,
                this.dbUsername,
                this.dbPassword
            );
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
}

