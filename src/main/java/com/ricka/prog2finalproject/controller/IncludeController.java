package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.service.IncludeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/includes")
public class IncludeController {
    private IncludeService includeService;

    @GetMapping
    public List<Include> getAllIncludes(HttpServletResponse response){
        return this.includeService.getAll(response);
    }

    @GetMapping("/{id}")
    public Include getIncludeById (HttpServletResponse response, @PathVariable Integer id){
        return this.includeService.getById(response,id);
    }

    @DeleteMapping("/{id}")
    public Include deleteIncludeById(HttpServletResponse response,@PathVariable Integer id){
        return this.includeService.deleteById(response,id);
    }

    @PostMapping
    public Include createInclude(HttpServletResponse response,@RequestBody Include include){
        return this.includeService.createInclude(response,include);
    }

    @PutMapping("/{id}")
    public Include updateInclude(HttpServletResponse response, @PathVariable Integer id, @RequestBody Include include){
        return this.includeService.updateInclude(response,id,include);
    }

    @PatchMapping("/{id}")
    public Include updatePartialInclude(HttpServletResponse response, @PathVariable Integer id, @RequestBody Include include){
        return this.includeService.updatePartialInclude(response,id,include);
    }
}