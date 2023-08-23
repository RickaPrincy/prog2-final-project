package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BasicService<User>{
    public UserService(UserRepository userRepository){
        super(userRepository);
    }
    public User createUser(HttpServletResponse response, User newUser){
        List<Object> args = new ArrayList<>();
        args.add(newUser.getName());
        args.add(newUser.getEmail());
        args.add(newUser.getPassword());
        return this.updateDb(response,args.toArray(), HttpMethod.POST);
    }
}

