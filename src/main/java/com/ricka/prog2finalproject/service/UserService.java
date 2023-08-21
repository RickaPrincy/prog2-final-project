package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.User;
import com.ricka.prog2finalproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BasicService<User>{
    public UserService(UserRepository userRepository){
        super(userRepository);
    }
}

