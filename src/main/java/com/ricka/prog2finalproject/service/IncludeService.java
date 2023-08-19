package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class IncludeService {
    private IncludeRepository includeRepository;

    public ResponseEntity<List<Include>> getAllIncludes(){
        try {
            return ResponseEntity.ok(this.includeRepository.getAll());
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
