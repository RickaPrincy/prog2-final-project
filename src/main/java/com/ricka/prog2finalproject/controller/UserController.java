package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user")
    public User createTag(HttpServletResponse response, @RequestBody  User user){
        return this.userService.createUser(response,user);
    }

    @PutMapping("/user/{id}")
    public User updaUser(HttpServletResponse response,@PathVariable Integer id,@RequestBody User user){
        return this.userService.updateUser(response,id,user);
    }
}