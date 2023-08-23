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

    private List<Object> getArgs(User user){
        List<Object> args = new ArrayList<>();
        args.add(user.getName());
        args.add(user.getEmail());
        args.add(user.getPassword());
        return args;
    }

    public User createUser(HttpServletResponse response, User user){
        return this.updateDb(response,this.getArgs(user).toArray(), HttpMethod.POST);
    }

    public User updateUser(HttpServletResponse response, Integer id,User user){
        List<Object> args = this.getArgs(user);
        args.add(0,id);
        return this.updateDb(response,args.toArray(), HttpMethod.PUT);
    }
}