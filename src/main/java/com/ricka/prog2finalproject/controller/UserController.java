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

    @GetMapping("/users/{id}")
    public User getUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.getById(response,id);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.deleteById(response,id);
    }

    @PostMapping("/users")
    public User createTag(HttpServletResponse response, @RequestBody  User user){
        return this.userService.createUser(response,user);
    }

    @PutMapping("/users/{id}")
    public User updaUser(HttpServletResponse response,@PathVariable Integer id,@RequestBody User user){
        return this.userService.updateUser(response,id,user);
    }

    @PatchMapping("/users/{id}")
    public User updaPartialUser(HttpServletResponse response,@PathVariable Integer id,@RequestBody User user){
        return this.userService.updatePartialUser(response,id,user);
    }

    @GetMapping("/tasks/{id}/users")
    public List<User> getUserByTask(HttpServletResponse response,@PathVariable Integer id){
        return this.userService.getByField(response,"taskId", id);
    }

    @GetMapping("/projects/{id}/users")
    public List<User> getUserByProject(HttpServletResponse response,@PathVariable Integer id){
        return this.userService.getByField(response,"projectId", id);
    }
}