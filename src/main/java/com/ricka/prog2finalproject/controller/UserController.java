package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Task;
import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    @GetMapping("/users")
    public List<User> getAllUsers(HttpServletResponse response){
        return this.userService.getAll(response);
    }

    @GetMapping("/user/{id}")
    public User getUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.getById(response,id);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.deleteById(response,id);
    }
}
