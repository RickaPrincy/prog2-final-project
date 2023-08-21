package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import org.springframework.stereotype.Service;

@Service
public class IncludeService extends BasicService<Include>{
    public IncludeService(IncludeRepository includeRepository){
        super(includeRepository);
    }
}
