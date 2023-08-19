package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncludeService {
    private IncludeRepository includeRepository;

    public List<Include> getAllIncludes(){
        return this.includeRepository.getAll();
    }
}
