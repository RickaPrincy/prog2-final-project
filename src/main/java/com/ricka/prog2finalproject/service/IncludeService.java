package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class IncludeService {
    private IncludeRepository includeRepository;

    public List<Include> getAllIncludes(HttpServletResponse response){
        try {
            return this.includeRepository.getAll();
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }

    public Include getIncludeById(HttpServletResponse response, Integer id){
        try {
            Include result = this.includeRepository.getById(id);
            return ResponseError.isNotFound(response, result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }
}
