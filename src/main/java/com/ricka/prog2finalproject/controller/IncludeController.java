package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.service.IncludeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IncludeController {
    private IncludeService includeService;

    @GetMapping("/includes")
    public List<Include> getAllIncludes(HttpServletResponse response){
        return this.includeService.getAll(response);
    }

    @GetMapping("/include/{id}")
    public Include getIncludeById (HttpServletResponse response, @PathVariable Integer id){
        return this.includeService.getById(response,id);
    }

    @DeleteMapping("/include/{id}")
    public Include deleteIncludeById(HttpServletResponse response,@PathVariable Integer id){
        return this.includeService.deleteById(response,id);
    }

    @PostMapping("/include")
    public Include createInclude(HttpServletResponse response,@PathVariable Include newInclude){
        return this.includeService.createInclude(response,newInclude);
    }

}


