package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        try {
            return this.userRepository.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

