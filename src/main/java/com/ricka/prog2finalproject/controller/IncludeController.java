package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.service.IncludeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class IncludeController {
    private IncludeService includeService;

    @GetMapping("/includes")
    public List<Include> getAllIncludes(HttpServletResponse response){
        return this.includeService.getAllIncludes(response);
    }
}
