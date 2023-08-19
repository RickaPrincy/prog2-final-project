package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
