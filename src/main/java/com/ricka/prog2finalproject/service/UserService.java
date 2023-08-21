package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers(HttpServletResponse response){
        try {
            return this.userRepository.getAll();
        } catch (SQLException error) {
            return  ResponseError.InternalServerError(response,error);
        }
    }

    public User getUserById(HttpServletResponse response,Integer id){
        try {
            User result = this.userRepository.getById(id);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return  ResponseError.InternalServerError(response,error);
        }
    }

}

