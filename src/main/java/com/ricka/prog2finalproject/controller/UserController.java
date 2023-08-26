package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @GetMapping
    public List<User> getAllUsers(HttpServletResponse response){
        return this.userService.getAll(response);
    }

    @GetMapping("/{id}")
    public User getUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.getById(response,id);
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(HttpServletResponse response, @PathVariable Integer id){
        return this.userService.deleteById(response,id);
    }

    @PostMapping
    public User createTag(HttpServletResponse response, @RequestBody  User user){
        return this.userService.createUser(response,user);
    }

    @PutMapping("/{id}")
    public User updaUser(HttpServletResponse response,@PathVariable Integer id,@RequestBody User user){
        return this.userService.updateUser(response,id,user);
    }

    @PatchMapping("/{id}")
    public User updaPartialUser(HttpServletResponse response,@PathVariable Integer id,@RequestBody User user){
        return this.userService.updatePartialUser(response,id,user);
    }
}