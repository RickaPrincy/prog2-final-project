package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Project;
import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.service.TagService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TagController {
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAllTasks(HttpServletResponse response){
        return this.tagService.getAll(response);
    }

    @GetMapping("/tag/{id}")
    public Tag getTagById(HttpServletResponse response, @PathVariable Integer id) {
        return this.tagService.getById(response, id);
    }

    @DeleteMapping("/tag/{id}")
    public Tag deleteTagById(HttpServletResponse response, @PathVariable Integer id){
        return this.tagService.deleteById(response,id);
    }
}
